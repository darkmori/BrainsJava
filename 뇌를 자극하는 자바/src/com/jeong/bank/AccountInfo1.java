package com.jeong.bank;

public class AccountInfo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account obj=new Account("999-88-777777", "연흥부", 10);
		System.out.printf("%s\n",obj.accountNo);
		System.out.printf("%s\n",obj.ownerName);
		System.out.printf("%d",obj.balance);
	}

}
