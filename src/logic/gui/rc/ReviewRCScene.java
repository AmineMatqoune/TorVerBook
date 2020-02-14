package logic.gui.rc;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.controller.ReviewRCController;

public class ReviewRCScene extends RCHomepage{

	private ReviewRCController controller = null;
	private Pane componentPane;
	
	public ReviewRCScene() {
		super();
		
		reviewLabel.setTextFill(Color.YELLOW);
		
		controller = new ReviewRCController();
		
		componentPane = new Pane();
		componentPane.setLayoutX(25);
		componentPane.setLayoutY(25);
		centralPane.getChildren().add(componentPane);
		
		controller.showRCReview(componentPane);
	}
}