package logic.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		stage.setTitle("TorVerBook - Login");
		stage.setResizable(false);
		stage.setScene(new Scene(root, 1600, 900));
		stage.show();		
	}
}