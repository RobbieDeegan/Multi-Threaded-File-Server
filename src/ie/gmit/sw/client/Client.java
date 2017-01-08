package ie.gmit.sw.client;

import java.io.*; 
import java.net.*;
import ie.gmit.sw.server.*;

public class Client{
		
	public void connect() { 
		try { 
			Socket s = new Socket("localhost", 7777);
			
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			out.writeObject(new Server()); //Serialise
			out.flush();
			
			Thread.yield();
			
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			String response = (String) in.readObject(); //Deserialise
			
			String threadName = Thread.currentThread().getName(); 
			
			s.close(); // Tidy up
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} // end try/catch
	} // end run
		
}