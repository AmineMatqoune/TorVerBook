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
	
	public void setHomepageScene(Stage stage) {
		HomepageBaseScene homepage = HomepageBaseScene.getInstance();
		stage.setScene(homepage.getScene());
		
	}
	
	public static GUIController getInstance() {
		if(instance == null)
			instance = new GUIController();
		return instance;
	}
}
