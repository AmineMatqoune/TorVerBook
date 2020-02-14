package logic.gui.rc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.gui.popup.ErrorPopup;
import logic.bean.ReviewBean;
import logic.controller.ReviewRCController;
import logic.gui.ReviewComponent;

public class ReviewRCComponent extends ReviewComponent{

	private static ReviewRCController con;
	
	public ReviewRCComponent(ReviewBean reviewBean) {
		super(reviewBean);

		pane.setPrefWidth(625);
		
		backgroundPaneLabel.setPrefWidth(625);
		
		try {
			FileInputStream input = new FileInputStream("img/check.png");
			Image image = new Image(input);
	        ImageView checkImage = new ImageView(image);
	        checkImage.setLayoutX(550);
	        checkImage.setOnMouseClicked(event -> 
        	checkPress(reviewBean)
	        );
	        pane.getChildren().add(checkImage);
	        
	        FileInputStream input2 = new FileInputStream("img/close.png");
			Image image2 = new Image(input2);
	        ImageView closeImage = new ImageView(image2);
	        closeImage.setLayoutX(550);
	        closeImage.setLayoutY(75);
	        closeImage.setOnMouseClicked(event -> 
        	closePress(reviewBean)
	        );
	        pane.getChildren().add(closeImage);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private static void checkPress(ReviewBean review) {
		con = new ReviewRCController();
		con.acceptReview(review.getWriter(), review.getReceiver());
	}
	
	private static void closePress(ReviewBean review) {
		con = new ReviewRCController();
		con.deleteReview(review.getWriter(), review.getReceiver());
	}

}
