package ie.gmit.sw.client;

import java.util.*;

import ie.gmit.sw.client.config.Context;
import ie.gmit.sw.client.config.XMLParser;

public class Runner {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws Throwable{
		
		Context ctx = new Context();
		XMLParser cp = new XMLParser(ctx);
		cp.init();
		System.out.println(ctx);
		
		int choice = 0;
		
		System.out.println("1. Connect to Server");
		System.out.println("2. Print File Listing");
		System.out.println("3. Download File");
		System.out.println("4. Quit");
		choice = console.nextInt();
		
		while(choice != 4){
			
			// Connect to the server
			if(choice == 1){
				Client client = new Client();
				client.connect();
			}
			else if(choice == 2){
			
			}
			else if(choice == 3){
				
			}
		}
		
	}// End main
}// End class