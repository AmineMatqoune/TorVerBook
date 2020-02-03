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
	private Color backgroundColor;
	private String style;
	
	
	public Highlight(HighlightType type) {
		if (type == HighlightType.SUPER)
			initSuperHighlight();
		else if (type == HighlightType.MEDIUM)
			initMediumHighlight();
		else initBaseHighlight();
	}
	
	private void initBaseHighlight() {
		hlType = HighlightType.BASE;
		thickness = 17;
		pricePerDay = 0;
		font = "Times New Roman";
		textColor = Color.BLACK;
		backgroundColor = Color.FORESTGREEN;
		levelOfVisibility = 0;
		style = "Regular";
	}
	
	private void initMediumHighlight() {
		hlType = HighlightType.MEDIUM;
		thickness = 20;
		pricePerDay = 1;
		font = "Arial";
		textColor = Color.BLUE;
		backgroundColor = Color.WHITE;	
		levelOfVisibility = 1;
		style = "Regular";
	}
	
	private void initSuperHighlight() {
		hlType = HighlightType.SUPER;
		thickness = 20;
		pricePerDay = 2;
		font = "Verdana";
		textColor = Color.RED;
		backgroundColor = Color.YELLOW;
		levelOfVisibility = 2;
		style = "Bold";
	}

	//getters()
	public HighlightType getType() {
		return this.hlType;
	}
	
	public int getThickness() {
		return this.thickness;
	}
	
	public String getFont() {
		return this.font;
	}
	
	public Color getBackgroundColor() {
		return backgroundColor;
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