package logic.highlight;

import javafx.scene.paint.Color;
import logic.ad.*;


public final class Highlight implements HighlightInterface{
	
	//highlight info
	private int thickness;
	private int pricePerDay;
	private String font;
	private int levelOfVisibility;
	private Color textColor;
	private Color backgroundColor;
	private String style;
	private HighlightType hlType;
	
	public Highlight() {}
	
	//getters() and setters()
	public HighlightType getHighlightType() {
		return hlType;
	}

	public void setHighlightType(String hlType) {
		if (hlType.equals("SUPER")) 
			this.hlType = HighlightType.SUPER;
		else if (hlType.equals("MEDIUM")) 
			this.hlType = HighlightType.MEDIUM;
		else if (hlType.equals("BASE")) 
			this.hlType = HighlightType.BASE;	
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getLevelOfVisibility() {
		return levelOfVisibility;
	}

	public void setLevelOfVisibility(int levelOfVisibility) {
		this.levelOfVisibility = levelOfVisibility;
	}

	public int getThickness() {
		return this.thickness;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public String getFont() {
		return this.font;
	}
	
	public void setFont(String font) {
		this.font = font;
	}

	public Color getTextColor() {
		return textColor;
	}
	
	public void setTextColor(String textColor) {
		switch (textColor) {
		case "BLACK":
			this.textColor = Color.BLACK;
			break;
		case "BLUE":
			this.textColor = Color.BLUE;
			break;
		case "RED":
			this.textColor = Color.RED;
			break;
		default:
		}
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		switch (backgroundColor) {
		case "GREEN":
			this.backgroundColor = Color.GREEN;
			break;
		case "WHITE":
			this.backgroundColor = Color.WHITE;
			break;
		case "CYAN":
			this.backgroundColor = Color.CYAN;
			break;
		default:
		}
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	//behavioural methods inherited from interface	
	@Override
	public boolean isExpired() {
		return (Boolean)null;
	}
	
	@Override
	public void remove() {}
	
	@Override
	public int getPrice(int days) {return 0;}
	
	@Override
	public void getPeriod() {
		//return finishDate-startDate?
	}
}