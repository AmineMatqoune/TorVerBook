package logic.gui.popup;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InfoPopup extends MyPopup {

	public InfoPopup(String message, Stage stage) {
		super(message, stage);

		headerLabel.setText("Info Message");

		Button button = new Button("Okay");
		button.setPrefHeight(25);
		button.setPrefWidth(85);
		button.setLayoutX(108);
		button.setLayoutY(100);
		pane.getChildren().add(button);
		button.setOnMouseClicked(event->{
			popup.hide();
		});
	}
}
