package logic.gui;

import javafx.stage.Stage;

public class GUIController {
	
	private static GUIController instance = null;
	
	public void setLogInScene(Stage stage) {
		LogInScene login = LogInScene.getInstance();
		stage.setScene(login.getScene());
	}
	
	public void setSignUpScene(Stage stage) {
		/*SignUpScene signup = SignUpScene.getInstance();
		System.out.println("aooooo");
		stage.setScene(signup.getScene());*/
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
