package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import logic.account.User;
import logic.ad.Ad;
import logic.bean.AddAdBean;
import logic.db.DBManager;
import logic.highlight.Highlight;

public class AdDAO {

	private static AdDAO instance = null;
	private DBManager dbManager;
	private ResultSet result;
	private HighlightDAO highlightDao;
	
	private int count = 0;
	
	private AdDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
		highlightDao = new HighlightDAO();
	}
	
	public Ad[] loadMyAds(User owner) throws SQLException, ClassNotFoundException, ParseException {
		Ad[] myAds = null;
		result = dbManager.getMyAds(owner.getUsername());
		
		//creating list of Ads
		if((count = getNumOfRows()) != 0) {
			myAds = new Ad[count];
			int i = 0;
			while(result.next()) {
				myAds[i] = new Ad(owner, result.getInt("ID"));
				myAds[i].setDate(result.getString("Date"));
				myAds[i].setDescription(result.getString("Description"));
				myAds[i].setTitle(result.getString("Title"));
				myAds[i].setPrice(result.getInt("Price"));
				myAds[i].setCategory(result.getString("Course"));
				myAds[i].setType(result.getString("Type"));
				myAds[i].setStatus(result.getInt("isSold"));
				myAds[i].setQuantity(result.getInt("Quantity"));
				myAds[i].setStartHighlight(result.getString("StartHighlight"));
				myAds[i].setFinishHighlight(result.getString("FinishHighlight"));
				
				Highlight highlight = null;			
				//for each Ad, we first create the relative Highlight entity object, and then we get() it
				switch(result.getString("Highlight")) {
				case "SUPER":
					highlightDao.createHighlightObject("SUPER");
					highlight = highlightDao.getHighlightObject();
					break;
				case "MEDIUM":
					highlightDao.createHighlightObject("MEDIUM");
					highlight = highlightDao.getHighlightObject();
					break;
				default:
					highlightDao.createHighlightObject("BASE");
					highlight = highlightDao.getHighlightObject();
				}
					
				myAds[i].setHighlight(highlight);
				i++; 
			}
		}
		return myAds;
	}
	
	public Ad[] getHomepageAdsList() throws ClassNotFoundException, SQLException, ParseException {
		Ad[] ads = null;
		result = dbManager.getHomepageAds();
		count = getNumOfRows();
		if(count > 0) {
			ads = new Ad[count];
			int i = 0;
			
			while(result.next()) {
				ads[i] = new Ad(result.getString("User"), Integer.valueOf(result.getString("ID")));
				ads[i].setDate(result.getString("Date"));
				ads[i].setDescription(result.getString("Description"));
				ads[i].setTitle(result.getString("Title"));
				ads[i].setPrice(result.getInt("Price"));
				ads[i].setCategory(result.getString("Course"));
				ads[i].setType(result.getString("Type"));
				ads[i].setStatus(result.getInt("isSold"));
				ads[i].setQuantity(result.getInt("Quantity"));
				ads[i].setStartHighlight(result.getString("StartHighlight"));
				ads[i].setFinishHighlight(result.getString("FinishHighlight"));
				
				Highlight highlight = null;	
				switch(result.getString("Highlight")) {
				case "SUPER":
					highlightDao.createHighlightObject("SUPER");
					highlight = highlightDao.getHighlightObject();
					break;
				case "MEDIUM":
					highlightDao.createHighlightObject("MEDIUM");
					highlight = highlightDao.getHighlightObject();
					break;
				default:
					highlightDao.createHighlightObject("BASE");
					highlight = highlightDao.getHighlightObject();
				}
					
				ads[i].setHighlight(highlight);
				i++;
			}
		}
		return ads;
	}

	public Ad[] loadFavouriteAds(User owner) throws SQLException, ClassNotFoundException, ParseException {
			Ad[] myAds = null;
			/*2. identico a loadMyAds però cambia solo il metodo utilizzato da dbManager*/
			result = dbManager.getFavouriteAds(owner.getUsername());
			
			//creating list of Ads
			if((count = getNumOfRows()) != 0) {
				myAds = new Ad[count];
				int i = 0;
				while(result.next()) {
					myAds[i] = new Ad(owner, result.getInt("ID"));
					myAds[i].setDate(result.getString("Date"));
					myAds[i].setDescription(result.getString("Description"));
					myAds[i].setTitle(result.getString("Title"));
					myAds[i].setPrice(result.getInt("Price"));
					myAds[i].setCategory(result.getString("Course"));
					myAds[i].setType(result.getString("Type"));
					myAds[i].setStatus(result.getInt("isSold"));
					myAds[i].setQuantity(result.getInt("Quantity"));
					myAds[i].setStartHighlight(result.getString("StartHighlight"));
					myAds[i].setFinishHighlight(result.getString("FinishHighlight"));
					
					Highlight highlight = null;			
					//for each Ad, we first create the relative Highlight entity object, and then we get() it
					switch(result.getString("Highlight")) {
					case "SUPER":
						highlightDao.createHighlightObject("SUPER");
						highlight = highlightDao.getHighlightObject();
						break;
					case "MEDIUM":
						highlightDao.createHighlightObject("MEDIUM");
						highlight = highlightDao.getHighlightObject();
						break;
					default:
						highlightDao.createHighlightObject("BASE");
						highlight = highlightDao.getHighlightObject();
					}
						
					myAds[i].setHighlight(highlight);
					i++; 
				}
			}
			return myAds;
		}
	
	private int getNumOfRows() throws SQLException { //count how many rows do we have
		count = 0;
		result.beforeFirst();
		
		while(result.next())
			count++;
		
		//repositioning of the index at line 0 (before the first row)
		result.beforeFirst();
		return count;
	}
	
	public boolean addNewAd() throws ClassNotFoundException, SQLException, NumberFormatException, NullPointerException {
		AddAdBean adBean = new AddAdBean();
		
		String date = LocalDate.now().toString();
		String description = adBean.getDescriprion();
		String title = adBean.getTitle();
		double price = adBean.getPrice();
		String course = adBean.getCourse();
		String type = adBean.getType();
		int quantity = adBean.getQuantity();
		String startHighlight = adBean.getStartHighlight();
		String finishHighlight = adBean.getFinishHighlight();
		String highlight = adBean.getHighlight();
		String username = UserDAO.getInstance().getUserObject().getUsername();
		
		return dbManager.addAd(date, description, title, price, course, type, quantity, startHighlight, finishHighlight, highlight, username);
		
	}
	
	public static AdDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new AdDAO();
		return instance;
	}

}
