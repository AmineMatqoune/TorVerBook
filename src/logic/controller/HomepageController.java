package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.account.User;
import logic.ad.Ad;
import logic.dao.AccountDAO;
import logic.dao.AdDAO;
import logic.gui.AdComponent;
import logic.gui.AdUComponent;
import logic.gui.popup.ErrorPopup;

public class HomepageController {

	private Ad[] ads;
	private AdDAO adDao;
	private Pane hpPane;

	public HomepageController() {
		try {
			adDao = AdDAO.getInstance();
			ads = adDao.getHomepageAdsList(); // initializing Ads that will be shown in Homepage
		} catch (SQLException | ClassNotFoundException | ParseException e) {
			Logger.getLogger("ReviewRCController").log(Level.SEVERE, e.getMessage());
			new ErrorPopup(e.getMessage(), (Stage) hpPane.getScene().getWindow());
		}
	}

	public void attachAdsTo(Pane pane) {
		User user = (User) AccountDAO.getInstance().getAccountObject();
		try {
			if (ads != null)
				for (int i = 0; i < ads.length; i++) {	
					boolean isFavourite = adDao.checkIsFavouriteAd(ads[i].getId(),user.getUsername());
					AdUComponent adComp = new AdUComponent(ads[i].getTitle(), ads[i].getDescription(), user.getUsername(), ads[i].getType().toString(), ads[i].getPrice(), ads[i].getCategory().toString(), isFavourite);
					adComp.setId(ads[i].getId());
					adComp.setY(AdComponent.HEIGHT * i);
					pane.getChildren().add(adComp.getAdComponent()); // aggiungiamo l'adComponent allo scrollpane
				}
			else {
				Label tmp = new Label("Empty List!");
				tmp.setFont(new Font("Arial Bold", 50));
				tmp.setAlignment(Pos.CENTER);
				tmp.setPrefHeight(230);
				tmp.setPrefWidth(585);
				pane.getChildren().add(tmp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			Logger.getLogger("ReviewRCController").log(Level.SEVERE, e.getMessage());
			new ErrorPopup(e.getMessage(), (Stage) hpPane.getScene().getWindow());
		}
	}

}
