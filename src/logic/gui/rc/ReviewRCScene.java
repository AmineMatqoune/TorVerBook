package logic.gui.rc;

import javafx.scene.paint.Color;
import logic.controller.ReviewRCController;

public class ReviewRCScene extends RCHomepage{

	private ReviewRCController controller = null;
	
	public ReviewRCScene() {
		super();
		
		reviewLabel.setTextFill(Color.YELLOW);
		controller = new ReviewRCController();
		controller.showRCReview(componentPane);
	}
}