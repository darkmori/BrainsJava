package chap08;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class DateTime {

	public static void main(String[] args) {
		GregorianCalendar gregori = new GregorianCalendar();
		int year = gregori.get(Calendar.YEAR);
		int month = gregori.get(Calendar.MONTH) + 1;
		int day = gregori.get(Calendar.DAY_OF_MONTH);

		System.out.printf("오늘은 %d년 %d월 %d일 입니다.\n", year, month, day);
	}

}
