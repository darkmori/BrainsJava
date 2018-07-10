package chap10;

import java.io.FileNotFoundException;
//import java.lang.*;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample1 {

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("poem.txt");
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
			reader.close();

		} catch (FileNotFoundException fnfe) {
			// TODO Auto-generated catch block
			fnfe.printStackTrace();
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을수 없습니다.");
		} finally {
			System.out.println("파일을 닫습니다.");
			try {
				reader.close();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
