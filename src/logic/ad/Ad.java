package logic.ad;

import java.util.Calendar;
import logic.account.*;
import logic.highlight.*;

//Class for the entity Ad with getter, setter, init and behaviour operations

public final class Ad {
	
	//Ad's info for users
	private Calendar date;
	private String description;
	private String title;
	private AdCategory category;
	private double price;
	private AdType type;
	private boolean isSold;
	
	//Ad's info for system
	private long id;
	private User myUser;
	private String adFont;
	private int thickness;
	private boolean isConvalidated;
	
	public Ad(User owner, long id) {
		//link to own user
		//setId
	}	
	
	//getters()
	public Calendar getDate() {
		return this.date;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public AdCategory getCategory() {
		return this.category;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public AdType getType() {
		return this.type;
	}
	
	public boolean getStatus() {
		return this.isSold;
	}
	
	//behaviour operations
	public void markAsSold() {}
	
	public void addHighlight(Highlight hl) {
		//personalize (call private method below)
	}
	
	private void setFont(String font) {}
	
	private void setThickness(int t) {}
	
	private boolean isConvalidated() {
		return this.isConvalidated;
	}
	
	private void deleteMe() {}	
}
