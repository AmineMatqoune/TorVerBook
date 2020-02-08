package logic.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.account.User;
import logic.ad.Ad;
import logic.dao.AccountDAO;
import logic.gui.AdComponent;

public class MyAdsController {
	
	private Ad[] ads;
	private User currentUser;
	
	public MyAdsController() {
		AccountDAO userDAO = AccountDAO.getInstance();
		currentUser = (User) userDAO.getAccountObject();
		ads = getAds();
	}
	
	private Ad[] getAds() {
		return currentUser.getMyAds();
	}
	
	public void attachAdsTo(Pane pane) {
		if(ads != null)
			for(int i = 0; i < ads.length; i++){
				AdComponent adComp = new AdComponent(ads[i]);
				adComp.setY(AdComponent.HEIGHT * i);
				pane.getChildren().add(adComp.getAdPane());      //aggiungiamo il pane dell'ad allo scrollpane;*/
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
