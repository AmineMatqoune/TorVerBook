package logic.gui;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MainGui extends Application{

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/logic/gui/LogIn.fxml"));
			
			stage.setTitle("TorVerBook - LogIn");
			stage.setResizable(false);
			stage.setScene(new Scene(root)); 
			stage.show();
		}catch (Exception e){
			Popup popup = new Popup();
			Label label = new Label("Error while loading main scene");
			popup.getContent().add(label);
			popup.show(stage);
		}
		
	}
}
