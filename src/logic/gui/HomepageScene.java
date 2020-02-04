package logic.gui;

import javafx.scene.paint.Color;
import logic.controller.HomepageController;

public class HomepageScene extends DashBoardScene{
	
	private static HomepageScene instance = null;
	private HomepageController hpController = new HomepageController();
	
	private HomepageScene() {
		super();
		
		homepageLabel.setTextFill(Color.YELLOW);
		this.setCentralPaneFullSize(true);
		this.setCentralPaneBackground(true);
		
		hpController.attachAdsTo(centralPane);
	}
	
	public static HomepageScene getInstance() {
		if(instance == null) 
			instance = new HomepageScene();
		return instance;
	}

}
