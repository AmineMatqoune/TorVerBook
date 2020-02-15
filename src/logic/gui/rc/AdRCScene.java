package logic.gui.rc;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.controller.AdRCController;

public class AdRCScene extends RCHomepage{

	private AdRCController controller = null;
	private Pane componentPane;
	
	public AdRCScene() {
		super();
		
		adLabel.setTextFill(Color.YELLOW);
		
		controller = AdRCController.getInstance();
		
		componentPane = new Pane();
		componentPane.setLayoutX(25);
		componentPane.setLayoutY(25);
		centralPane.getChildren().add(componentPane);
		
		controller.showRCAd(componentPane);
	}
}