import java.net.*;
import java.io.*;
public class ServerFileTransfer {

	public static void main (String [] args ) throws IOException {
		int filelength=2000000; 
		int readByte=0;
		int currentTot = 0;
		String l = null;
		System.out.println("Server Started Running");
		System.out.println("************************************");
		ServerSocket serverSocket = new ServerSocket(12789);
		Socket socket = serverSocket.accept();
		System.out.println("Server accepted connection from Client : " + socket);

		byte [] arraycnt  = new byte [filelength];
		InputStream inputStream = socket.getInputStream();
		FileOutputStream fileoutputstream = new FileOutputStream("ServerFile.txt");
		BufferedOutputStream boutputStream = new BufferedOutputStream(fileoutputstream);
		readByte = inputStream.read(arraycnt,0,arraycnt.length);
		currentTot = readByte;

		boutputStream.write(arraycnt, 0 , currentTot);
		boutputStream.flush();
		boutputStream.close();
		System.out.println("***** Received file from Client successfully *****");

		BufferedReader b = new BufferedReader(new FileReader("ServerFile.txt")); 
		
		while ((l = b.readLine()) != null) {
			System.out.println(l);
		}



		FileWriter f = new FileWriter("ServerFile.txt" ,true); 



		f.append("\nThis is line added from server");
		f.close();

		File fileTransfer = new File ("ServerFile.txt");
		arraycnt  = new byte [(int)fileTransfer.length()];
		FileInputStream fins = new FileInputStream(fileTransfer);
		BufferedInputStream bfin = new BufferedInputStream(fins);
		bfin.read(arraycnt,0,arraycnt.length);
		OutputStream os = socket.getOutputStream();
		System.out.println("Sending File from Server...");
		os.write(arraycnt,0,arraycnt.length);
		os.flush();
		socket.close();
		System.out.println("File transfer completed successfully");
	}
	public static void append(File aFile, String content) {
		FileWriter f;
		try {
			f = new FileWriter(aFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(f);
			f.append(content);
			f.close();

			System.out.println("Done!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

