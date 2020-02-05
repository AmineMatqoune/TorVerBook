package logic.gui.rc;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.gui.BaseScene;

public abstract class RCHomepage extends BaseScene{
	
	protected Pane pane;
	protected Pane menuPane;
	protected Label infoSettingsLabel;
	protected Label reviewLabel;
	protected Label adLabel;
	protected Pane componentPane;
	protected ScrollPane sp;
	
	protected String fontText = "Arial";
	
	public RCHomepage() {
		super();
		
		pane = (Pane) scene.getRoot();
		
		menuPane = new Pane();
		menuPane.setPrefSize(300, 582);
		menuPane.setLayoutX(0);
		menuPane.setLayoutY(168);
		menuPane.setStyle("-fx-background-color: #024a00");
		pane.getChildren().add(menuPane);
		
		infoSettingsLabel = new Label("Info/Settings");
		infoSettingsLabel.setPrefSize(300, 100);
		infoSettingsLabel.setFont(new Font(fontText, 36));
		infoSettingsLabel.setAlignment(Pos.CENTER);
		infoSettingsLabel.setTextFill(Color.WHITE);
		menuPane.getChildren().add(infoSettingsLabel);
		
		reviewLabel = new Label("Review");
		reviewLabel.setPrefSize(300, 100);
		reviewLabel.setFont(new Font(fontText, 36));
		reviewLabel.setAlignment(Pos.CENTER);
		reviewLabel.setTextFill(Color.WHITE);
		reviewLabel.setLayoutY(100);
		menuPane.getChildren().add(reviewLabel);
		
		adLabel = new Label("Ad");
		adLabel.setPrefSize(300, 100);
		adLabel.setFont(new Font(fontText, 36));
		adLabel.setAlignment(Pos.CENTER);
		adLabel.setTextFill(Color.WHITE);
		adLabel.setLayoutY(200);
		menuPane.getChildren().add(adLabel);
		
		/*1. su questo pannello vengono aggiunti i component*/
		componentPane = new Pane();
		componentPane.setPrefSize(900, 582);
		componentPane.setLayoutX(300);
		componentPane.setLayoutY(168);
		pane.getChildren().add(componentPane);
		
		/*2. viene applicato lo scrollpane a componentpane*/
		sp = new ScrollPane();
		sp.setContent(componentPane);
		sp.setPrefSize(900, 582);
		sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
	}

}