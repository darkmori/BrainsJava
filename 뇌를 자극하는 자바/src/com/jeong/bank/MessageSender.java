package com.jeong.bank;

abstract class MessageSender {

	String title;
	String senderName;

	public MessageSender(String title, String senderName) {
		// super();
		this.title = title;
		this.senderName = senderName;
	}

	abstract void sendMessage(String recipient);
}
