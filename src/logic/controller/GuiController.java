package logic.controller;

import logic.gui.LogInScene;
import logic.gui.MainGui;
import logic.gui.SignInScene;

public class GuiController {
	
	LogInController logCon = LogInController.getInstance();
	
	public SignInScene signIn;
	public LogInScene logIn;
	
	public MainGui mainGui;
	
	public GuiController(MainGui mainGui) {
		this.mainGui = mainGui;
		loadLogIn();
	}
	
	public void loadLogIn() {
		logIn = new LogInScene();
		System.out.println("Ciao");
		mainGui.loadScene(logIn.getScene());	
	}
}
