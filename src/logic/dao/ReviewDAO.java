package logic.dao;

import java.sql.ResultSet;
import logic.account.User;
import java.sql.SQLException;
import java.text.ParseException;

import logic.db.DBManager;
import logic.stuff.Review;

public class ReviewDAO {
	
	private static ReviewDAO instance = null;
	private DBManager dbManager;
	
	private ReviewDAO() throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
	}
	
	/*metodo aggiunto per prendere le review dell'utente*/
	public Review[] loadMyReview(User user) throws SQLException, ClassNotFoundException, ParseException {
		ResultSet result = dbManager.getMyReview(user.getUsername());
		return fetchReview(result);
	}
	
	public Review[] loadRCReview() throws SQLException, ClassNotFoundException, ParseException {
		ResultSet result = dbManager.getRCReview();
		return fetchReview(result);
	}
	
	private Review[] fetchReview(ResultSet result) throws SQLException, ParseException {
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
		return dbManager.updateReviewState(review.getWriter(), review.getReceiver());
	}
	
	/*metodo aggiunto: per oggetti ReviewRCComponent quando si preme su close.png*/
	public boolean setDeleteReview(Review review) throws ClassNotFoundException, SQLException {
		return dbManager.deleteRCReview(review.getWriter(), review.getReceiver());
	}
	
	public static ReviewDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}
}