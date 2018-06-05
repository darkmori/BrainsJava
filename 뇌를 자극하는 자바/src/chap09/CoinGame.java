package chap09;

import java.util.Random;

public class CoinGame {

	public static void main(String[] args) {
		int fCount = 0, eCount = 0;
		for (int i = 1; i <= 10; i++) {
			Random random = new Random();
			System.out.println(random.nextInt(2));
			if (random.nextInt(2) == 0) {
				fCount++;
			} else {
				eCount++;
			}
		}
		System.out.println("앞면: " + fCount + ", 뒷면: " + eCount);
	}

}
