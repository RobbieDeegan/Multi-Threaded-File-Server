package ie.gmit.sw;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws Throwable{
		
		int choice = 0;
		
		System.out.println("1. Connect to Server");
		System.out.println("2. Print File Listing");
		System.out.println("3. Download File");
		System.out.println("4. Quit");
		choice = console.nextInt();
		
		while(choice != 4){
			
			if(choice == 1){
				
			}
			else if(choice == 2){
				
			}
			else if(choice == 3){
				
			}
			else if(choice == 4){
				
			}
		}
		
			new Thread(new Runnable(){
				
				public void run() { 
					try {
						Socket s = new Socket("localhost", 7777); //Connect to the server
						
						
					} catch (Exception e) { // Catch errors and display
						System.out.println("Error: " + e.getMessage());
					}//End of try /catch
				}// End of run()
				
			}, "Client-").start(); //Start the thread
		
		System.out.println("Main method will return now....");
		
	}//End main
}//End class