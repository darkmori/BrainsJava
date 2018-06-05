package chap09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class After100Days {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());// 현재시간 설정
		calendar.add(Calendar.DATE, 100);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String date = dateFormat.format(calendar.getTime());
		System.out.println(date);

	}

}
