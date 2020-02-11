package logic.gui;

import javafx.scene.paint.Color;
import logic.controller.MyAdsController;

public class MyAdsScene extends DashBoardScene{
	
	private static MyAdsScene instance = null; 
	private MyAdsController myAdsController = new MyAdsController();
	
	private MyAdsScene() {
		super();
		
    	myAdsLabel.setTextFill(Color.YELLOW);
		
		setCentralPaneBackground(true);
		setCentralPaneFullSize(true);
	
		myAdsController.attachAdsTo(centralPane);
	}
	
	public void refresh() {
		myAdsController = new MyAdsController();
		myAdsController.attachAdsTo(centralPane);
	}
	
	public static MyAdsScene getInstance() {
		if(instance == null)
			instance = new MyAdsScene();
		return instance;
	}
}
