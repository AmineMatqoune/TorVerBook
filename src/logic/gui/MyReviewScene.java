package logic.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.controller.MyReviewController;

public class MyReviewScene extends DashBoardScene{

	private MyReviewController myReviewController = null;
	
	public MyReviewScene() {
		super();
		
		myReviewLabel.setTextFill(Color.YELLOW);
		
		myReviewController = new MyReviewController();
		
		this.setCentralPaneBackground(true);
		this.setCentralPaneFullSize(true);
		
		Pane avgPane = new Pane();
		avgPane.setPrefSize(600, 50);
		centralPane.getChildren().add(avgPane);
		
		Label avgLabel = new Label("Average rank: " + myReviewController.getAverage());
		avgLabel.setFont(new Font("Arial", 25));
		avgLabel.setLayoutX(50);
		avgLabel.setLayoutY(20);
		avgPane.getChildren().add(avgLabel);
		
		Pane componentPane = new Pane();
		componentPane.setPrefSize(600, 550);
		componentPane.setLayoutY(25);
		componentPane.setLayoutY(50);
		centralPane.getChildren().add(componentPane);
		
		myReviewController.attachAdsTo(componentPane);
	}
}