package logic;

import logic.GUI.*;

public class GUIController {

	MainGUI main;
	
	BaseScene base;
	LoginPage login;
	
	public GUIController() {
		main = new MainGUI();
		MainGUI.launch(MainGUI.class);
		loadLogin();
	}
	
	public void loadLogin() {
		base = new BaseScene();
		//main.setScene(base.getScene());
	}
	
}
