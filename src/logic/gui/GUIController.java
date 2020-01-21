package logic.gui;

import javafx.stage.Stage;

public class GUIController {
	
	private static GUIController instance = null;
	private SignUpScene signup;
	
	private GUIController() {}
	
	public void setLogInScene(Stage stage) {
		System.out.println("GUIController: setLogInScene()");
		LogInScene login = LogInScene.getInstance();
		stage.setScene(login.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setSignUpScene(Stage stage) {
		System.out.println("GUIController: setSignUpScene()");
		signup = SignUpScene.getInstance();
		stage.setScene(signup.getScene());
		System.out.println("----COMPLETATO");
	}
	
	//carica temporaneamente la SettingPage invece della HomePage
	public void setHomepageScene(Stage stage) {
		System.out.println("GUIController: setHomepageScene()");
		//temporaneamente settato come homepage la SettingPage per testarla
		HomepageScene homepage = HomepageScene.getInstance();
		stage.setScene(homepage.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public void setSettingsScene(Stage stage) {
		System.out.println("GUIController: setSettingsScene()");
		SettingScene settings = SettingScene.getInstance();
		stage.setScene(settings.getScene());
		System.out.println("----COMPLETATO");
	}
	
	public static GUIController getInstance() {
		if(instance == null)
			instance = new GUIController();
		return instance;
	}
}
