package com.jeong.bank;

class BonusPointAccount extends Account {
	int bonusPoint;

	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	@Override
	void deposit(int amount) {
		super.deposit(amount);
		bonusPoint += (int) (amount * 0.001);
	}

}
