package ie.gmit.sw.server;

import java.io.*; 
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class Server {
	private ServerSocket serversocket;
	
	private static final int SERVER_PORT = 7777;  
	
	private volatile boolean keepRunning = true;
	
	public Server(){
		try { 
			
			serversocket = new ServerSocket(SERVER_PORT); 
			
			Thread server = new Thread(new Listener(), "Web Server Listener");
			server.setPriority(Thread.MAX_PRIORITY); 
			server.start(); //The Hollywood Principle 
			
			System.out.println("Server started and listening on port " + SERVER_PORT);
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	} // end Server
	
	// Start
	public static void main(String[] args) {
		new Server(); 
	}
	
	private class Listener implements Runnable{ // is-a
		
		public void run() {
			int counter = 0; 
			while (keepRunning){ 
				try {
					
					Socket s = serversocket.accept(); 
					
					new Thread(new HTTPRequest(s), "Thread " + counter).start(); 
					counter++; 
				} catch (IOException e) { 
					System.out.println("Error: " + e.getMessage());
				}
			}
		}// end run
		
	} // end listerner
	
	private class HTTPRequest implements Runnable{
		private Socket socket; 
		
		private HTTPRequest(Socket request) { 
			this.socket = request; 
		}

        public void run() {
            try{ 
            	
            	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Object command = in.readObject(); 
                
                Calendar now = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mma zzz 'on' dd MMMM yyyy");
                String message = formatter.format(now.getTime());
                
            	ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);
                out.flush();
                out.close(); 
                
            } catch (Exception e) { 
            	System.out.println("Error: " + socket.getRemoteSocketAddress());
            	e.printStackTrace();
            }
        } // end run
        
	} // end HTTPRequest
}