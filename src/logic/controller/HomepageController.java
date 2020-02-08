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

import logic.ad.Ad;
import logic.dao.AdDAO;
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
			System.out.println("hpPane è ancora da fa NON ELIMINARE");
			System.out.println(e.getMessage());
			Logger.getLogger("ReviewRCController").log(Level.SEVERE, e.getMessage());
			new ErrorPopup(e.getMessage(), (Stage) hpPane.getScene().getWindow());
		}
	}

	public void attachAdsTo(Pane pane) {
		if (ads != null)
			for (int i = 0; i < ads.length; i++) {
				AdUComponent adComp = new AdUComponent(ads[i]);
				adComp.setY(AdUComponent.HEIGHT * i);
				pane.getChildren().add(adComp.getAdPane()); // aggiungiamo l'adComponent allo scrollpane
			}
		else {
			Label tmp = new Label("Empty List!");
			tmp.setFont(new Font("Arial Bold", 50));
			tmp.setAlignment(Pos.CENTER);
			tmp.setPrefHeight(230);
			tmp.setPrefWidth(585);
			pane.getChildren().add(tmp);
		}
	}

}
