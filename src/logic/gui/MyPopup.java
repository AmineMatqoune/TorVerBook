package logic.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MyPopup {
	
	public MyPopup(String message, Stage stage) {
		Popup popup = new Popup();
		
		AnchorPane pane = new AnchorPane();
		pane.prefHeight(200);
		pane.prefWidth(300);
		
		Label label = new Label(message);
        label.setPrefWidth(300); 
        label.setPrefHeight(150); 
        label.setWrapText(true);
        label.setFont(new Font("Arial Bold", 12));
        label.setTextAlignment(TextAlignment.CENTER);
        
        Button button = new Button("Close App");
        button.setPrefHeight(25);
        button.setPrefWidth(85);
        button.setLayoutX(108);
        button.setLayoutY(161);
        
        button.setOnMouseClicked(event ->{
        	System.exit(0);
        });
        
        pane.getChildren().add(label);
        pane.getChildren().add(button);
		popup.getContent().add(pane);
		
		if(!popup.isShowing())
			popup.show(stage);
	}
	
}
