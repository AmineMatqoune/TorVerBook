package logic.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.controller.GUIController;


public class MainGui extends Application{

	private GUIController guiController = GUIController.getInstance();
	private Stage stage;
	
	@Override
	public void start(Stage args) {
		stage = args;
		stage.setTitle("TorVerBook");
		stage.setResizable(false);
		stage.setY(0);
		stage.show();
		guiController.setLogInScene(stage);
	}
	
	public Stage getStage() {
		return stage;
	}
}
