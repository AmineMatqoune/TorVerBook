package logic.gui.rc;

import javafx.scene.paint.Color;
import logic.controller.AdRCController;

public class AdRCScene extends RCHomepage{

	private AdRCController controller = null;
	
	public AdRCScene() {
		super();
		
		adLabel.setTextFill(Color.YELLOW);
		controller = new AdRCController();
		controller.showRCAd(componentPane);
		System.out.println("FLAG1");
	}
}