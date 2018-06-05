package chap09;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendatExample2 {

	public static void main(String[] args) {

		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone("");
		calendar.setTimeZone(timeZone);
	}

}
