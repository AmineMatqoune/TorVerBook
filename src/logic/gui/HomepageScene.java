package logic.gui;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.controller.HomepageController;

public class HomepageScene extends DashBoardScene{
	
	private static HomepageScene instance = null;
	
	private HomepageScene() {
		super();
		
		homepageLabel.setTextFill(Color.YELLOW);		
	}
	
	public static HomepageScene getInstance() {
		if(instance == null) 
			instance = new HomepageScene();
		return instance;
	}

}
