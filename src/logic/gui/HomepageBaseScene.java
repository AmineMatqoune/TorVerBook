package logic.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HomepageBaseScene extends BaseScene{

	private Scene scene;
	private static HomepageBaseScene instance = null;
	
	public HomepageBaseScene() {
		super();
		scene = super.getScene();
		Pane pane = (Pane) scene.getRoot();
		
		Pane leftPane = new Pane();
		leftPane.setLayoutY(150);
		leftPane.setPrefHeight(600);
		leftPane.setPrefWidth(300);
		leftPane.setStyle("-fx-background-color: #024a00");
		pane.getChildren().add(leftPane);
		
		Label homepageLabel = new Label("Homepage");
		homepageLabel.setAlignment(Pos.CENTER);
		homepageLabel.setContentDisplay(ContentDisplay.CENTER);
		homepageLabel.setPrefHeight(100);
		homepageLabel.setPrefWidth(300);
		homepageLabel.setTextFill(Color.WHITE);
		homepageLabel.setWrapText(true);
		leftPane.getChildren().add(homepageLabel);
		
		Label settingsLabel = new Label("Settings");
		settingsLabel.setAlignment(Pos.CENTER);
		settingsLabel.setContentDisplay(ContentDisplay.CENTER);
		settingsLabel.setLayoutY(100);
		settingsLabel.setPrefHeight(100);
		settingsLabel.setPrefWidth(300);
		settingsLabel.setTextFill(Color.WHITE);
		settingsLabel.setWrapText(true);
		leftPane.getChildren().add(settingsLabel);
		
		Label addAdLabel = new Label("Add Ad");
		addAdLabel.setAlignment(Pos.CENTER);
		addAdLabel.setContentDisplay(ContentDisplay.CENTER);
		addAdLabel.setLayoutY(200);
		addAdLabel.setPrefHeight(100);
		addAdLabel.setPrefWidth(300);
		addAdLabel.setTextFill(Color.WHITE);
		addAdLabel.setWrapText(true);
		leftPane.getChildren().add(addAdLabel);
		
		Label myAdsLabel = new Label("My Ads");
		myAdsLabel.setAlignment(Pos.CENTER);
		myAdsLabel.setContentDisplay(ContentDisplay.CENTER);
		myAdsLabel.setLayoutY(300);
		myAdsLabel.setPrefHeight(100);
		myAdsLabel.setPrefWidth(300);
		myAdsLabel.setTextFill(Color.WHITE);
		myAdsLabel.setWrapText(true);
		leftPane.getChildren().add(myAdsLabel);
		
		Label favouriteListLabel = new Label("Favourite List");
		favouriteListLabel.setAlignment(Pos.CENTER);
		favouriteListLabel.setContentDisplay(ContentDisplay.CENTER);
		favouriteListLabel.setLayoutY(400);
		favouriteListLabel.setPrefHeight(100);
		favouriteListLabel.setPrefWidth(300);
		favouriteListLabel.setTextFill(Color.WHITE);
		favouriteListLabel.setWrapText(true);
		leftPane.getChildren().add(favouriteListLabel);		
		
		Label myReviewLabel = new Label("My Review");
		myReviewLabel.setAlignment(Pos.CENTER);
		myReviewLabel.setContentDisplay(ContentDisplay.CENTER);
		myReviewLabel.setLayoutY(500);
		myReviewLabel.setPrefHeight(100);
		myReviewLabel.setPrefWidth(300);
		myReviewLabel.setTextFill(Color.WHITE);
		myReviewLabel.setWrapText(true);
		leftPane.getChildren().add(myReviewLabel);
		
		Pane centralPane = new Pane();
		centralPane.setLayoutY(150);
		centralPane.setLayoutX(300);
		centralPane.setPrefHeight(600);
		centralPane.setPrefWidth(600);
		pane.getChildren().add(centralPane);
		
		Pane rightPane = new Pane();
		rightPane.setLayoutY(150);
		rightPane.setLayoutX(900);
		rightPane.setPrefHeight(600);
		rightPane.setPrefWidth(300);
		rightPane.setStyle("-fx-background-color: #024a00");
		pane.getChildren().add(rightPane);
		
		Label usernameLabel1 = new Label("Username 1");
		usernameLabel1.setAlignment(Pos.TOP_LEFT);
		usernameLabel1.setLayoutY(0);
		usernameLabel1.setPrefHeight(60);
		usernameLabel1.setPrefWidth(300);
		usernameLabel1.setTextFill(Color.WHITE);
		usernameLabel1.setWrapText(true);
		rightPane.getChildren().add(usernameLabel1);
		
		Label messageLabel1 = new Label("Last message 1");
		messageLabel1.setAlignment(Pos.TOP_LEFT);
		messageLabel1.setLayoutY(60);
		messageLabel1.setPrefHeight(140);
		messageLabel1.setPrefWidth(300);
		messageLabel1.setTextFill(Color.WHITE);
		messageLabel1.setWrapText(true);
		rightPane.getChildren().add(messageLabel1);
		
		Label usernameLabel2 = new Label("Username 2");
		usernameLabel2.setAlignment(Pos.TOP_LEFT);
		usernameLabel2.setLayoutY(200);
		usernameLabel2.setPrefHeight(60);
		usernameLabel2.setPrefWidth(300);
		usernameLabel2.setTextFill(Color.WHITE);
		usernameLabel2.setWrapText(true);
		rightPane.getChildren().add(usernameLabel2);
		
		Label messageLabel2 = new Label("Last message 2");
		messageLabel2.setAlignment(Pos.TOP_LEFT);
		messageLabel2.setLayoutY(260);
		messageLabel2.setPrefHeight(140);
		messageLabel2.setPrefWidth(300);
		messageLabel2.setTextFill(Color.WHITE);
		messageLabel2.setWrapText(true);
		rightPane.getChildren().add(messageLabel2);
		
		Label usernameLabel3 = new Label("Username 3");
		usernameLabel3.setAlignment(Pos.TOP_LEFT);
		usernameLabel3.setLayoutY(200);
		usernameLabel3.setPrefHeight(60);
		usernameLabel3.setPrefWidth(300);
		usernameLabel3.setTextFill(Color.WHITE);
		usernameLabel3.setWrapText(true);
		rightPane.getChildren().add(usernameLabel3);
		
		Label messageLabel3 = new Label("Last message 3");
		messageLabel3.setAlignment(Pos.TOP_LEFT);
		messageLabel3.setLayoutY(260);
		messageLabel3.setPrefHeight(140);
		messageLabel3.setPrefWidth(300);
		messageLabel3.setTextFill(Color.WHITE);
		messageLabel3.setWrapText(true);
		rightPane.getChildren().add(messageLabel3);
	}
	
	public static HomepageBaseScene getInstance() {
		if(instance == null) 
			instance = new HomepageBaseScene();
		return instance;
	}
}
