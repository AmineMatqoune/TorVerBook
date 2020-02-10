package logic.gui.rc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.ad.Ad;
import logic.controller.AdRCController;
import logic.controller.ReviewRCController;
import logic.gui.AdComponent;
import logic.gui.popup.ErrorPopup;
import logic.stuff.Review;

public class AdRCComponent extends AdComponent{

	private static AdRCController con;
	
	public AdRCComponent(Ad ad) {
		super(ad);
		pane.setPrefWidth(675);
		
		try {
			FileInputStream input = new FileInputStream("img/check.png");
			Image image = new Image(input);
	        ImageView checkImage = new ImageView(image);
	        checkImage.setLayoutX(550);
	        checkImage.setLayoutY(50);
	        checkImage.setOnMouseClicked(event -> 
        		checkPress(ad)
	        );
	        pane.getChildren().add(checkImage);
	        
	        FileInputStream input2 = new FileInputStream("img/close.png");
			Image image2 = new Image(input2);
	        ImageView closeImage = new ImageView(image2);
	        closeImage.setLayoutX(550);
	        closeImage.setLayoutY(225);
	        closeImage.setOnMouseClicked(event -> 
        		closePress(ad)
	        );
	        pane.getChildren().add(closeImage);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	private static void checkPress(Ad ad) {
		con = new AdRCController();
		con.acceptAd(ad);
	}
	
	private static void closePress(Ad ad) {
		con = new AdRCController();
		con.deleteAd(ad);
	}
}