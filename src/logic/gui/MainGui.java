package logic.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application{

	public Stage myStage;
	public Scene myScene;
	public LogInScene login;
	
	public MainGui(String[] args) {
		launch(args);
		login = new LogInScene();
		setScene(login.getScene());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		myStage = primaryStage;
		myStage.setTitle("TorVerBook - LogIn");
		myStage.setWidth(1600);
		myStage.setHeight(900);
		myStage.setResizable(false);
	}

	public void setScene(Scene scene) {
		myStage.setScene(scene);
	}	
}
