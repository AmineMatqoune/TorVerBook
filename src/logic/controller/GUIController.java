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

public class GUIController {
	
	private static GUIController instance = null;
	
	private LogInScene login;
	private SignUpScene signup;
	private HomepageScene homepage;
	private MyReviewScene myReview;
	private SettingScene settings;
	private AddAdScene addAd;
	private MyAdsScene myAds;
	
	private GUIController() {}
	
	public void setLogInScene(Stage stage) {
		login = LogInScene.getInstance();
		stage.setScene(login.getScene());
	}
	
	public void setSignUpScene(Stage stage) {
		signup = SignUpScene.getInstance();
		stage.setScene(signup.getScene());
	}
	
	public void setHomepageScene(Stage stage) {
		homepage = HomepageScene.getInstance();
		stage.setScene(homepage.getScene());
	}
	
	public void setSettingsScene(Stage stage) {
		settings = SettingScene.getInstance();
		stage.setScene(settings.getScene());
	}
	
	public void setAddAdScene(Stage stage) {
		addAd = AddAdScene.getInstance();
		stage.setScene(addAd.getScene());
	}
	
	public void setFavouriteListScene(Stage stage) {
		FavouriteListScene favList = new FavouriteListScene();
		stage.setScene(favList.getScene());
	}
	
	public void setMyReviewScene(Stage stage) {
		myReview = new MyReviewScene();
		stage.setScene(myReview.getScene());
	}
	
	public void setMyAdsScene(Stage stage) {
		myAds = MyAdsScene.getInstance();
		stage.setScene(myAds.getScene());
	}
	
	public static GUIController getInstance() {
		if(instance == null)
			instance = new GUIController();
		return instance;
	}
}
