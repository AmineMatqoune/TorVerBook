package logic.stuff;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Review {
	
	private String text;
	private Date time;
	private float rank;
	
	private String writer;
	private String receiver;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public Review(String text, String time, float rank, String writer, String receiver) throws ParseException {
		this.text = text;
		this.time = format.parse(time);
		this.rank = rank;
		this.writer = writer;
		this.receiver = receiver;
	}	
	
	public String getText() {
		return text;
	}
	
	public Date getTime() {
		return time;
	}
	
	public String getRank() {
		return String.valueOf(rank);
	}	
	
	public String getWriter() {
		return writer;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setDate(String date) throws ParseException {
		this.time = format.parse(date);
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setRank(float rank) {
		this.rank = rank;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
}