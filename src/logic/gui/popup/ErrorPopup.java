package logic.gui.popup;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorPopup extends MyPopup{

	public ErrorPopup(String message, Stage stage) {
		super(message, stage);
		
		headerLabel.setText("Fatal Error");
		
		Button button = new Button("Close App");
        button.setPrefHeight(25);
        button.setPrefWidth(85);
        button.setLayoutX(108);
        button.setLayoutY(100);
        pane.getChildren().add(button);
        button.setOnMouseClicked(event ->
        	System.exit(0)
        );
	}

}
