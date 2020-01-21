package logic.gui;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import logic.controller.HomepageController;

public class HomepageScene extends DashBoardScene{
	
	private static HomepageScene instance = null;
	
	private HomepageController homeController = new HomepageController();
	
	private HomepageScene() {
		super();
		
		settingsLabel.setOnMouseClicked(event -> 
			homeController.loadSettingPage()
		);
		
	}
	
	public static HomepageScene getInstance() {
		if(instance == null) 
			instance = new HomepageScene();
		return instance;
	}

}
