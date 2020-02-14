package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.controller.GUIController;
import logic.gui.popup.ErrorPopup;

public abstract class DashBoardScene extends BaseScene {

	protected ScrollPane centralPaneContainer;
	protected AnchorPane centralPane;

	protected Label homepageLabel = new Label("Homepage");
	protected Label settingsLabel = new Label("Settings");
	protected Label addAdLabel = new Label("Add Ad");
	protected Label myAdsLabel = new Label("My Ads");
	protected Label favouriteListLabel = new Label("Favourite List");
	protected Label myReviewLabel = new Label("My Review");
	protected Label usernameLabel1 = new Label("Username1");
	protected Label usernameLabel2 = new Label("Username2");
	protected Label usernameLabel3 = new Label("Username3");
	protected Label messageLabel1 = new Label("Last message 1");
	protected Label messageLabel2 = new Label("Last message 2");
	protected Label messageLabel3 = new Label("Last message 3");
	protected GUIController guiController = GUIController.getInstance();
	
	protected static final String BG_COLOR_SIDE_BUTTON_NORMAL = "-fx-background-color: #024a00";
	protected static final String BG_COLOR_SIDE_BUTTON_HOVERED = "-fx-background-color: #feca57";
	
	protected static final String FONT = "Arial";

	public DashBoardScene() {
		super();
		Pane pane = (Pane) scene.getRoot();
		
		//////LEFT PANE////////////
		Pane leftPane = new Pane();
		leftPane.setLayoutY(150);
		leftPane.setPrefHeight(600);
		leftPane.setPrefWidth(300);
		leftPane.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL);
		pane.getChildren().add(leftPane);

