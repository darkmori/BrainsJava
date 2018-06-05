/**
 * 2018. 5. 1. Dev By Jeong.K.S
 * 
 * Variable.java
 */

public class Variable {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		int total = plus(num1, num2);

		System.out.println(total);
	}

	static int plus(int a, int b) {
		return a + b;
	}

}
