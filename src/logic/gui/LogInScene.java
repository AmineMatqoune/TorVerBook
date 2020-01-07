package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LogInScene {
	
	private Scene myScene;
	private static final String font = "Arial";
	
	public LogInScene() {		
		Pane pane = new Pane();
		myScene = new Scene(pane, 1600, 900);

		try {
			FileInputStream input = new FileInputStream("Img/logo.png");
			Image image = new Image(input);
	        ImageView imageView = new ImageView(image);
	        imageView.setOpacity(0.045);
	        pane.getChildren().add(imageView);
	    } catch (FileNotFoundException e) {
			System.err.println("Error while loading logo.png: " + e.getMessage());
		}
		
		try {
			FileInputStream input2 = new FileInputStream("Img/quad.png");
			Image image2 = new Image(input2);
	        ImageView imageView2 = new ImageView(image2);
	        imageView2.setLayoutX(1092);
	        imageView2.setLayoutY(218);
	        imageView2.setFitHeight(500);
	        imageView2.setFitWidth(400);
	        pane.getChildren().add(imageView2);
			
			ImageView imageView3 = new ImageView(image2);
	        imageView3.setLayoutX(86);
	        imageView3.setLayoutY(218);
	        imageView3.setFitHeight(500);
	        imageView3.setFitWidth(820);
	        pane.getChildren().add(imageView3);
		} catch (FileNotFoundException e) {
			System.err.println("Error while loading quad.png: " + e.getMessage());
		}        
        
        Label label1 = new Label("TorVerBook");
        label1.setMinHeight(150);
        label1.setMinWidth(1600);
        label1.setStyle("-fx-background-color: #024a00");
        ///temporanei: da sostituire con logo
        label1.setTextFill(Color.WHITE);
        label1.setAlignment(Pos.CENTER);
        label1.setFont(new Font(font, 24));
        /////////////
        pane.getChildren().add(label1);
        
        Label label2 = new Label("Email/Username");
        label2.setFont(new Font(font, 24));
        label2.setLayoutX(1200);
        label2.setLayoutY(258);
        pane.getChildren().add(label2);
        
        TextField emailField = new TextField("email/username");
        emailField.setLayoutX(1142);
        emailField.setLayoutY(318);
        emailField.setPrefWidth(300);
        pane.getChildren().add(emailField);
        
        Label label3 = new Label("Password");
        label3.setFont(new Font(font, 24));
        label3.setLayoutX(1235);
        label3.setLayoutY(378);
        pane.getChildren().add(label3);
        
        TextField passwordField = new TextField("password");
        passwordField.setLayoutX(1142);
        passwordField.setLayoutY(438);
        passwordField.setPrefWidth(300);
        pane.getChildren().add(passwordField);
        
        Button loginButton = new Button("Log-in");
        loginButton.setFont(new Font(font, 24));
        loginButton.setLayoutX(1240);
        loginButton.setLayoutY(498);
        pane.getChildren().add(loginButton);
        
        Label label4 = new Label("Don't have an account yet?");
        label4.setFont(new Font(font, 15));
        label4.setLayoutX(1200);
        label4.setLayoutY(570);
        pane.getChildren().add(label4);
        
        Button signInButton = new Button("Sign-in");
        signInButton.setFont(new Font(font, 24));
        signInButton.setLayoutX(1245);
        signInButton.setLayoutY(618);
        signInButton.setOnMouseClicked(event->{
			guiManager.loadSignIn();
		});
        pane.getChildren().add(signInButton);
        
        String desc = "Torverbook è una piattaforma ideata da studenti \n\ndell'università di tor vergata al fine di consentire lo scambio,\n\n "
        		+ "l'acquisto e la vendita di libri universitari. Il sistema offre la \n\npossibilità di cercare, anche tramite dei filtri, "
        		+ "il libro di cui si ha \n\nbisogno e di contattare il proprietario per concludere lo \n\nscambio o l'acquisto.";
        Label label5 = new Label(desc);
        label5.setFont(new Font(font + " Bold", 24));
        label5.setLayoutX(150);
        label5.setLayoutY(300);
        pane.getChildren().add(label5);
        
        Button languageButton = new Button("ENG");
        languageButton.setFont(new Font(font, 24));
        languageButton.setLayoutX(1450);
        languageButton.setLayoutY(50);
        pane.getChildren().add(languageButton);
	}
	
	public Scene getScene() {
		return myScene;
	}
}
