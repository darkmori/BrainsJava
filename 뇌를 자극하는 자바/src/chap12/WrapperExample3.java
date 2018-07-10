package chap12;

public class WrapperExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strAry = { "1", "2", "3", "4", "5" };
		// int[] strAry = { 1, 2, 3, 4, 5 };
		int total = 0;

		for (int i = 0; i < strAry.length; i++) {
			total += Integer.parseInt(strAry[i]);
			System.out.println(strAry[i] + " ");
		}
		System.out.println("총계 " + total);

	}

}
