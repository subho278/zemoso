package FileTransfer;

import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.err.println("Usage: java Client <host name> <port number>");
			System.exit(1);
		}

		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);

		try (Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				) {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			String fromUser;

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals("DONE")) {
					//System.out.println("Server: " + fromServer);
					byte[] buf = new byte[6022386];
					InputStream input = socket.getInputStream();
					FileOutputStream output = new FileOutputStream("/home/zemoso02/saptarshi.txt");
					int bytesRead;
					while ((bytesRead = input.read(buf)) != -1) {
						output.write(buf, 0, bytesRead);
					}
					break;
				}
				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("Client: " + fromUser);
					out.println(fromUser);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to "+ hostName);
			System.exit(1);
		}
	}
}
