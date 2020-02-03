package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logic.account.User;
import logic.ad.Ad;
import logic.db.DBManager;

public class AdDAO {

	private static AdDAO instance = null;
	private DBManager dbManager;
	private ResultSet result;
	
	private AdDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
	}
	
	public Ad[] loadMyAds(User owner) throws SQLException, ClassNotFoundException, ParseException {
		result = dbManager.getMyAds(owner.getUsername());
		Ad[] myAds = null;
		
		//count how many rows do we have
		int count = 0;
		while(result.next())
			count++;
		
		if(count == 0)
			return myAds;
		
		//repositioning of the index at line 0 (before the first row)
		result.beforeFirst();
		
		//creating list of Ads
		myAds = new Ad[count];
		int i = 0;
		while(result.next()) {
			myAds[i] = new Ad(owner, result.getInt("ID"));
			myAds[i].setDate(result.getString("Date"));
			myAds[i].setDescription(result.getString("Description"));
			myAds[i].setTitle(result.getString("Title"));
			myAds[i].setPrice(result.getInt("Price"));
			myAds[i].setCategory(result.getString("Course"));
			myAds[i].setStatus(result.getInt("isSold"));
			myAds[i].setQuantity(result.getInt("Quantity"));
			myAds[i].setStartHighlight(result.getString("StartHighlight"));
			myAds[i].setFinishHighlight(result.getString("FinishHighlight"));
			i++; 
		}
		
		dbManager.close();
		return new Ad[count];
	}
	
	public static AdDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new AdDAO();
		return instance;
	}
}
