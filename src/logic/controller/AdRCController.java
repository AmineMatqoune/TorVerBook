package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.layout.Pane;
import logic.ad.Ad;
import logic.dao.AccountDAO;
import logic.dao.AdDAO;
import logic.gui.rc.AdRCComponent;


public class AdRCController {

	public void showRCAd(Pane pane) {
		/*ricava le review che hanno fatto all'utente dal metodo privato getReview()*/
		Ad[] ad = this.getAd();
		
		if(ad != null) {
			float xpos = 25;
			float ypos = 25;
			
			for(int i = 0; i != ad.length; i++) {
				AdRCComponent temp = new AdRCComponent(ad[i]);
				temp.getAdComponent().setLayoutX(xpos);
				temp.getAdComponent().setLayoutY(ypos);
				pane.getChildren().add(temp.getAdComponent());
				
				ypos = temp.getHeight() + 50;
			}
		}
	}
	
	private Ad[] getAd() {
		Ad[] ad = null;
		
		try {
			AdDAO adDao = AdDAO.getInstance();
			ad = adDao.loadRCAd();
			return ad;
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			Logger.getLogger("Problemi in getAd").log(Level.SEVERE, e.getMessage());
		}
		return ad;
	}
	
	public void acceptAd(Ad ad) {
		try {
			AdDAO adDAO = AdDAO.getInstance();
			if(adDAO.validateAd(ad.getId())) {
				//la review viene convalidata ma
				//bisogna aggiornare la lista dei review
			}
		} catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger("Problemi con acceptAd").log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void deleteAd(Ad ad) {
		try {
			AdDAO adDAO = AdDAO.getInstance();
			if(adDAO.setDeleteAd(ad.getId())) {
				AccountDAO userDAO = AccountDAO.getInstance();
				int violations = userDAO.getNumViolation(ad.getOwnerUsername());
				if(violations >= 4) {
					//banniamo
					userDAO.toBan(ad.getOwnerUsername());
				}
				else {
					//incrementiamo
					userDAO.incViolations(ad.getOwnerUsername(), violations);
				}				
			}
		} catch (ClassNotFoundException | SQLException e) {
			  Logger.getLogger("Problemi con deleteAd").log(Level.SEVERE, e.getMessage());
		}
	}
}

