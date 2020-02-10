package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import logic.ad.Ad;
import logic.bean.AddAdBean;
import logic.db.DBManager;
import logic.highlight.Highlight;

public class AdDAO {

	private static AdDAO instance = null;
	private DBManager dbManager;
	private HighlightDAO highlightDao;
	
	private int count = 0;
	
	private AdDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
		highlightDao = new HighlightDAO();
	}
	
	public Ad[] loadMyAds(String ownerUsername) throws SQLException, ClassNotFoundException, ParseException {
		ResultSet result = dbManager.getMyAds(ownerUsername);
		return fetchAdData(result);
	}
	
	public Ad[] getHomepageAdsList() throws ClassNotFoundException, SQLException, ParseException {
		ResultSet result = dbManager.getHomepageAds();
		return fetchAdData(result);		
	}

	public boolean checkIsFavouriteAd(long adId, String currentUsername) throws ClassNotFoundException, SQLException {
		return dbManager.checkIsFavouriteAd(adId, currentUsername);
	}
	
	public Ad[] loadFavouriteAds(String ownerUsername) throws SQLException, ClassNotFoundException, ParseException {
		ResultSet result = dbManager.getFavouriteAds(ownerUsername);	
		return fetchAdData(result);
	}
	
	private Ad[] fetchAdData(ResultSet result) throws ParseException, SQLException, ClassNotFoundException {
		Ad[] myAds = null;
		//creating list of Ads
		if((count = getNumOfRows(result)) > 0) {
			myAds = new Ad[count];
			int i = 0;
			
			while(result.next()) {
				myAds[i] = new Ad(result.getString("User"), result.getInt("ID"));
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
	
	private int getNumOfRows(ResultSet result) throws SQLException { //count how many rows do we have
		count = 0;
		result.beforeFirst();
		
		while(result.next())
			count++;
		
		//repositioning of the index at line 0 (before the first row)
		result.beforeFirst();
		return count;
	}
	
	public boolean createNewAd() throws ClassNotFoundException, SQLException, ParseException {
		AddAdBean addAdBean = new AddAdBean();
		
		//we create a temporary Ad object (ID = 0), once we added it to bd, we can update his real ID
		Ad ad = new Ad(AccountDAO.getInstance().getAccountObject().getUsername(), 0); 
		ad.setDate(LocalDate.now().toString());
		ad.setDescription(addAdBean.getDescription());
		ad.setTitle(addAdBean.getTitle());
		ad.setPrice(addAdBean.getPrice());
		ad.setCategory(addAdBean.getCourse());
		ad.setType(addAdBean.getType());
		ad.setQuantity(addAdBean.getQuantity());
		ad.setStartHighlight(addAdBean.getStartHighlight());
		ad.setFinishHighlight(addAdBean.getFinishHighlight());
		ad.setHighlight(addAdBean.getHighlight());
		
		return dbManager.addAd(ad);
	}
	
	public boolean addAdToFavouriteList(Ad ad) throws ClassNotFoundException, SQLException {
		return dbManager.addAdToFavouriteList(ad.getId(), AccountDAO.getInstance().getAccountObject().getUsername());
	}
	
	public boolean removeAdFromFavouriteList(Ad ad) throws ClassNotFoundException, SQLException {
		return dbManager.removeAdFromFavouriteList(ad.getId(), AccountDAO.getInstance().getAccountObject().getUsername());
	}
	
	public static AdDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new AdDAO();
		return instance;
	}
}
