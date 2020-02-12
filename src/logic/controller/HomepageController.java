package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.account.User;
import logic.ad.Ad;
import logic.ad.AdCategory;
import logic.bean.AdBean;
import logic.dao.AccountDAO;
import logic.dao.AdDAO;
import logic.gui.AdComponent;
import logic.gui.AdUComponent;
import logic.gui.popup.ErrorPopup;

public class HomepageController {

	private Ad[] ads;
	private AdDAO adDao;
	private Pane hpPane;
	private ArrayList<AdUComponent> genericAdList;

	public HomepageController() {
		try {
			adDao = AdDAO.getInstance();
			ads = adDao.getHomepageAdsList(); // initializing Ads that will be shown in Homepage
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) hpPane.getScene().getWindow());
		}
	}

	public void attachAdsTo(Pane pane) {
		hpPane = pane;
		genericAdList = new ArrayList<>();
		User user = (User) AccountDAO.getInstance().getAccountObject();
		try {
			if (ads != null)
				for (int i = 0; i < ads.length; i++) {
					boolean isFavourite = adDao.checkIsFavouriteAd(ads[i].getId(), user.getUsername());
					AdBean adBean = new AdBean(ads[i]);
					adBean.setFavourite(isFavourite);
					AdUComponent adComp = new AdUComponent(adBean);
					adComp.setY(AdComponent.HEIGHT * i);
					genericAdList.add(adComp);
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
		} catch (SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage) hpPane.getScene().getWindow());
		}
	}

	public void searchList(String category, String type, double price) {
		try {

			if (category.contentEquals(AdCategory.ANY.toString())) {
				hpPane.getChildren().clear();
				for (AdUComponent component : genericAdList) {
					hpPane.getChildren().add(component.getAdComponent());
				}
				return;
			}

			Ad[] searchAds = adDao.loadSearchAd(category, type, price);
			hpPane.getChildren().clear();
			if (searchAds != null)
				for (int i = 0; i < searchAds.length; i++) {
					boolean isFavourite = adDao.checkIsFavouriteAd(searchAds[i].getId(), searchAds[i].getMyUserStr());
					AdBean adBean = new AdBean(searchAds[i]);
					adBean.setFavourite(isFavourite);
					AdUComponent adComp = new AdUComponent(adBean);
					adComp.setY(AdComponent.HEIGHT * i);
					hpPane.getChildren().add(adComp.getAdComponent()); // aggiungiamo l'adComponent allo scrollpane
				}
			else {
				Label tmp = new Label("Empty List!");
				tmp.setFont(new Font("Arial Bold", 50));
				tmp.setAlignment(Pos.CENTER);
				tmp.setPrefHeight(230);
				tmp.setPrefWidth(585);
				hpPane.getChildren().add(tmp);
			}
		} catch (ParseException | SQLException e) {
			new ErrorPopup(e.getMessage(), (Stage) hpPane.getScene().getWindow());
		}
	}

}
