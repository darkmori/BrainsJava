package com.jeong.bank;

public class AppCDInfo extends CDInfo implements Lendable {

	String borrower;
	String checkOutDate;
	byte state;

	AppCDInfo(String registerNo, String title) {
		super(registerNo, title);
	}

	@Override
	public void checkOut(String borrwer, String date) {
		if (state != 0)
			return;
		this.borrower = borrwer;
		this.checkOutDate = date;
		this.state = 1;
		System.out.println("*" + title + " CD가 대출되었습니다.");
		System.out.println("대출인: " + borrwer);
		System.out.println("대출날짜: " + date + "\n");
	}

	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		System.out.println("*" + title + "CD가 반납되었습니다\n");

	}

}
