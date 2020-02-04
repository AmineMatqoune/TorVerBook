package logic.gui;

import javafx.scene.paint.Color;

public class MyReviewScene extends DashBoardScene{

	public MyReviewScene() {
		super();
		myReviewLabel.setTextFill(Color.YELLOW);
		this.setCentralPaneBackground(true);
		this.setCentralPaneFullSize(true);
	}
}