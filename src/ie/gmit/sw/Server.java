package ie.gmit.sw;

import java.io.*; 
import java.net.*; 

public class Server {
	
	int counter = 0;
	private ServerSocket socket; 
	private static final int SERVER_PORT = 7777; // No need for admin rights on 8080
	private volatile boolean running = true; // Control while loop
	
	private Server(){
		try { 
			
			socket = new ServerSocket(SERVER_PORT); //Start socket on the server side
			System.out.println("Server Started on 7777");
			
			System.out.println("Server listening on port: " + SERVER_PORT);
			
		} catch (IOException e) { // Error catching 
			System.out.println("Error" + e.getMessage());
		}
		
		while (running){ 
			try {
				Socket s = socket.accept();
				
				// Name thread and start
				new Thread(new Request(s), "Thread " + counter).start(); 
				
				//Increment counter
				counter++; 
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} // end while

	} // end server
	
	// Start the java application
	public static void main(String[] args) {
		new Server(); // Create an instance of Server
	}
	
	
	private class Request implements Runnable{ // is-a
		private Socket socket;
		
		private Request(Socket request) {
			this.socket = request;
		}

        public void run() {
            try{
            	
            	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Object command = in.readObject(); 
                System.out.println(command);
                
                String message = "<h1>Happy Days</h1>";
            	ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);
                
                // clean up
                out.flush();
                out.close(); 
                
            } catch (Exception e) { 
            	System.out.println("Error: " + socket.getRemoteSocketAddress());
            	e.printStackTrace();
            }
        }
	}// end Request
	
}// end Server