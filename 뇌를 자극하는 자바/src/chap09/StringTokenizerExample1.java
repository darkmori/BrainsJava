/**
 * 2018. 5. 14. Dev Jeong.K.S
 */
package chap09;

import java.util.StringTokenizer;

/**
 * @author Jeong.KS
 */
public class StringTokenizerExample1 {

	public static void main(String[] args) {
		StringTokenizer token = new StringTokenizer("사과,배?복숭아", ",?");

		// String str1 = "", str2 = "", str3 = "", str4 = "";
		//
		// if (token.hasMoreTokens())
		// str1 = token.nextToken();
		// if (token.hasMoreTokens())
		// str2 = token.nextToken();
		// if (token.hasMoreTokens())
		// str3 = token.nextToken();
		// if (token.hasMoreTokens())
		// str4 = token.nextToken();

		while (token.hasMoreTokens()) {

			String str = token.nextToken();
			System.out.println(str);
		}

		// System.out.println("str1 :" + str1);
		// System.out.println("str2 :" + str2);
		// System.out.println("str3 :" + str3);
		// System.out.println("str4 :" + str4);
	}

}
