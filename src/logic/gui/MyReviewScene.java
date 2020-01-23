package logic.gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.account.User;
import logic.stuff.Review;

public class MyReviewScene extends DashBoardScene{

	public MyReviewScene() {
		super();
		
		myReviewLabel.setTextFill(Color.YELLOW);
		
		//da togliere
		User writer = new User("A", "B", "Ludo98", "C", "D");
		User receiver = new User("E", "F", "Amine139", "G", "H");
		
		Review review = new Review("Ce stava sto nfame fracico che ma rifilato na chiavica de libro", "2020-01-23", (float) 3.8, writer, receiver);		
		
		Pane pane = new ReviewComponent(review).getReviewComponent();	
		//fino qua
		
		pane.setLayoutX(25);
		pane.setLayoutX(50);
		centralPane.getChildren().add(pane);
	}
}