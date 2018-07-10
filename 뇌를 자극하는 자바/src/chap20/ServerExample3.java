package chap20;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
