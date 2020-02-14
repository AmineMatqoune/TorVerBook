package logic.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.account.User;
import logic.ad.Ad;
import logic.bean.AdBean;
import logic.dao.AccountDAO;
import logic.gui.AdComponent;

public class FavouriteListController {

	private Ad[] favouriteAds;
	private User currentUser;

	public FavouriteListController() {
		AccountDAO userDAO = AccountDAO.getInstance();
		currentUser = (User) userDAO.getAccountObject();
		favouriteAds = getFavouriteAds();
	}

	private Ad[] getFavouriteAds() {
		return currentUser.getFavouriteList();
	}

	public void attachAdsTo(Pane pane) {
		if (favouriteAds != null) {
			for (int i = 0; i != favouriteAds.length; i++) {
				AdBean adBean = new AdBean(favouriteAds[i]);
				AdComponent adComp = new AdComponent(adBean);
				adComp.setY(AdComponent.HEIGHT * i);
				pane.getChildren().add(adComp.getAdComponent());
			}
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