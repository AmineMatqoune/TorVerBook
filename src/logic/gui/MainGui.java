package logic.gui;

import javafx.application.*;
import javafx.stage.Stage;


public class MainGui extends Application{

	private GUIController guiController = GUIController.getInstance();
	private Stage stage;
	
	@Override
	public void start(Stage args) {
		stage = args;
		stage.setTitle("TorVerBook");
		stage.setResizable(false);
		stage.show();
		
		guiController.setLogInScene(stage);
	}
	
	public Stage getStage() {
		return stage;
	}
}
