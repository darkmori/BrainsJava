
public class Prog {

	public static void main(String[] args) {

		int i = 1, j = 1, k = 0, sum = 2;
		for (int n = 3; n <= 10; n++) {
			k = i + j;
			sum = sum + k;
			i = j;
			j = k;
		}
		System.out.println(sum);
	}

}
