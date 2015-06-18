package FileTransfer;

import java.net.*;
import java.io.*;

public class Server implements Runnable {
	Socket sock;
	static int portNum;
	Server(Socket sock) {
		this.sock = sock;
	}
	public static void setPortNumber(int portNumber) {
		portNum = portNumber;
	}

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.err.println("Usage: java Server <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);
		setPortNumber(portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		while (true) {
			Socket clientSocket = serverSocket.accept();
			new Thread(new Server(clientSocket)).start();
		}
	}

	public void run() {
		try {
			PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String inputLine, outputLine;

			// Initiate conversation with client
			Protocol p = new Protocol();
			outputLine = p.processInput(null);
			out.println(outputLine);

			while ((inputLine = in.readLine()) != null) {
				outputLine = p.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.equals("DONE")) {
					File transferFile = new File("/home/zemoso02/assignments.txt");
					FileInputStream input = new FileInputStream(transferFile);
					OutputStream output = sock.getOutputStream();
					byte[] buf = new byte[(int) transferFile.length()];
					int bytesRead;
					while ((bytesRead = input.read(buf)) != -1) {
						output.write(buf, 0, bytesRead);
					}
					break;
				}
			}
			sock.close();
		}

		catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + portNum + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}