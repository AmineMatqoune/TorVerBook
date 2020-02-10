package logic.gui.rc;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.controller.GUIController;
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
	
	protected static final String BG_COLOR_SIDE_BUTTON_NORMAL = "#024a00";
	protected static final String BG_COLOR_SIDE_BUTTON_HOVERED = "#feca57";
	
	protected GUIController guiController = GUIController.getInstance();
	
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
		infoSettingsLabel.setOnMouseReleased(event -> guiController.setRCSettingsScene((Stage) pane.getScene().getWindow()));
		infoSettingsLabel.setOnMouseEntered(event -> infoSettingsLabel.setStyle("-fx-background-color: " + BG_COLOR_SIDE_BUTTON_HOVERED ));
		infoSettingsLabel.setOnMouseExited(event -> infoSettingsLabel.setStyle("-fx-background-color: " + BG_COLOR_SIDE_BUTTON_NORMAL));
		infoSettingsLabel.setCursor(Cursor.HAND);
		menuPane.getChildren().add(infoSettingsLabel);
		
		reviewLabel = new Label("Review");
		reviewLabel.setPrefSize(300, 100);
		reviewLabel.setFont(new Font(fontText, 36));
		reviewLabel.setAlignment(Pos.CENTER);
		reviewLabel.setTextFill(Color.WHITE);
		reviewLabel.setLayoutY(100);
		reviewLabel.setOnMouseReleased(event -> guiController.setRCReviewScene((Stage) pane.getScene().getWindow()));
		reviewLabel.setOnMouseEntered(event -> reviewLabel.setStyle("-fx-background-color: " + BG_COLOR_SIDE_BUTTON_HOVERED ));
		reviewLabel.setOnMouseExited(event -> reviewLabel.setStyle("-fx-background-color: " + BG_COLOR_SIDE_BUTTON_NORMAL));
		reviewLabel.setCursor(Cursor.HAND);
		menuPane.getChildren().add(reviewLabel);
		
		adLabel = new Label("Ad");
		adLabel.setPrefSize(300, 100);
		adLabel.setFont(new Font(fontText, 36));
		adLabel.setAlignment(Pos.CENTER);
		adLabel.setTextFill(Color.WHITE);
		adLabel.setLayoutY(200);
		adLabel.setOnMouseReleased(event -> guiController.setRCAdScene((Stage) pane.getScene().getWindow()));
		adLabel.setOnMouseEntered(event -> adLabel.setStyle("-fx-background-color: " + BG_COLOR_SIDE_BUTTON_HOVERED ));
		adLabel.setOnMouseExited(event -> adLabel.setStyle("-fx-background-color: " + BG_COLOR_SIDE_BUTTON_NORMAL));
		adLabel.setCursor(Cursor.HAND);
		menuPane.getChildren().add(adLabel);
		
		sp = new ScrollPane();
		sp.setLayoutX(300);
		sp.setLayoutY(168);
		sp.setPrefSize(900, 582);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		componentPane = new Pane();
		sp.setContent(componentPane);
		pane.getChildren().add(sp);
	}

}