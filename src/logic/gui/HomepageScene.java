package logic.gui;

import javafx.stage.Stage;
import logic.controller.HomepageController;

public class HomepageScene extends HomepageBaseScene{
	
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
