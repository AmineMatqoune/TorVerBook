package logic.message;

import java.time.LocalDate;
import java.time.LocalTime;

import logic.account.User;

public final class Message {

	private String text;
	private LocalDate date;
	private LocalTime time;
	private User sender;
	private User receiver;

	public Message(String text, LocalDate date, LocalTime time, User sender, User receiver) {
		this.text = text;
		this.time = time;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
	}

	public String getText() {
		return text;
	}

	public User getSender() {
		return sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public LocalTime getTime() {
		return time;
	}

	public LocalDate getDate() {
		return date;
	}
	
}
