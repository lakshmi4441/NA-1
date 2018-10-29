import java.net.*;
import java.io.*;
class FileTransferFrmClient {

	public static void main (String [] args ) throws IOException {
		int filelength=2000000; 
		int readByte;
		String l = null;
		int datacnt = 0;
		System.out.println("Client Started Running");
		System.out.println("************************************");
		Socket clientSocket = new Socket("HOSTNAME",12789);
		File textsent = new File("ClientFile.txt");
		byte [] arraycount  = new byte [(int)textsent.length()];
		FileInputStream filein = new FileInputStream(textsent);
		BufferedInputStream buffin = new BufferedInputStream(filein);
		buffin.read(arraycount,0,arraycount.length);
		OutputStream o = clientSocket.getOutputStream();
		System.out.println("------ Sending File from Client ------");
		o.write(arraycount,0,arraycount.length);
		o.flush();
		System.out.println("***** File is sent successfully to Server *****");
		arraycount  = new byte [filelength];
		arraycount  = new byte [filelength];

		InputStream is = clientSocket.getInputStream();
		FileOutputStream fileOutputStream = new FileOutputStream("ClientFile.txt");
		BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
		readByte = is.read(arraycount,0,arraycount.length);
		datacnt = readByte;

		do {
			readByte =
					is.read(arraycount, datacnt, (arraycount.length-datacnt));
			if(readByte >= 0) datacnt += readByte;
		} while(readByte > -1);

		outputStream.write(arraycount, 0 , datacnt);
		outputStream.flush();
		outputStream.close();
		clientSocket.close();
		BufferedReader buffreader = new BufferedReader(new FileReader("ClientFile.txt")); 

		while ((l = buffreader.readLine()) != null) {
			System.out.println(l);
		}
		System.out.println("***** File successfully received from Server *****");
	}
}
