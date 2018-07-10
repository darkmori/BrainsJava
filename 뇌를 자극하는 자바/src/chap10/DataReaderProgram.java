package chap10;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReaderProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream("output.dat"));

			int number1 = in.readInt();
			int number2 = in.readInt();
			double number3 = in.readByte();

			System.out.println("num1:" + number1);
			System.out.println("num2:" + number2);
			System.out.println("num3:" + number3);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일이 존재하지 않습니다.");
		} catch (EOFException eofe) {
			// TODO: handle exception
			System.out.println("끝");
		} catch (IOException ioe) {
			// TODO: handle exception
			System.out.println("파일을 읽을수 없습니다.");
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
