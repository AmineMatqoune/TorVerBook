package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.layout.Pane;
import logic.dao.ReviewDAO;
import logic.dao.AccountDAO;
import logic.gui.rc.ReviewRCComponent;
import logic.stuff.Review;

public class ReviewRCController {

	/*metodo che aggiunge al pane i reviewComponent*/
	public void showRCReview(Pane pane) {
		/*ricava le review che hanno fatto all'utente dal metodo privato getReview()*/
		Review[] review = this.getReview();
		
		if(review != null) {
			float xpos = 25;
			float ypos = 25;
			
			for(int i = 0; i != review.length; i++) {
				ReviewRCComponent temp = new ReviewRCComponent(review[i]);
				temp.getReviewComponent().setLayoutX(xpos);
				temp.getReviewComponent().setLayoutY(ypos);
				pane.getChildren().add(temp.getReviewComponent());
				
				ypos = (temp.getHeight() + 50);
			}
		}
		else {
			System.out.println("Non ci sono review!");
		}
	}
	
	//prende le review e le ritorna
	private Review[] getReview() {
		Review[] review = null;
		
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			review = reviewDAO.loadRCReview();
			return review;
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			Logger.getLogger("Problemi con getReview").log(Level.SEVERE, e.getMessage());
		}
		return review;
	}
	
	//metodo attivato quando il RC preme su check.png
	public void acceptReview(Review review) {
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			if(reviewDAO.validateReview(review)) {
				//la review viene convalidata ma
				//bisogna aggiornare la lista dei review
			}
		} catch (ClassNotFoundException | SQLException e) {
			  Logger.getLogger("ReviewRCController").log(Level.SEVERE, e.getMessage());
		}
	}
	
	/* metodo attivato quando il RC preme su close.png 
	 * del reviewComponent: elimina la review dal database
	/* bisognerà mettere far inviare l'email*/
	public void deleteReview(Review review) {
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			if(reviewDAO.setDeleteReview(review)) {
				//la review viene convalidata ma
				//bisogna aggiornare la lista dei review
				AccountDAO userDAO = AccountDAO.getInstance();
				int violations = userDAO.getNumViolation(review.getWriter());
				if(violations >= 4) {
					//banniamo
					userDAO.toBan(review.getWriter());
				}
				else {
					//incrementiamo
					userDAO.incViolations(review.getWriter(), violations);
				}				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			  Logger.getLogger("ReviewRCController").log(Level.SEVERE, e.getMessage());
		}
	}
}