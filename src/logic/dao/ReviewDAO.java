package logic.dao;

import java.sql.ResultSet;
import logic.account.User;
import java.sql.SQLException;
import java.text.ParseException;

import logic.db.DBManager;
import logic.review.Review;

public class ReviewDAO {
	
	private static ReviewDAO instance = null;
	private DBManager dbManager;
	
	private ReviewDAO() {
		dbManager = DBManager.getInstance();
	}
	
	/*metodo aggiunto per prendere le review dell'utente*/
	public Review[] loadMyReview(User user) throws SQLException, ParseException {
		ResultSet result = dbManager.getMyReview(user.getUsername());
		return fetchReview(result);
	}
	
	public Review[] loadRCReview() throws SQLException, ParseException {
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
	public boolean validateReview(String writer, String receiver, String rulechecker) throws SQLException {
		return dbManager.updateReviewState(writer, receiver, rulechecker);
	}
	
	/*metodo aggiunto: per oggetti ReviewRCComponent quando si preme su close.png*/
	public boolean setDeleteReview(String writer, String receiver) throws SQLException {
		return dbManager.deleteRCReview(writer, receiver);
	}
	
	public Float getAverage(String username) throws SQLException {
		ResultSet result = dbManager.getAverageRank(username);
		result.next();
		return result.getFloat("Media");
	}
	
	public static ReviewDAO getInstance() {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}
}