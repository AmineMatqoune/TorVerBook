package logic.gui;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class DashBoardScene extends BaseScene{

	protected Pane centralPane;
	
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
	
	protected final static String FONT = "Arial";
	
	public DashBoardScene() {
		super();
		Pane pane = (Pane) scene.getRoot();
		
		Pane leftPane = new Pane();
		leftPane.setLayoutY(151);
		leftPane.setPrefHeight(600);
		leftPane.setPrefWidth(300);
		leftPane.setStyle("-fx-background-color: #024a00");
		pane.getChildren().add(leftPane);
		
		homepageLabel.setAlignment(Pos.CENTER);
		homepageLabel.setContentDisplay(ContentDisplay.CENTER);
		homepageLabel.setPrefHeight(100);
		homepageLabel.setPrefWidth(300);
		homepageLabel.setFont(new Font(FONT, 36));
		homepageLabel.setTextFill(Color.YELLOW);
		homepageLabel.setWrapText(true);
		leftPane.getChildren().add(homepageLabel);
		
		settingsLabel.setAlignment(Pos.CENTER);
		settingsLabel.setContentDisplay(ContentDisplay.CENTER);
		settingsLabel.setLayoutY(100);
		settingsLabel.setPrefHeight(100);
		settingsLabel.setPrefWidth(300);
		settingsLabel.setFont(new Font(FONT, 36));
		settingsLabel.setTextFill(Color.WHITE);
		settingsLabel.setWrapText(true);
		leftPane.getChildren().add(settingsLabel);
		
		addAdLabel.setAlignment(Pos.CENTER);
		addAdLabel.setContentDisplay(ContentDisplay.CENTER);
		addAdLabel.setLayoutY(200);
		addAdLabel.setPrefHeight(100);
		addAdLabel.setPrefWidth(300);
		addAdLabel.setFont(new Font(FONT, 36));
		addAdLabel.setTextFill(Color.WHITE);
		addAdLabel.setWrapText(true);
		leftPane.getChildren().add(addAdLabel);
		
		myAdsLabel.setAlignment(Pos.CENTER);
		myAdsLabel.setContentDisplay(ContentDisplay.CENTER);
		myAdsLabel.setLayoutY(300);
		myAdsLabel.setPrefHeight(100);
		myAdsLabel.setPrefWidth(300);
		myAdsLabel.setFont(new Font(FONT, 36));
		myAdsLabel.setTextFill(Color.WHITE);
		myAdsLabel.setWrapText(true);
		leftPane.getChildren().add(myAdsLabel);
		
		favouriteListLabel.setAlignment(Pos.CENTER);
		favouriteListLabel.setContentDisplay(ContentDisplay.CENTER);
		favouriteListLabel.setLayoutY(400);
		favouriteListLabel.setPrefHeight(100);
		favouriteListLabel.setPrefWidth(300);
		favouriteListLabel.setFont(new Font(FONT, 36));
		favouriteListLabel.setTextFill(Color.WHITE);
		favouriteListLabel.setWrapText(true);
		leftPane.getChildren().add(favouriteListLabel);		
		
		myReviewLabel.setAlignment(Pos.CENTER);
		myReviewLabel.setContentDisplay(ContentDisplay.CENTER);
		myReviewLabel.setLayoutY(500);
		myReviewLabel.setPrefHeight(100);
		myReviewLabel.setPrefWidth(300);
		myReviewLabel.setFont(new Font(FONT, 36));
		myReviewLabel.setTextFill(Color.WHITE);
		myReviewLabel.setWrapText(true);
		leftPane.getChildren().add(myReviewLabel);
		
		centralPane = new Pane();
		centralPane.setLayoutY(150);
		centralPane.setLayoutX(300);
		centralPane.setPrefHeight(600);
		centralPane.setPrefWidth(600);
		pane.getChildren().add(centralPane);
		
		Pane rightPane = new Pane();
		rightPane.setLayoutY(168);
		rightPane.setLayoutX(900);
		rightPane.setPrefHeight(600);
		rightPane.setPrefWidth(300);
		rightPane.setStyle("-fx-background-color: #024a00");
		pane.getChildren().add(rightPane);
		
		usernameLabel1.setAlignment(Pos.TOP_LEFT);
		usernameLabel1.setLayoutY(0);
		usernameLabel1.setPrefHeight(60);
		usernameLabel1.setPrefWidth(300);
		usernameLabel1.setFont(new Font(FONT, 30));
		usernameLabel1.setTextFill(Color.WHITE);
		usernameLabel1.setWrapText(true);
		rightPane.getChildren().add(usernameLabel1);
		
		messageLabel1.setAlignment(Pos.TOP_LEFT);
		messageLabel1.setLayoutY(60);
		messageLabel1.setPrefHeight(140);
		messageLabel1.setPrefWidth(300);
		messageLabel1.setFont(new Font(FONT, 22));
		messageLabel1.setTextFill(Color.WHITE);
		messageLabel1.setWrapText(true);
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
		rightPane.getChildren().add(usernameLabel2);
		
		messageLabel2.setAlignment(Pos.TOP_LEFT);
		messageLabel2.setLayoutY(260);
		messageLabel2.setPrefHeight(140);
		messageLabel2.setPrefWidth(300);
		messageLabel2.setFont(new Font(FONT, 22));
		messageLabel2.setTextFill(Color.WHITE);
		messageLabel2.setWrapText(true);
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
		rightPane.getChildren().add(usernameLabel3);
		
		messageLabel3.setAlignment(Pos.TOP_LEFT);
		messageLabel3.setLayoutY(460);
		messageLabel3.setPrefHeight(140);
		messageLabel3.setPrefWidth(300);
		messageLabel3.setFont(new Font(FONT, 22));
		messageLabel3.setTextFill(Color.WHITE);
		messageLabel3.setWrapText(true);
		rightPane.getChildren().add(messageLabel3);
	}	
}
