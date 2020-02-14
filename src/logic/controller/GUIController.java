package logic.controller;

import javafx.stage.Stage;
import logic.gui.AddAdScene;
import logic.gui.FavouriteListScene;
import logic.gui.HomepageScene;
import logic.gui.LogInScene;
import logic.gui.MyAdsScene;
import logic.gui.MyReviewScene;
import logic.gui.SettingScene;
import logic.gui.SignUpScene;
import logic.gui.rc.AdRCScene;
import logic.gui.rc.ReviewRCScene;
import logic.gui.rc.SettingsRCScene;

public class GUIController {
	
	private static GUIController instance = null;
	
	private GUIController() {}
	
	public void setLogInScene(Stage stage) {
		LogInScene login = LogInScene.getInstance();
		stage.setScene(login.getScene());
	}
	
	public void setSignUpScene(Stage stage) {
		SignUpScene signup = SignUpScene.getInstance();
		stage.setScene(signup.getScene());
	}
	
	public void setHomepageScene(Stage stage) {
		HomepageScene homepage = HomepageScene.getInstance(); 
		stage.setScene(homepage.getScene());
	}
	
	public void setSettingsScene(Stage stage) {
		SettingScene settings = SettingScene.getInstance();
		stage.setScene(settings.getScene());
	}
	
	public void setAddAdScene(Stage stage) {
		AddAdScene addAd = AddAdScene.getInstance();
		stage.setScene(addAd.getScene());
	}
	
	public void setFavouriteListScene(Stage stage) {
		FavouriteListScene favList = new FavouriteListScene();
		stage.setScene(favList.getScene());
	}
	
	public void setMyReviewScene(Stage stage) {
		MyReviewScene myReview = new MyReviewScene();
		stage.setScene(myReview.getScene());
	}
	
	public void setMyAdsScene(Stage stage) {
		MyAdsScene myAds = MyAdsScene.getInstance();
		stage.setScene(myAds.getScene());
	}
	
	public void setRCSettingsScene(Stage stage) {
		SettingsRCScene rcSettings = SettingsRCScene.getInstance();
		stage.setScene(rcSettings.getScene());
	}
	
	public void setRCReviewScene(Stage stage) {
		ReviewRCScene review = new ReviewRCScene();
		stage.setScene(review.getScene());
	}
	
	public void setRCAdScene(Stage stage) {
		AdRCScene ad = new AdRCScene();
		stage.setScene(ad.getScene());
	}
	
	public static GUIController getInstance() {
		if(instance == null)
			instance = new GUIController();
		return instance;
	}
}
