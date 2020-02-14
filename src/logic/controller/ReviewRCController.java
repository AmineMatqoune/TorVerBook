package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.dao.ReviewDAO;
import logic.bean.ReviewBean;
import logic.dao.AccountDAO;
import logic.gui.popup.InfoPopup;
import logic.gui.rc.ReviewRCComponent;
import logic.review.Review;

public class ReviewRCController {
	
	private AccountDAO userDAO = null;
	
	private Pane scenePane;
	
	public ReviewRCController() {
		userDAO = AccountDAO.getInstance();
	}

	/*metodo che aggiunge al pane i reviewComponent*/
	public void showRCReview(Pane pane) {
		scenePane = pane;
		/*ricava le review che hanno fatto all'utente dal metodo privato getReview()*/
		Review[] review = this.getReview();
		
		if(review != null) {
			for(int i = 0; i != review.length; i++) {
				ReviewBean bean = new ReviewBean(review[i]);
				ReviewRCComponent rev = new ReviewRCComponent(bean);
				rev.setY(ReviewRCComponent.HEIGHT * i);
				pane.getChildren().add(rev.getReviewComponent());
			}
		}
		else {
			Label tmp = new Label("Empty List!");
			tmp.setFont(new Font("Arial Bold", 50));
			tmp.setAlignment(Pos.CENTER);
			tmp.setPrefHeight(230);
			tmp.setPrefWidth(585);
			scenePane.getChildren().add(tmp);
		}
	}
	
	//prende le review e le ritorna
	private Review[] getReview() {
		Review[] review = null;
		
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			review = reviewDAO.loadRCReview();
			return review;
		} catch (SQLException | ParseException e) {
			new InfoPopup("Problemi nel caricamento delle review", (Stage) scenePane.getScene().getWindow());
		}
		return review;
	}
	
	//metodo attivato quando il RC preme su check.png
	public void acceptReview(String writer, String receiver) {
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			if(reviewDAO.validateReview(writer, receiver, userDAO.getAccountObject().getUsername())) {
				//la review viene convalidata ma
				//bisogna aggiornare la lista dei review
			}
		} catch (SQLException e) {
			new InfoPopup("Problemi nell'approvazione del review", (Stage) scenePane.getScene().getWindow());
		}
	}
	
	/* metodo attivato quando il RC preme su close.png 
	 * del reviewComponent: elimina la review dal database
	/* bisognerà mettere far inviare l'email*/
	public void deleteReview(String writer, String receiver) {
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			if(reviewDAO.setDeleteReview(writer, receiver)) {
				//la review viene convalidata ma
				//bisogna aggiornare la lista dei review
				int violations = userDAO.getNumViolation(writer);
				if(violations >= 4) {
					//banniamo
					userDAO.toBan(writer);
				}
				else {
					//incrementiamo
					userDAO.incViolations(writer, violations);
				}				
				
			}
		} catch (SQLException e) {
			new InfoPopup("Problemi nella censura del review", (Stage) scenePane.getScene().getWindow());
		}
	}
}