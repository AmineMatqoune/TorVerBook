package logic.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.controller.GuiController;

public class MainGui extends Application{

	public Stage myStage;
	public Scene myScene;
	public GuiController gui;

	public MainGui() {
		new GuiController(this);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		myStage = primaryStage;
		myStage.setTitle("TorVerBook");
		myStage.setWidth(1600);
		myStage.setHeight(900);
		myStage.setResizable(false);
		myStage.show();
	}

	public void loadScene(Scene scene) {
		System.out.println(scene == null);
		myStage.setScene(scene);
	}
}