		homepageLabel.setAlignment(Pos.CENTER);
		homepageLabel.setContentDisplay(ContentDisplay.CENTER);
		homepageLabel.setPrefHeight(100);
		homepageLabel.setPrefWidth(300);
		homepageLabel.setFont(new Font(FONT, 36));
		homepageLabel.setTextFill(Color.WHITE);
		homepageLabel.setWrapText(true);
		homepageLabel.setOnMouseReleased(event -> guiController.setHomepageScene((Stage) pane.getScene().getWindow()));
		homepageLabel.setOnMouseEntered(event -> homepageLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED ));
		homepageLabel.setOnMouseExited(event -> homepageLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL));
		homepageLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(homepageLabel);

		settingsLabel.setAlignment(Pos.CENTER);
		settingsLabel.setContentDisplay(ContentDisplay.CENTER);
		settingsLabel.setLayoutY(100);
		settingsLabel.setPrefHeight(100);
		settingsLabel.setPrefWidth(300);
		settingsLabel.setFont(new Font(FONT, 36));
		settingsLabel.setTextFill(Color.WHITE);
		settingsLabel.setWrapText(true);
		settingsLabel.setOnMouseReleased(event -> guiController.setSettingsScene((Stage) pane.getScene().getWindow()));
		settingsLabel.setOnMouseEntered(event -> settingsLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED ));
		settingsLabel.setOnMouseExited(event -> settingsLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL));
		settingsLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(settingsLabel);

		addAdLabel.setAlignment(Pos.CENTER);
		addAdLabel.setContentDisplay(ContentDisplay.CENTER);
		addAdLabel.setLayoutY(200);
		addAdLabel.setPrefHeight(100);
		addAdLabel.setPrefWidth(300);
		addAdLabel.setFont(new Font(FONT, 36));
		addAdLabel.setTextFill(Color.WHITE);
		addAdLabel.setWrapText(true);
		addAdLabel.setOnMouseReleased(event -> guiController.setAddAdScene((Stage) pane.getScene().getWindow()));
		addAdLabel.setOnMouseEntered(event -> addAdLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED ));
		addAdLabel.setOnMouseExited(event -> addAdLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL));
		addAdLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(addAdLabel);
		
		myAdsLabel.setAlignment(Pos.CENTER);
		myAdsLabel.setContentDisplay(ContentDisplay.CENTER);
		myAdsLabel.setLayoutY(300);
		myAdsLabel.setPrefHeight(100);
		myAdsLabel.setPrefWidth(300);
		myAdsLabel.setFont(new Font(FONT, 36));
		myAdsLabel.setTextFill(Color.WHITE);
		myAdsLabel.setWrapText(true);
		myAdsLabel.setOnMouseReleased(event -> guiController.setMyAdsScene((Stage) pane.getScene().getWindow()));
		myAdsLabel.setOnMouseEntered(event -> myAdsLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED ));
		myAdsLabel.setOnMouseExited(event -> myAdsLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL));
		myAdsLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(myAdsLabel);
		
		favouriteListLabel.setAlignment(Pos.CENTER);
		favouriteListLabel.setContentDisplay(ContentDisplay.CENTER);
		favouriteListLabel.setLayoutY(500);
		favouriteListLabel.setPrefHeight(100);
		favouriteListLabel.setPrefWidth(300);
		favouriteListLabel.setFont(new Font(FONT, 36));
		favouriteListLabel.setTextFill(Color.WHITE);
		favouriteListLabel.setWrapText(true);
		favouriteListLabel.setOnMouseReleased(event -> guiController.setFavouriteListScene((Stage) pane.getScene().getWindow()));
		favouriteListLabel.setOnMouseEntered(event -> favouriteListLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED ));
		favouriteListLabel.setOnMouseExited(event -> favouriteListLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL));
		favouriteListLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(favouriteListLabel);
		
		myReviewLabel.setAlignment(Pos.CENTER);
		myReviewLabel.setContentDisplay(ContentDisplay.CENTER);
		myReviewLabel.setLayoutY(400);
		myReviewLabel.setPrefHeight(100);
		myReviewLabel.setPrefWidth(300);
		myReviewLabel.setFont(new Font(FONT, 36));
		myReviewLabel.setTextFill(Color.WHITE);
		myReviewLabel.setWrapText(true);
		myReviewLabel.setOnMouseReleased(event -> guiController.setMyReviewScene((Stage) pane.getScene().getWindow()));
		myReviewLabel.setOnMouseEntered(event -> myReviewLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED ));
		myReviewLabel.setOnMouseExited(event -> myReviewLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL));
		myReviewLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(myReviewLabel);
		///////////////////////////////////////////////

		centralPane = new AnchorPane();
		
		centralPaneContainer = new ScrollPane();
		centralPaneContainer.setPrefSize(600, 600);
		centralPaneContainer.setLayoutX(300);
		centralPaneContainer.setLayoutY(150);
		centralPaneContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		centralPaneContainer.setContent(centralPane);
		pane.getChildren().add(centralPaneContainer);
		
		//////////////////RIGHT PANE//////////////////
		Pane rightPane = new Pane();
		rightPane.setLayoutY(168);
		rightPane.setLayoutX(900);
		rightPane.setPrefHeight(600);
		rightPane.setPrefWidth(300);
		rightPane.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL);
		pane.getChildren().add(rightPane);

		usernameLabel1.setAlignment(Pos.TOP_LEFT);
		usernameLabel1.setLayoutY(0);
		usernameLabel1.setPrefHeight(60);
		usernameLabel1.setPrefWidth(300);
		usernameLabel1.setFont(new Font(FONT, 30));
		usernameLabel1.setTextFill(Color.WHITE);
		usernameLabel1.setWrapText(true);
		usernameLabel1.setPadding(new Insets(0,0,0,10));
		rightPane.getChildren().add(usernameLabel1);

		messageLabel1.setAlignment(Pos.TOP_LEFT);
		messageLabel1.setLayoutY(60);
		messageLabel1.setPrefHeight(140);
		messageLabel1.setPrefWidth(300);
		messageLabel1.setFont(new Font(FONT, 22));
		messageLabel1.setTextFill(Color.WHITE);
		messageLabel1.setWrapText(true);
		messageLabel1.setPadding(new Insets(0,0,0,10));
		rightPane.getChildren().add(messageLabel1);

		Label label1 = new Label("");
		label1.setStyle("-fx-background-color: #f7e178");
		label1.setPrefHeight(10);
		label1.setPrefWidth(300);
		label1.setLayoutY(165);
		rightPane.getChildren().add(label1);

		usernameLabel2.setAlignment(Pos.TOP_LEFT);
		usernameLabel2.setLayoutY(200);
		usernameLabel2.setPrefHeight(60);
		usernameLabel2.setPrefWidth(300);
		usernameLabel2.setFont(new Font(FONT, 30));
		usernameLabel2.setTextFill(Color.WHITE);
		usernameLabel2.setWrapText(true);
		usernameLabel2.setPadding(new Insets(0,0,0,10));
		rightPane.getChildren().add(usernameLabel2);

		messageLabel2.setAlignment(Pos.TOP_LEFT);
		messageLabel2.setLayoutY(260);
		messageLabel2.setPrefHeight(140);
		messageLabel2.setPrefWidth(300);
		messageLabel2.setFont(new Font(FONT, 22));
		messageLabel2.setTextFill(Color.WHITE);
		messageLabel2.setWrapText(true);
		messageLabel2.setPadding(new Insets(0,0,0,10));
		rightPane.getChildren().add(messageLabel2);

		Label label2 = new Label("");
		label2.setStyle("-fx-background-color: #f7e178");
		label2.setPrefHeight(10);
		label2.setPrefWidth(300);
		label2.setLayoutY(365);
		rightPane.getChildren().add(label2);

		usernameLabel3.setAlignment(Pos.TOP_LEFT);
		usernameLabel3.setLayoutY(400);
		usernameLabel3.setPrefHeight(60);
		usernameLabel3.setPrefWidth(300);
		usernameLabel3.setFont(new Font(FONT, 30));
		usernameLabel3.setTextFill(Color.WHITE);
		usernameLabel3.setWrapText(true);
		usernameLabel3.setPadding(new Insets(0,0,0,10));
		rightPane.getChildren().add(usernameLabel3);

		messageLabel3.setAlignment(Pos.TOP_LEFT);
		messageLabel3.setLayoutY(460);
		messageLabel3.setPrefHeight(140);
		messageLabel3.setPrefWidth(300);
		messageLabel3.setFont(new Font(FONT, 22));
		messageLabel3.setTextFill(Color.WHITE);
		messageLabel3.setWrapText(true);
		messageLabel3.setPadding(new Insets(0,0,0,10));
		rightPane.getChildren().add(messageLabel3);
		///////////////////////////////////////////////
	}

	public void setCentralPaneBackground(boolean backgroundOn) {
		if (backgroundOn) {
			try {
				FileInputStream input = new FileInputStream("img/torvergata.PNG");
				Image image = new Image(input);
				BackgroundImage myBI = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
						BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
				centralPane.setBackground(new Background(myBI));
			} catch (FileNotFoundException e) {
				new ErrorPopup(e.getMessage(), (Stage) centralPaneContainer.getScene().getWindow());
			}
		} else {
			centralPane.setBackground(null);
			centralPane.setOpacity(1);
		}
	}

	public void setCentralPaneFullSize(boolean fullSizeMode) {
		if (fullSizeMode) {
			this.centralPane.setPrefHeight(590);
			this.centralPane.setPrefWidth(585);
		} else {
			this.centralPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
			this.centralPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
		}

	}
}
