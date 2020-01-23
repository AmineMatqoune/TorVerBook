package logic.gui;

import javafx.stage.Stage;

public class GUIController {
	
	private static GUIController instance = null;
	
	private LogInScene login;
	private SignUpScene signup;
	private HomepageScene homepage;
	private SettingScene settings;
	
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
	
	public void setMyReviewScene(Stage stage) {
		System.out.println("GUIController: setMyReviewScene()");
		MyReviewScene myReview = new MyReviewScene();
		stage.setScene(myReview.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public static GUIController getInstance() {
		if(instance == null)
			instance = new GUIController();
		return instance;
	}
}
