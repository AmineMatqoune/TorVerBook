package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.gui.popup.ErrorPopup;
import logic.stuff.Review;

public class ReviewRCComponent extends ReviewComponent{

	public ReviewRCComponent(Review review) {
		super(review);
		
		pane.setPrefWidth(625);
		
		backgroundPaneLabel.setPrefWidth(625);
		
		try {
			FileInputStream input = new FileInputStream("img/check.png");
			Image image = new Image(input);
	        ImageView checkImage = new ImageView(image);
	        checkImage.setLayoutX(550);
	        pane.getChildren().add(checkImage);
	        
	        FileInputStream input2 = new FileInputStream("img/close.png");
			Image image2 = new Image(input2);
	        ImageView closeImage = new ImageView(image2);
	        closeImage.setLayoutX(550);
	        closeImage.setLayoutY(75);
	        pane.getChildren().add(closeImage);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}

}
