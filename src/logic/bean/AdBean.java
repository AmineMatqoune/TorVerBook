package logic.bean;

import javafx.scene.paint.Color;
import logic.ad.Ad;
import logic.highlight.Highlight;

public class AdBean {
	
	private final long id;
	private final String title;
	private final String description;
	private final String username;
	private final String adType;
	private final int price;
	private final int quantity;
	private final String category;
	private final Highlight highlight;
	private final Color textColor;
	private final Color bgColor;
	private final int thickness;
	private final String textFont;
	private boolean isFavourite = false;
	private final String startHighDate;
	private final String finishHighDate;
	private final String date;

	public AdBean(Ad ad) {
		id = ad.getId();
		title = ad.getTitle();
		description = ad.getDescription();
		username = ad.getOwnerUsername();
		adType = ad.getType().toString();
		price = ad.getPrice();
		category = ad.getCategory().toString();
		highlight = ad.getHighlight();
		textColor = ad.getTextColor();
		bgColor = ad.getBackgroundColor();
		thickness = ad.getThickness();
		textFont = ad.getFont();
		quantity = ad.getQuantity();
		startHighDate = ad.getStartHighlightStr();
		finishHighDate = ad.getFinishHighlightStr();
		date = ad.getDate();
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

	public String getUsername() {
		return username;
	}

	public String getAdType() {
		return adType;
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

	public int getQuantity() {
		return quantity;
	}

	public String getStartHighDate() {
		return startHighDate;
	}

	public String getFinishHighDate() {
		return finishHighDate;
	}

	public String getDate() {
		return date;
	}

	public Highlight getHighlight() {
		return highlight;
	}
}
