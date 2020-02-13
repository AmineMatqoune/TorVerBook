package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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

	protected static final int LEFT_PANE_WIDTH = 300;
	protected static final int RIGHT_PANE_WIDTH = 300;
	protected final int centralPaneWidth;
	protected final int mainPanesAreaHeight;
	protected final int leftPaneButtonHeight;
	
	
	protected static final String BG_COLOR_SIDE_BUTTON_NORMAL_STYLE = "-fx-background-color: #024a00";
	protected static final String BG_COLOR_SIDE_BUTTON_HOVERED_STYLE = "-fx-background-color: #feca57";

	protected static final String FONT = "Arial";

	public DashBoardScene() {
		super();
		Pane pane = (Pane) scene.getRoot();
		centralPaneWidth = sceneWidth - (LEFT_PANE_WIDTH + RIGHT_PANE_WIDTH);
		mainPanesAreaHeight = sceneHeight - TOP_BAR_OFFSET;
		leftPaneButtonHeight = mainPanesAreaHeight / 6;
		
		Pane leftPane = new Pane();
		leftPane.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE);		
		leftPane.setLayoutY(TOP_BAR_OFFSET);
		leftPane.setPrefHeight(mainPanesAreaHeight);
		leftPane.setPrefWidth(LEFT_PANE_WIDTH);
		pane.getChildren().add(leftPane);
		
		homepageLabel.setAlignment(Pos.CENTER);
		homepageLabel.setContentDisplay(ContentDisplay.CENTER);
		homepageLabel.setPrefHeight(leftPaneButtonHeight);
		homepageLabel.setPrefWidth(300);
		homepageLabel.setFont(new Font(FONT, 36));
		homepageLabel.setTextFill(Color.WHITE);
		homepageLabel.setWrapText(true);
		homepageLabel.setOnMouseReleased(event -> guiController.setHomepageScene((Stage) pane.getScene().getWindow()));
		homepageLabel.setOnMouseEntered(
				event -> homepageLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED_STYLE));
		homepageLabel.setOnMouseExited(
				event -> homepageLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE));
		homepageLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(homepageLabel);

		settingsLabel.setAlignment(Pos.CENTER);
		settingsLabel.setContentDisplay(ContentDisplay.CENTER);
		settingsLabel.setLayoutY(calcLeftPaneButtonTopOffset(1));
		settingsLabel.setPrefHeight(leftPaneButtonHeight);
		settingsLabel.setPrefWidth(300);
		settingsLabel.setFont(new Font(FONT, 36));
		settingsLabel.setTextFill(Color.WHITE);
		settingsLabel.setWrapText(true);
		settingsLabel.setOnMouseReleased(event -> guiController.setSettingsScene((Stage) pane.getScene().getWindow()));
		settingsLabel.setOnMouseEntered(
				event -> settingsLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED_STYLE));
		settingsLabel.setOnMouseExited(
				event -> settingsLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE));
		settingsLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(settingsLabel);

		addAdLabel.setAlignment(Pos.CENTER);
		addAdLabel.setContentDisplay(ContentDisplay.CENTER);
		addAdLabel.setLayoutY(calcLeftPaneButtonTopOffset(2));
		addAdLabel.setPrefHeight(leftPaneButtonHeight);
		addAdLabel.setPrefWidth(300);
		addAdLabel.setFont(new Font(FONT, 36));
		addAdLabel.setTextFill(Color.WHITE);
		addAdLabel.setWrapText(true);
		addAdLabel.setOnMouseReleased(event -> guiController.setAddAdScene((Stage) pane.getScene().getWindow()));
		addAdLabel.setOnMouseEntered(
				event -> addAdLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED_STYLE));
		addAdLabel
				.setOnMouseExited(event -> addAdLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE));
		addAdLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(addAdLabel);

		myAdsLabel.setAlignment(Pos.CENTER);
		myAdsLabel.setContentDisplay(ContentDisplay.CENTER);
		myAdsLabel.setLayoutY(calcLeftPaneButtonTopOffset(3));
		myAdsLabel.setPrefHeight(leftPaneButtonHeight);
		myAdsLabel.setPrefWidth(300);
		myAdsLabel.setFont(new Font(FONT, 36));
		myAdsLabel.setTextFill(Color.WHITE);
		myAdsLabel.setWrapText(true);
		myAdsLabel.setOnMouseReleased(event -> guiController.setMyAdsScene((Stage) pane.getScene().getWindow()));
		myAdsLabel.setOnMouseEntered(
				event -> myAdsLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED_STYLE));
		myAdsLabel
				.setOnMouseExited(event -> myAdsLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE));
		myAdsLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(myAdsLabel);
		
		myReviewLabel.setAlignment(Pos.CENTER);
		myReviewLabel.setContentDisplay(ContentDisplay.CENTER);
		myReviewLabel.setLayoutY(calcLeftPaneButtonTopOffset(4));
		myReviewLabel.setPrefHeight(leftPaneButtonHeight);
		myReviewLabel.setPrefWidth(300);
		myReviewLabel.setFont(new Font(FONT, 36));
		myReviewLabel.setTextFill(Color.WHITE);
		myReviewLabel.setWrapText(true);
		myReviewLabel.setOnMouseReleased(event -> guiController.setMyReviewScene((Stage) pane.getScene().getWindow()));
		myReviewLabel.setOnMouseEntered(
				event -> myReviewLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED_STYLE));
		myReviewLabel.setOnMouseExited(
				event -> myReviewLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE));
		myReviewLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(myReviewLabel);

		favouriteListLabel.setAlignment(Pos.CENTER);
		favouriteListLabel.setContentDisplay(ContentDisplay.CENTER);
		favouriteListLabel.setLayoutY(calcLeftPaneButtonTopOffset(5));
		favouriteListLabel.setPrefHeight(leftPaneButtonHeight);
		favouriteListLabel.setPrefWidth(300);
		favouriteListLabel.setFont(new Font(FONT, 36));
		favouriteListLabel.setTextFill(Color.WHITE);
		favouriteListLabel.setWrapText(true);
		favouriteListLabel
				.setOnMouseReleased(event -> guiController.setFavouriteListScene((Stage) pane.getScene().getWindow()));
		favouriteListLabel.setOnMouseEntered(
				event -> favouriteListLabel.setStyle(BG_COLOR_SIDE_BUTTON_HOVERED_STYLE));
		favouriteListLabel.setOnMouseExited(
				event -> favouriteListLabel.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE));
		favouriteListLabel.setCursor(Cursor.HAND);
		leftPane.getChildren().add(favouriteListLabel);


		centralPaneContainer = new ScrollPane();
		centralPaneContainer.setLayoutY(TOP_BAR_OFFSET);
		centralPaneContainer.setLayoutX(300);
		centralPaneContainer.setPrefHeight(mainPanesAreaHeight);
		centralPaneContainer.setPrefWidth(centralPaneWidth);
		centralPaneContainer.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		centralPaneContainer.setHbarPolicy(ScrollBarPolicy.NEVER);
		pane.getChildren().add(centralPaneContainer);

		centralPane = new AnchorPane();
		centralPaneContainer.setContent(centralPane);

		Pane rightPane = new Pane();
		rightPane.setLayoutY(TOP_BAR_OFFSET);
		rightPane.setLayoutX(900);
		rightPane.setPrefHeight(mainPanesAreaHeight);
		rightPane.setPrefWidth(RIGHT_PANE_WIDTH);
		rightPane.setStyle(BG_COLOR_SIDE_BUTTON_NORMAL_STYLE);
		pane.getChildren().add(rightPane);

		usernameLabel1.setAlignment(Pos.TOP_LEFT);
		usernameLabel1.setLayoutY(0);
		usernameLabel1.setPrefHeight(60);
		usernameLabel1.setPrefWidth(300);
		usernameLabel1.setFont(new Font(FONT, 30));
		usernameLabel1.setTextFill(Color.WHITE);
		usernameLabel1.setWrapText(true);
		usernameLabel1.setPadding(new Insets(0, 0, 0, 10));
		rightPane.getChildren().add(usernameLabel1);

		messageLabel1.setAlignment(Pos.TOP_LEFT);
		messageLabel1.setLayoutY(60);
		messageLabel1.setPrefHeight(140);
		messageLabel1.setPrefWidth(300);
		messageLabel1.setFont(new Font(FONT, 22));
		messageLabel1.setTextFill(Color.WHITE);
		messageLabel1.setWrapText(true);
		messageLabel1.setPadding(new Insets(0, 0, 0, 10));
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
		usernameLabel2.setPadding(new Insets(0, 0, 0, 10));
		rightPane.getChildren().add(usernameLabel2);

		messageLabel2.setAlignment(Pos.TOP_LEFT);
		messageLabel2.setLayoutY(260);
		messageLabel2.setPrefHeight(140);
		messageLabel2.setPrefWidth(300);
		messageLabel2.setFont(new Font(FONT, 22));
		messageLabel2.setTextFill(Color.WHITE);
		messageLabel2.setWrapText(true);
		messageLabel2.setPadding(new Insets(0, 0, 0, 10));
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
		usernameLabel3.setPadding(new Insets(0, 0, 0, 10));
		rightPane.getChildren().add(usernameLabel3);

		messageLabel3.setAlignment(Pos.TOP_LEFT);
		messageLabel3.setLayoutY(460);
		messageLabel3.setPrefHeight(140);
		messageLabel3.setPrefWidth(300);
		messageLabel3.setFont(new Font(FONT, 22));
		messageLabel3.setTextFill(Color.WHITE);
		messageLabel3.setWrapText(true);
		messageLabel3.setPadding(new Insets(0, 0, 0, 10));
		rightPane.getChildren().add(messageLabel3);
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
			int calculatedCentralPaneHeight = sceneHeight - TOP_BAR_OFFSET - 10;
			this.centralPane.setPrefHeight(calculatedCentralPaneHeight);
			this.centralPane.setPrefWidth(600);
		} else {
			this.centralPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
			this.centralPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
		}

	}
	
	private int calcLeftPaneButtonTopOffset(int buttonIndex) {
		return leftPaneButtonHeight * buttonIndex;
	}
}
