package logic.highlight;

import logic.ad.*;
import java.awt.Color;

public final class Highlight implements HighlightInterface{
	
	//highlight info for user
	private HighlightType hlType;
	private int thickness;
	private int pricePerDay;
	private String font;
	
	//highlight info for system
	private int levelOfVisibility;
	private Color textColor;
	private Color bgColor;
	
	
	public Highlight(HighlightType type) {
		if (type == HighlightType.BASE)
			initBaseHighlight();
		else if (type == HighlightType.MEDIUM)
			initMediumHighlight();
		else initSuperHighlight();
	}
	
	private void initBaseHighlight() {
		hlType = HighlightType.BASE;
		thickness = 10;
		pricePerDay = 0;
		font = "Times New Roman";
		textColor = Color.BLACK;
		bgColor = Color.GREEN;
		levelOfVisibility = 0;
	}
	
	private void initMediumHighlight() {
		hlType = HighlightType.MEDIUM;
		thickness = 15;
		pricePerDay = 1;
		font = "Arial";
		textColor = Color.BLUE;
		bgColor = Color.WHITE;	
		levelOfVisibility = 1;
	}
	
	private void initSuperHighlight() {
		hlType = HighlightType.SUPER;
		thickness = 20;
		pricePerDay = 2;
		font = "Verdana";
		textColor = Color.RED;
		bgColor = Color.YELLOW;
		levelOfVisibility = 2;
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
	
	//behavioural methods inherited from interface
	@Override
	public void linkToAd(Ad ad) {} //è del controller quest'operazione?
	
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
