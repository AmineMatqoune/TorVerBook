package logic.controller;

import javafx.stage.Stage;
import logic.gui.GUIController;
import logic.gui.HomepageScene;

public class HomepageController {

	private GUIController guiController = GUIController.getInstance();
	
	public void loadSettingPage() {
		guiController.setSettingsScene((Stage) HomepageScene.getInstance().getScene().getWindow());
	}

}
