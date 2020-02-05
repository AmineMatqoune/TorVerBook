package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.gui.popup.ErrorPopup;
import logic.stuff.Review;
import logic.controller.ReviewRCController;
import logic.gui.ReviewComponent;

public class ReviewRCComponent extends ReviewComponent{

	private static ReviewRCController con;
	
	public ReviewRCComponent(Review review) {
		super(review);
		
		pane.setPrefWidth(625);
		
		backgroundPaneLabel.setPrefWidth(625);
		
		try {
			FileInputStream input = new FileInputStream("img/check.png");
			Image image = new Image(input);
	        ImageView checkImage = new ImageView(image);
	        checkImage.setLayoutX(550);
	        checkImage.setOnMouseClicked(event -> 
        	checkPress(review)
	        );
	        pane.getChildren().add(checkImage);
	        
	        FileInputStream input2 = new FileInputStream("img/close.png");
			Image image2 = new Image(input2);
	        ImageView closeImage = new ImageView(image2);
	        closeImage.setLayoutX(550);
	        closeImage.setLayoutY(75);
	        closeImage.setOnMouseClicked(event -> 
        	closePress(review)
	        );
	        pane.getChildren().add(closeImage);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private static void checkPress(Review review) {
		con = new ReviewRCController();
		con.checkReview(review);
	}
	
	private static void closePress(Review review) {
		con = new ReviewRCController();
		con.deleteReview(review);
	}

}
