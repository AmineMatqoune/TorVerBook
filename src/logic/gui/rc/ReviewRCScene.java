package logic.gui.rc;

import javafx.scene.paint.Color;
import logic.controller.ReviewRCController;
import logic.gui.ReviewRCComponent;
import logic.stuff.Review;

public class ReviewRCScene extends RCHomepage{

	private ReviewRCController controller = null;
	
	public ReviewRCScene() {
		super();
		
		reviewLabel.setTextFill(Color.YELLOW);
		
		controller = new ReviewRCController();
		Review[] review = controller.getReview();
		if(review != null) {
			float xpos = 350;
			float ypos = 180;
			
			System.out.println(review[0].text);
			
			for(int i = 0; i != review.length; i++) {
				
				//issue here: nullPointerException on review[0]
				ReviewRCComponent temp = new ReviewRCComponent(review[i]);
				temp.getReviewComponent().setLayoutX(xpos);
				temp.getReviewComponent().setLayoutY(ypos);
				pane.getChildren().add(temp.getReviewComponent());
				
				ypos = ypos + 200;
			}
		}
		else {
			System.out.println("Non ci sono review!");
		}
	}
}