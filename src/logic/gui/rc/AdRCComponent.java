package logic.gui.rc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logic.ad.Ad;
import logic.gui.AdComponent;
import logic.gui.popup.ErrorPopup;

public class AdRCComponent extends AdComponent{

	public AdRCComponent(Ad ad) {
		super(ad);
		
		pane.setPrefWidth(725);
		
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
	        closeImage.setLayoutY(175);
	        pane.getChildren().add(closeImage);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
}