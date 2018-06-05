package chap09;

import java.util.StringTokenizer;

public class TokenProgram {

	public static void main(String[] args) {
		StringTokenizer str = new StringTokenizer("고슴도치, 앵무새 | 토끼", " ,|");

		while (str.hasMoreTokens()) {

			String str1 = str.nextToken();
			System.out.println(str1);
		}
	}

}
