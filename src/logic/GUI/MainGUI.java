package logic.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGUI extends Application {

	Stage myStage;	
	
	@Override
	public void start(Stage stage) throws Exception {
		this.myStage = stage;
		this.myStage.setTitle("TorVerBook");
		this.myStage.setResizable(false);
		this.myStage.setHeight(900);
		this.myStage.setWidth(1600);
		this.myStage.centerOnScreen();
		this.myStage.show();
		settaScene(new BaseScene().getScene());
	}

	public void settaScene(Scene scene) {
		myStage.setScene(scene);
	}

}
