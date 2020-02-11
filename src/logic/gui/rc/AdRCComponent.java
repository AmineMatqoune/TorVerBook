package logic.gui.rc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import logic.bean.AdBean;
import logic.controller.AdRCController;
import logic.gui.AdComponent;
import logic.gui.popup.ErrorPopup;

public class AdRCComponent extends AdComponent {

	private AdRCController con;

	public AdRCComponent(AdBean adBean) {
		super(adBean);
		pane.setPrefWidth(675);

		try {
			FileInputStream input = new FileInputStream("img/check.png");
			Image image = new Image(input);
			ImageView checkImage = new ImageView(image);
			checkImage.setLayoutX(550);
			checkImage.setLayoutY(50);
			checkImage.setOnMouseClicked(event -> checkPress());
			pane.getChildren().add(checkImage);

			FileInputStream input2 = new FileInputStream("img/close.png");
			Image image2 = new Image(input2);
			ImageView closeImage = new ImageView(image2);
			closeImage.setLayoutX(550);
			closeImage.setLayoutY(225);
			closeImage.setOnMouseClicked(event -> closePress());
			pane.getChildren().add(closeImage);
		} catch (FileNotFoundException e) {
			new ErrorPopup(e.getMessage(), (Stage) pane.getScene().getWindow());
		}
	}

	private void checkPress() {
		con = new AdRCController();
		con.acceptAd(id);
	}

	private void closePress() {
		con = new AdRCController();
		con.deleteAd(id);
	}
}