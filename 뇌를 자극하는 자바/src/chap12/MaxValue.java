package chap12;

public class MaxValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Usage: Java MaxValue <정수1> <정수2>");
			return;

		}

		System.out.println(args[0] + " " + args[1]);
		int maxValue = Integer.max(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("최대 값:" + maxValue);
	}

}
