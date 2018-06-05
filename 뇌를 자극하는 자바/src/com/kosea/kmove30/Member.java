package com.kosea.kmove30;

public class Member {
	int mno;
	String id;
	String password;

	public Member() {
		// 기본생성자
	}

	public Member(int mno, String id, String password) {
		super();
		this.mno = mno;
		this.id = id;
		this.password = password;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
