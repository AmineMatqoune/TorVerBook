package logic.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application{

	public Stage myStage;
	public Scene myScene;
	public LogInScene login;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		myStage = primaryStage;
		myStage.setTitle("TorVerBook");
		myStage.setWidth(1600);
		myStage.setHeight(900);
		myStage.setResizable(false);
		
		login = new LogInScene();
		myStage.setScene(login.getScene());
		myStage.show();
	}

	public void loadScene(Scene scene) {
		myStage.setScene(scene);
	}	
}
