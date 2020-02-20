package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.mail.internet.AddressException;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.ad.Ad;
import logic.bean.AdBean;
import logic.dao.AccountDAO;
import logic.dao.AdDAO;
import logic.gui.AdComponent;
import logic.gui.popup.ErrorPopup;
import logic.gui.rc.AdRCComponent;
import logic.utils.SendMail;

public class AdRCController {

	private static AdRCController instance = null;

	private Pane scenePane;
	private Ad[] ads;

	private AdRCController() {
	}

	public void showRCAd(Pane pane) {
		pane.getChildren().clear();
		scenePane = pane;
		// ricava gli ad che hanno fatto all'utente dal metodo privato getAd()
		ads = this.getAd();
		if (ads != null) {
			for (int i = 0; i != ads.length; i++) {
				AdBean bean = new AdBean(ads[i]);
				AdRCComponent ad = new AdRCComponent(bean);
				ad.getAdComponent().setLayoutY(AdComponent.HEIGHT * (double) i);
				scenePane.getChildren().add(ad.getAdComponent());
			}
		} else {
			Label tmp = new Label("Empty List!");
			tmp.setFont(new Font("Arial Bold", 50));
			tmp.setAlignment(Pos.CENTER);
			tmp.setPrefHeight(230);
			tmp.setPrefWidth(585);
			scenePane.getChildren().add(tmp);
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

	public boolean acceptAd(long id) {
		try {
			AdDAO adDAO = AdDAO.getInstance();
			if (adDAO.validateAdRC(id))
				return true;
		} catch (SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage) scenePane.getScene().getWindow());
		}
		return false;
	}

	public boolean deleteAd(long id) {
		try {
			AdDAO adDAO = AdDAO.getInstance();
			if (adDAO.deleteAdRC(id)) {
				AccountDAO userDAO = AccountDAO.getInstance();
				String username = retrieveUsernameById(id);
				int violations = userDAO.getNumViolation(username);
				SendMail send = new SendMail(userDAO.getEmail(username));
				if (violations >= 4) {
					userDAO.toBan(username);
					send.sendReportingEmail(
							"A causa del superamente del numero limite di violazioni, sei stato bannato.");
				} else {
					send.sendReportingEmail("Il tuo annuncio è stato rifiutato, e fino ad ora hai compiuto "
							+ (violations + 1)
							+ " violazioni. Alla quinta violazione verrai bannato.\nCordiali saluti da TorVerBook");
				}
				userDAO.incViolations(username, violations);
				return true;
			}
		} catch (SQLException | AddressException e) {
			new ErrorPopup(e.getMessage(), (Stage) scenePane.getScene().getWindow());
		}
		return false;
	}

	private String retrieveUsernameById(long id) {
		int i = 0;
		if (ads != null) {
			while (i < ads.length) {
				if (ads[i].getId() == id)
					break;
				i++;
			}
		}
		return ads[i].getOwnerUsername();
	}

	public Pane getPane() {
		return scenePane;
	}

	public static AdRCController getInstance() {
		if (AdRCController.instance == null)
			AdRCController.instance = new AdRCController();
		return AdRCController.instance;
	}
}
