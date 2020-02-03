package logic.controller;

import javafx.stage.Stage;
import logic.gui.AddAdScene;
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
		System.out.println("GUIController: setLogInScene()");
		login = LogInScene.getInstance();
		stage.setScene(login.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setSignUpScene(Stage stage) {
		System.out.println("GUIController: setSignUpScene()");
		signup = SignUpScene.getInstance();
		stage.setScene(signup.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setHomepageScene(Stage stage) {
		System.out.println("GUIController: setHomepageScene()");
		homepage = HomepageScene.getInstance();
		stage.setScene(homepage.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setSettingsScene(Stage stage) {
		System.out.println("GUIController: setSettingsScene()");
		settings = SettingScene.getInstance();
		stage.setScene(settings.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setAddAdScene(Stage stage) {
		System.out.println("GUIController: setAddAdScene()");
		addAd = AddAdScene.getInstance();
		stage.setScene(addAd.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setMyReviewScene(Stage stage) {
		System.out.println("GUIController: setMyReviewScene()");
		myReview = new MyReviewScene();
		stage.setScene(myReview.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setMyAdsScene(Stage stage) {
		System.out.println("GUIController: setMyAdScene()");
		myAds = MyAdsScene.getInstance();
		stage.setScene(myAds.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public static GUIController getInstance() {
		if(instance == null)
			instance = new GUIController();
		return instance;
	}
}
