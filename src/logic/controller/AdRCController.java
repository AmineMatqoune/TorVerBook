package logic.controller;

import java.sql.SQLException;

import java.text.ParseException;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.ad.Ad;
import logic.bean.AdBean;
import logic.dao.AccountDAO;
import logic.dao.AdDAO;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;
import logic.gui.rc.AdRCComponent;

public class AdRCController {

	private Pane scenePane;
	private Ad[] ads;

	public void showRCAd(Pane pane) {
		scenePane = pane;
		// ricava gli ad che hanno fatto all'utente dal metodo privato getAd()
		ads = this.getAd();

		if (ads != null) {
			int xpos = 25;
			int ypos = 25;

			for (int i = 0; i != ads.length; i++) {
				AdBean adBean = new AdBean(ads[i]);
				AdRCComponent temp = new AdRCComponent(adBean);
				temp.getAdComponent().setLayoutX(xpos);
				temp.getAdComponent().setLayoutY(ypos);
				scenePane.getChildren().add(temp.getAdComponent());

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
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) scenePane.getScene().getWindow());
		}
		return ad;
	}

	public void acceptAd(long id) {
		try {
			AdDAO adDAO = AdDAO.getInstance();
			if (adDAO.validateAd(id)) {
				// la review viene convalidata ma
				// bisogna aggiornare la lista dei review
				new InfoPopup("Annuncio Convalidato!", (Stage) scenePane.getScene().getWindow());
			}
		} catch (SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage) scenePane.getScene().getWindow());
		}
	}

	public void deleteAd(long id) {
		try {
			AdDAO adDAO = AdDAO.getInstance();
			if (adDAO.deleteAd(id)) {
				AccountDAO userDAO = AccountDAO.getInstance();
				String username = retrieveUsernameById(id);
				int violations = userDAO.getNumViolation(username);
				if (violations >= 4) {
					// banniamo
					userDAO.toBan(username);
				} else {
					// incrementiamo
					userDAO.incViolations(username, violations);
				}
			}
		} catch (SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage) scenePane.getScene().getWindow());
		}
	}

	private String retrieveUsernameById(long id) {
		int i = 0;
		while (i < ads.length) {
			if (ads[i].getId() == id)
				break;
			i++;
		}
		return ads[i].getMyUserStr();
	}
}
