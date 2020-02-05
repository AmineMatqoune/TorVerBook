package logic.gui;

import javafx.scene.paint.Color;
import logic.controller.FavouriteListController;

public class FavouriteListScene extends DashBoardScene{
	
	private FavouriteListController controller = null;
	
	public FavouriteListScene() {
		super();
		
		favouriteListLabel.setTextFill(Color.YELLOW);
		
		controller = new FavouriteListController();
		setCentralPaneBackground(true);
		setCentralPaneFullSize(true);
	
		controller.attachAdsTo(centralPane);
	}

}
