package chap20;

import java.io.*;
import java.util.*;
import java.net.*;

public class PerClientThread extends Thread {
	static List<PrintWriter> list = java.util.Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket;
	PrintWriter writer;

	PerClientThread(Socket socket) {
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#" + name + "님이 들어오셨습니다");
			while (true) {
				String str = reader.readLine();
				if (str == null)
					break;
				sendAll(name + ">" + str);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			list.remove(writer);
			sendAll("#" + name + "님이 나가셨습니다.");
			try {
				socket.close();
			} catch (Exception ignored) {
				// TODO: handle exception
			}
		}
	}

	private void sendAll(String str) {
		// TODO Auto-generated method stub
		for (PrintWriter writer : list) {
			writer.println(str);
			writer.flush();
		}

	}
}
