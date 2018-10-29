import java.io.*; 
import java.net.*; 

class TCPServerChat { 

	public static void main(String argv[]) throws Exception 
	{ 
		String serverMessage; 
		String returnMessage=""; 
		System.out.println("Server Started Running");
		System.out.println("************************************");	
		ServerSocket socketConn = new ServerSocket(12789); 

		while(true) { 


			Socket serverconnSocket = socketConn.accept(); 

			BufferedReader reqFromClient = 
					new BufferedReader(new
							InputStreamReader(serverconnSocket.getInputStream()));
			DataOutputStream  responseToClient = 
					new DataOutputStream(serverconnSocket.getOutputStream()); 

			serverMessage = reqFromClient.readLine(); 
			
			System.out.println("Message Received from Client : "+serverMessage);
			
			if(serverMessage.contains("Hello from Client")){
				String[] msg = serverMessage.split("-");
				System.out.println("Hello"+msg[1]);
				returnMessage = "Hello from Server-"+msg[1]+ '\n'; 
			}
			else if(serverMessage.startsWith("Bye from Client")){
				String[] msg = serverMessage.split("-");
				returnMessage = "Bye from Server-"+msg[1]+ '\n'; 
				responseToClient.writeBytes(returnMessage);
				break;
			}
			else{

				returnMessage = serverMessage+ '\n'; 
			}
			responseToClient.writeBytes(returnMessage); 
		} 
	} 
} 
