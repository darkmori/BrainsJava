package com.jeong.bank;

public interface Lendable {
	// 상수필드
	final static byte STATE_BORROWED = 1;
	final static byte STATE_NOMAL = 0;

	// void checkOut(String borrwer, String date);

	// void checkIn();

	// 추상메소드
	abstract void checkOut(String borrower, String date) throws Exception;

	abstract void checkIn();
}
