package chap20;

import java.io.*;
import java.net.*;

public class ClientExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.2", 9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String str = "Hello,Server";
			out.write(str.getBytes());
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ex) {
				
			}

		}
	}

}
