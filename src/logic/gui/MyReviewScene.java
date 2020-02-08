package logic.gui;

import javafx.scene.paint.Color;
import logic.controller.MyReviewController;

public class MyReviewScene extends DashBoardScene{

	private MyReviewController myReviewController = null;
	
	public MyReviewScene() {
		super();
		
		myReviewLabel.setTextFill(Color.YELLOW);
		
		this.setCentralPaneBackground(true);
		this.setCentralPaneFullSize(true);
		
		myReviewController = new MyReviewController();
		myReviewController.attachAdsTo(centralPane);
	}
}