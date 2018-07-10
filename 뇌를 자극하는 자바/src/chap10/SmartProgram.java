package chap10;

import java.io.IOException;
import java.io.PrintWriter;

public class SmartProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt");
			String str1 = "내 귀는 소라껍질";
			String str2 = "바다 소리를 그리워 한다.";

			writer.printf("%s %s", str1, str2);
		} catch (IOException ioe) {
			// TODO: handle exception
			System.out.println("파일로 출력할수 없습니다.");
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
