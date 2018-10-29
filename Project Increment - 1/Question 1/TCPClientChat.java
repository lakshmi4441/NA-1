import java.io.*; 
import java.net.*; 
import java.util.Scanner;

import javax.naming.InitialContext;
class TCPClientChat { 

	public static void main(String argv[]) throws Exception 
	{ 
		String clientMessage = ""; 
		String returnMessage=""; 
		int flag=0;
		BufferedReader inFromUser = 
				new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Client Started Running");
		System.out.println("************************************");		
		String initialclientMessage="";		
			Socket clientSocket=null; 
			if(flag==0){
				System.out.println("Enter message: ");
				initialclientMessage = inFromUser.readLine(); 
			}
			if(initialclientMessage.startsWith("Hello from Client")){
				clientMessage=initialclientMessage;
			
			while(!returnMessage.startsWith("Bye from Server" )){
				
				clientSocket= new Socket("HOSTNAME", 12789);
				DataOutputStream outToServer = 
						new DataOutputStream(clientSocket.getOutputStream()); 
				BufferedReader inFromServer = 
						new BufferedReader(new
								InputStreamReader(clientSocket.getInputStream())); 
				if(flag==1){
					System.out.println("Enter message : ");
					clientMessage = inFromUser.readLine(); 
				}
				outToServer.writeBytes(clientMessage + '\n'); 

				returnMessage = inFromServer.readLine(); 

				System.out.println("Message from Server: " + returnMessage); 
				flag=1;
			}           
			clientSocket.close(); 
		}
        else{
             System.out.println("Enter correct message");
            }
		
	} 
} 