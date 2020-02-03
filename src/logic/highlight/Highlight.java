package logic.highlight;

import javafx.scene.paint.Color;
import logic.ad.*;


public final class Highlight implements HighlightInterface{
	
	//highlight info for user
	private HighlightType hlType;
	private int thickness;
	private int pricePerDay;
	private String font;
	
	//highlight info for system
	private int levelOfVisibility;
	private Color textColor;
	private String rgbColor;
	private String style;
	
	
	public Highlight(HighlightType type) {
		if (type == HighlightType.BASE)
			initBaseHighlight();
		else if (type == HighlightType.MEDIUM)
			initMediumHighlight();
		else initSuperHighlight();
	}
	
	private void initBaseHighlight() {
		hlType = HighlightType.BASE;
		thickness = 12;
		pricePerDay = 0;
		font = "Times New Roman";
		textColor = Color.BLACK;
		rgbColor = "#024a00";
		levelOfVisibility = 0;
		style = "Regular";
	}
	
	private void initMediumHighlight() {
		hlType = HighlightType.MEDIUM;
		thickness = 15;
		pricePerDay = 1;
		font = "Arial";
		textColor = Color.BLUE;
		rgbColor = "#ffffff";	
		levelOfVisibility = 1;
		style = "Regular";
	}
	
	private void initSuperHighlight() {
		hlType = HighlightType.SUPER;
		thickness = 15;
		pricePerDay = 2;
		font = "Verdana";
		textColor = Color.RED;
		rgbColor = " #ffd700";
		levelOfVisibility = 2;
		style = "Bold";
	}

	//getters()
	public HighlightType getType() {
		return this.hlType;
	}
	
	public int getThickness() {
		return this.getThickness();
	}
	
	public String getFont() {
		return this.font;
	}
	
	public String getRGBColor() {
		return rgbColor;
	}
	
	public Color getTextColor() {
		return textColor;
	}
	
	public String getStyle() {
		return style;
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