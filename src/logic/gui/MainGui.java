package logic.gui;

import java.io.IOException;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
			} catch (IOException e) {
				new MyPopup("Error while loading main scene", stage);
			}		
	}
}
