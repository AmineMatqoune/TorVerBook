package logic;

import java.util.Calendar;

import logic.account.User;

public class Review {
	
	private String text;
	private Calendar time;
	private float rank;
	
	private User writer;
	private User receiver;
	
	public Review(String text, Calendar time, float rank, User writer, User receiver) {
		this.text = text;
		this.time = time;
		this.rank = rank;
		this.writer = writer;
		this.receiver = receiver;
	}	
}
