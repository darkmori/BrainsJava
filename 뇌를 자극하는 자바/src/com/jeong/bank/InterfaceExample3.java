package com.jeong.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

class InterfaceExample3 {

	public static void main(String[] args) {

		SeparateVolume obj = new SeparateVolume("863ㅂ", "나무", "베르베르");

		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sf.format(date);

		// System.out.println(strDate);
		try {
			obj.checkOut("홍길동", strDate);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		printState(obj);
		// obj.checkOut("이수경", "20180518");
		// printState(obj);
	}

	static void printState(SeparateVolume obj) {
		if (obj.state == Lendable.STATE_NOMAL) {
			System.out.println("------------------------");
			System.out.println("대출상태: 대출가능");
			System.out.println("------------------------");
		}
		if (obj.state == Lendable.STATE_BORROWED) {
			System.out.println("------------------------");
			System.out.println("대출상태: 대출중");
			System.out.println("대출인: " + obj.borrower);
			System.out.println("대출 날짜: " + obj.checkOutDate);
			System.out.println("------------------------");
		}
	}

}
