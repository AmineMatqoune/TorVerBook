package logic;

import java.util.Calendar;

import logic.account.User;

public final class Message {

	private String text;
	private Calendar time;
	private User sender;
	private User receiver;
	
	public Message(String text, Calendar time, User sender, User receiver) {
		this.text = text;
		this.time = time;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public String getText() {
		return text;
	}
	
	public Calendar getTime() {
		return time;
	}
	
	public User getSender() {
		return sender;
	}	
}
