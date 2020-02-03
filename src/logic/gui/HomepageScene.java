package logic.gui;

import javafx.scene.paint.Color;

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
