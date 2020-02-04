package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.db.DBManager;
import logic.stuff.Review;

public class ReviewDAO {
	
	private static ReviewDAO instance = null;
	private DBManager dbManager;
	
	private ReviewDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
	}
	
	public Review[] loadRCReview() throws SQLException, ClassNotFoundException, Exception {
		ResultSet result = dbManager.getRCReview();
		Review[] myReviews = null;
		
		//count how many rows do we have
		int count = 0;
		while(result.next())
			count++;
		
		if(count == 0) {
			System.out.println("Flag.2");
			return myReviews;
		}
		//repositioning of the index at line 0 (before the first row)
		result.beforeFirst();
		
		//creating list of Ads
		myReviews = new Review[count];
		int i = 0;
		while(result.next()) {			
			myReviews[i] = new Review(result.getString("Text"), result.getString("Time"), result.getFloat("Rank"), result.getString("WriterUser"), result.getString("ReceiverUser"));
			i++; 
		}
		
		dbManager.close();
		return myReviews;
	}
	
	public static ReviewDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}
}