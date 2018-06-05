package chap09;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomExample2 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());

		GregorianCalendar gCalendar = new GregorianCalendar();
		System.out.println(gCalendar.getTimeInMillis());

		Random random = new Random(date.getTime());
		Random rd = new Random(gCalendar.getTimeInMillis());
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		System.out.println(rd.nextInt(100));
		System.out.println(rd.nextInt(100));
		System.out.println(rd.nextInt(100));

		// Random random=new Random(349239L);
		// System.out.println(random.nextInt(100));
		// System.out.println(random.nextInt(100));
		// System.out.println(random.nextInt(100));
	}

}
