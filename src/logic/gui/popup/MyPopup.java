package logic.gui.popup;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

public abstract class MyPopup {

	protected AnchorPane pane;
	protected Label headerLabel;
	protected Popup popup;

	public MyPopup(String message, Stage stage) {
		this.popup = new Popup();

		pane = new AnchorPane();
		pane.prefHeight(325);
		pane.prefWidth(300);
		pane.setStyle("-fx-background-color: #ffffff");

		headerLabel = new Label();
		headerLabel.setPrefWidth(300);
		headerLabel.setPrefHeight(30);
		headerLabel.setAlignment(Pos.CENTER);
		headerLabel.setFont(new Font("Arial bold", 24));
		headerLabel.setStyle("-fx-background-color: #024a00");
		headerLabel.setTextFill(Color.WHITE);
		pane.getChildren().add(headerLabel);

		Label label = new Label(message);
		label.setPrefWidth(300);
		label.setPrefHeight(70);
		label.setLayoutY(30);
		label.setWrapText(true);
		label.setFont(new Font("Arial Bold", 12));
		label.setAlignment(Pos.CENTER);
		pane.getChildren().add(label);

		this.popup.getContent().add(pane);

		if (!this.popup.isShowing())
			this.popup.show(stage);
	}
}
