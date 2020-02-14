package logic.ad;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.paint.Color;
import logic.account.User;
import logic.dao.HighlightDAO;
import logic.highlight.Highlight;

//Class for the entity Ad with getter, setter, init and behavioural operations

public final class Ad {

	// Ad's info for users
	private Date date;
	private String description;
	private String title;
	private AdCategory category;
	private int price;
	private int quantity;
	private AdType type;
	private boolean isSold;
	private Date startDateHighlight;
	private Date finishDateHighlight;

	// Ad's info for system
	private long id;
	private User myUser;
	private String myUserStr;
	private boolean isConvalidated;
	private Highlight myHighlight;

	private static final String DATE_STRING_FORMAT = "yyyy-MM-dd";
	private final SimpleDateFormat format = new SimpleDateFormat(DATE_STRING_FORMAT);

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

	// getters()
	public String getOwnerUsername() {
		return myUserStr;
	}

	public long getId() {
		return this.id;
	}

	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STRING_FORMAT);
		return formatter.format(date);
	}

	public String getDescription() {
		return this.description;
	}

	public String getTitle() {
		return this.title;
	}

	public int getPrice() {
		return this.price;
	}

	public AdCategory getCategory() {
		return this.category;
	}

	public boolean getStatus() {
		return this.isSold;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public AdType getType() {
		return this.type;
	}


	// Highlight attribute
	public Highlight getHighlight() {
		return myHighlight;		
	}
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
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STRING_FORMAT);
		return formatter.format(startDateHighlight);
	}

	public String getFinishHighlightStr() {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STRING_FORMAT);
		return formatter.format(finishDateHighlight);
	}

	public String getHighlightTypeStr() {
		return myHighlight.getHighlightType().toString();
	}

	// setters()
	public void setMyUserString(String owner) {
		this.myUserStr = owner;
	}

	public void setMyUserObj(User owner) {
		myUser = owner;
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

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCategory(String category) {
		switch (category) {
		case "ALGORITHM":
			this.category = AdCategory.ALGORITHMS;
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
			this.category = AdCategory.ANY;
		}
	}

	public void setStatus(int status) {
		if (status == 0)
			this.isSold = false;
		else
			this.isSold = true;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStartHighlight(String startDate) throws ParseException {
		this.startDateHighlight = format.parse(startDate);
	}

	public void setFinishHighlight(String finishDate) throws ParseException {
		this.finishDateHighlight = format.parse(finishDate);
	}

	public void setHighlight(Highlight myHighlight) {
		this.myHighlight = myHighlight;
	}

	public void setHighlight(String myHighlightType) throws SQLException {
		HighlightDAO hlDao = new HighlightDAO();
		hlDao.createHighlightObject(myHighlightType);
		this.myHighlight = hlDao.getHighlightObject(); // bind ad-highlight
	}

	public void setType(String type) {
		if (type.equals("SALE"))
			this.type = AdType.SALE;
		else
			this.type = AdType.EXCHANGE;
	}

	// behavioural operations
	public void markAsSold() {
		if (getQuantity() == 1)
			myUser.removeAd(id);
		else
			setQuantity(getQuantity() - 1);
	}

	public void setConvalidated(boolean isConvalidated) {
		this.isConvalidated = isConvalidated;
	}

	public boolean isConvalidated() {
		return isConvalidated;
	}
	
}
