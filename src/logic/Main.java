package logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.gui.LogInScene;

public class Main extends Application{

	public Stage myStage;
	public LogInScene login;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		myStage = primaryStage;
		myStage.setTitle("TorVerBook - LogIn");
		myStage.setWidth(1600);
		myStage.setHeight(900);
		myStage.setResizable(false);
		
		login = new LogInScene();
		myStage.setScene(login.getScene());
		
		myStage.show();
	}

	public void setScene(Scene scene) {
		myStage.setScene(scene);
	}	

}
