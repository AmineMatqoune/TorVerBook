package torverbook.web.bean;

import java.time.LocalDate;

import torverbook.web.ad.AdType;
import torverbook.web.utils.DateAndTimeUtils;

public class AddAdBean {

	private String title;
	private String description;
	private int price;
	private int quantity;
	private String course;
	private String type;
	private String highlight;
	private LocalDate startHighlight;
	private LocalDate endHighlight;

	public AddAdBean(String title, String description, int price, int quantity, String course, String type) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.course = course;
		this.type = type;
	}

	public boolean isValid() {
		return !(title.length() > 100 || title.isEmpty() || description.length() > 300 || description.isEmpty()
				|| checkType() || checkQuantity() || checkFromDate() || checkToDate());
	}

	private boolean checkType() {
		if (AdType.SALE.toString().contentEquals(type))
			return checkPrice();
		else
			return true;
	}

	private boolean checkPrice() {
		return price > 255;
	}

	private boolean checkQuantity() {
		return quantity > 255 || quantity <= 0;
	}

	private boolean checkFromDate() {
		return startHighlight.compareTo(LocalDate.now()) < 0;
	}

	private boolean checkToDate() {
		return endHighlight.compareTo(startHighlight) < 0;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCourse() {
		return course;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public LocalDate getStartHighlight() {
		return startHighlight;
	}

	public String getStartHighlightToString() {
		return DateAndTimeUtils.getDateStringFromLocalDate(startHighlight);
	}
	
	public void setStartHighlight(LocalDate startHighlight) {
		this.startHighlight = startHighlight;
	}
	
	public LocalDate getEndHighlight() {
		return endHighlight;
	}
	
	public String getEndHighlightToString() {
		return DateAndTimeUtils.getDateStringFromLocalDate(endHighlight);
	}

	public void setEndHighlightDate(LocalDate endHighlight) {
		this.endHighlight = endHighlight;
	}
}