package logic.bean;

import logic.review.Review;

public class ReviewBean {
	
	private final String writer;
	private final String receiver;
	private final String text;
	private final String rank;

	public ReviewBean(Review review) {
		writer = review.getWriter();
		receiver = review.getReceiver();
		text = review.getText();
		rank = review.getRank()		;
	}

	public String getWriter() {
		return writer;
	}

	public String getText() {
		return text;
	}

	public String getRank() {
		return rank;
	}

	public String getReceiver() {
		return receiver;
	}
}