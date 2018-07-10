package chap20;

import java.net.Socket;

public class ClientExample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: java ClientExample4 <user-name>");
			return;
		}
		try {
			Socket socket = new Socket("192.168.0.2", 9002);
			Thread thread1 = new SenderThread(socket, args[0]);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
