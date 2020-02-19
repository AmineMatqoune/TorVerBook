package torverbook.web.bean;

import javafx.scene.paint.Color;

public class AdBean {

	private final long id;
	private final String title;
	private final String description;
	private final int price;
	private final String category;
	private final Color textColor;
	private final Color bgColor;
	private final int thickness;
	private final String textFont;
	private boolean isFavourite = false;

	public AdBean(AdBean ad) {
		this.id = ad.getId();
		title = ad.getTitle();
		description = ad.getDescription();
		price = ad.getPrice();
		category = ad.getCategory();
		textColor = ad.getTextColor();
		bgColor = ad.getBackgroundColor();
		thickness = ad.getThickness();
		textFont = ad.getFont();
	}
	
	public long getId() {
		return id;
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

	public String getCategory() {
		return category;
	}

	public Color getTextColor() {
		return textColor;
	}
	
	public String getFont() {
		return this.textFont;
	}
	
	public int getThickness() {
		return this.thickness;
	}
	
	public Color getBackgroundColor() {
		return bgColor;
	}
	
	public boolean getFavourite() {
		return this.isFavourite;
	}
	
	public void setFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

}
