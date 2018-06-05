package chap09;

public class RandomExample1 {

	public static void main(String[] args) {

		for (int i = 1; i <= 6; i++) {
			double randomValue = Math.random();
			int value = (int) (randomValue * 45)+1;
			System.out.println(i + "번째 난수:" + value);
		}
		 System.out.println(Math.random());
		 System.out.println(Math.random());
		 System.out.println(Math.random());
	}

}
