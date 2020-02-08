package logic.ad;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.paint.Color;
import logic.account.*;
import logic.dao.HighlightDAO;
import logic.highlight.*;

//Class for the entity Ad with getter, setter, init and behavioural operations

public final class Ad {
	
	//Ad's info for users
	private Date date;
	private String description;
	private String title;
	private AdCategory category;
	private double price;
	private int quantity;
	private AdType type;
	private boolean isSold;
	private Date startDateHighlight;
	private Date finishDateHighlight;
	
	//Ad's info for system
	private long id;
	private User myUser;
	private String myUserStr;
	private boolean isConvalidated;
	private Highlight myHighlight;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public Ad(User owner, long id) {
		myUser = owner;
		myUserStr = myUser.getUsername();
		this.id = id;
		format.setLenient(false);
	}	
	
	public Ad(String username, long id) {
		myUserStr = username;
		this.id = id;
	}
	
	//getters()
	public String getMyUserStr() {
		return myUserStr;
	}
	
	public long getId() {
		return this.id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public AdCategory getCategory() {
		return this.category;
	}
	
	public boolean getStatus() {
		return this.isSold;
	}
	
	public double getQuantity(){
		return this.quantity;
	}
	
	public AdType getType() {
		return this.type;
	}
	
	public String getOwnerUsername() {
		return myUserStr;
	}
		
	//Highlight attribute
	public Color getBackgroundColor() {
		return myHighlight.getBackgroundColor();
	}
	
	public String getFont() {
		return myHighlight.getFont();
	}
	
	public int getThickness() {
		return myHighlight.getThickness();
	}
	
	public String getStyle() {
		return myHighlight.getStyle();
	}
	
	public Color getTextColor() {
		return myHighlight.getTextColor();
	}
	
	public String getStartHighlightStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(startDateHighlight);
	}
	
	public String getFinishHighlightStr(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(finishDateHighlight);
	}
	
	public String getHighlightTypeStr() {
		return myHighlight.getHighlightType().toString();
	}
	
	//setters()
	public void setMyUserString(String owner) {
		this.myUserStr = owner;
	}
	
	public void setDate(String date) throws ParseException {
		this.date = format.parse(date);
	}
		
	public void setDescription(String description) {
		this.description = description;
	}
		
	public void setTitle(String title) {
		this.title = title;
	}
		
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCategory(String category) {
		switch (category) {
			case "ALGORITHM":
				this.category = AdCategory.ALGORITHM;
				break;
			case "MATH":
				this.category = AdCategory.MATH;
				break;
			case "HISTORY":
				this.category = AdCategory.HISTORY;
				break;
			case "GEOMETRY":
				this.category = AdCategory.GEOMETRY;
				break;
			case "LAW":
				this.category = AdCategory.LAW;
				break;
			case "ECONOMY":
				this.category = AdCategory.ECONOMY;
				break;
			case "LITERATURE":
				this.category = AdCategory.LITERATURE;
				break;
			case "PHILOSOPHY":
				this.category = AdCategory.PHILOSOPHY;
				break;
			case "PHYSICS":
				this.category = AdCategory.PHYSICS;
				break;
			case "COMPUTER_SCIENCE":
				this.category = AdCategory.COMPUTER_SCIENCE;
				break;
			case "CHEMISTRY":
				this.category = AdCategory.CHEMISTRY;
				break;
			default:
				this.category = AdCategory.UNKNOWN;
		}
	}

	public void setStatus(int status) {
		if(status == 0)
			this.isSold = false;
		else
			this.isSold = true;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public void setStartHighlight(String startDate) throws ParseException{
		this.startDateHighlight = format.parse(startDate);
	}
	
	public void setFinishHighlight(String finishDate) throws ParseException{	
		this.finishDateHighlight = format.parse(finishDate);
	}	
	
	public void setHighlight(Highlight myHighlight) {
		this.myHighlight = myHighlight;
	}
	
	public void setHighlight(String myHighlight) throws ClassNotFoundException, SQLException {
		HighlightDAO hlDao = new HighlightDAO();
		
		if (myHighlight.equals("SUPER"))
			hlDao.createHighlightObject("SUPER");
		else if (myHighlight.equals("MEDIUM"))
			hlDao.createHighlightObject("MEDIUM");
		else
			hlDao.createHighlightObject("BASE");
	}
	
	public void setType(String type) {
		if(type.equals("SALE"))
			this.type = AdType.SALE;
		else
			this.type = AdType.EXCHANGE;
	}	
	
	//behavioural operations
	public void markAsSold() {}
	
	private boolean isConvalidated() {
		return this.isConvalidated;
	}
	
	private void deleteMe() {}

}
