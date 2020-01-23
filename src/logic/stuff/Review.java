package logic.stuff;

import logic.account.User;

public class Review {
	
	private String text;
	private String time;
	private float rank;
	
	private User writer;
	private User receiver;
	
	public Review(String text, String time, float rank, User writer, User receiver) {
		this.text = text;
		this.time = time;
		this.rank = rank;
		this.writer = writer;
		this.receiver = receiver;
	}	
	
	public User getWriter() {
		return writer;
	}
	
	public String getText() {
		return text;
	}
	
	public String getRank() {
		return String.valueOf(rank);
	}	
}
