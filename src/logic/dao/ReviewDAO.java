package logic.dao;

import java.sql.ResultSet;
import logic.account.User;
import java.sql.SQLException;
import logic.db.DBManager;
import logic.stuff.Review;

public class ReviewDAO {
	
	private static ReviewDAO instance = null;
	private DBManager dbManager;
	
	private ReviewDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
	}
	
	/*2. metodo aggiunto per prendere le review dell'utente*/
	public Review[] loadMyReview(User user) throws SQLException, ClassNotFoundException, Exception {
		ResultSet result = dbManager.getMyReview(user.getUsername());
		Review[] myReviews = null;
		
		//count how many rows do we have
		int count = 0;
		while(result.next())
			count++;
		
		if(count == 0) {
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
	
	public Review[] loadRCReview() throws SQLException, ClassNotFoundException, Exception {
		ResultSet result = dbManager.getRCReview();
		Review[] myReviews = null;
		
		//count how many rows do we have
		int count = 0;
		while(result.next())
			count++;
		
		if(count == 0) 
			return myReviews;
		
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
	
	/*metodo aggiunto: per oggetti ReviewRCComponent quando si preme su check.png*/
	public boolean setCheckReview(Review review) throws ClassNotFoundException, SQLException {
		return dbManager.updateReviewState(review);
	}
	
	/*metodo aggiunto: per oggetti ReviewRCComponent quando si preme su close.png*/
	public boolean setDeleteReview(Review review) throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
		return dbManager.deleteRCReview(review);
	}
	
	public static ReviewDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}
}