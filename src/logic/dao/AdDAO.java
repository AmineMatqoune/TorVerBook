package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logic.account.User;
import logic.ad.Ad;
import logic.db.DBManager;
import logic.highlight.Highlight;
import logic.highlight.HighlightType;

public class AdDAO {

	private static AdDAO instance = null;
	private DBManager dbManager;
	private ResultSet result;
	
	private int count = 0;
	
	private AdDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
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
				switch(result.getString("Highlight")) {
				case "SUPER":
					 highlight = new Highlight(HighlightType.SUPER);
					break;
				case "MEDIUM":
					highlight = new Highlight(HighlightType.MEDIUM);
					break;
				default:
					highlight = new Highlight(HighlightType.BASE);
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
					 highlight = new Highlight(HighlightType.SUPER);
					break;
				case "MEDIUM":
					highlight = new Highlight(HighlightType.MEDIUM);
					break;
				default:
					highlight = new Highlight(HighlightType.BASE);
				}
					
				ads[i].setHighlight(highlight);
				i++;
			}
		}
		return ads;
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
	
	public static AdDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new AdDAO();
		return instance;
	}

}
