package logic.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;

public class BaseScene {
	
	private String WHITE_COLOR = "-fx-background-color:#FFFFFF"; 
	
	private Scene baseScene;
	
	public BaseScene() {
		VBox vbox = new VBox();
		
		HBox hbox0 = new HBox();
		HBox hbox1 = new HBox();
		
		vbox.getChildren().add(hbox0);
		vbox.getChildren().add(hbox1);
		
		Label titleLbl = new Label("TorVerBook");
		titleLbl.setStyle(WHITE_COLOR);
		titleLbl.setFont(new Font("Comic Sans MS", 48));
		titleLbl.setAlignment(Pos.CENTER);
		hbox0.getChildren().add(titleLbl);
		
		Label languageLbl = new Label("Lingua: ITA/ENG"); 
		languageLbl.setStyle(WHITE_COLOR);
		languageLbl.setFont(new Font("Helvetica", 16));
		languageLbl.setAlignment(Pos.CENTER);
		hbox0.getChildren().add(languageLbl);
		
		baseScene = new Scene(vbox);
	}
	
	public Scene getScene() {
		return this.baseScene;
	}

}
