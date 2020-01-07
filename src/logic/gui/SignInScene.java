package logic.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.controller.GuiController;

public class SignInScene{
	
	private static final String font = "Arial";
	private static final String fontBold = "Arial Bold";
	private Scene myScene;
	private GuiController guiManager;
	
	public SignInScene() {
		
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
        
		try {
			FileInputStream input2 = new FileInputStream("Img/quad.png");
			Image image2 = new Image(input2);
	        ImageView imageView2 = new ImageView(image2);
	        imageView2.setLayoutX(900);
	        imageView2.setLayoutY(200);
	        imageView2.setFitHeight(600);
	        imageView2.setFitWidth(500);
	        pane.getChildren().add(imageView2);
	        
	        ImageView imageView3 = new ImageView(image2);
	        imageView3.setLayoutX(200);
	        imageView3.setLayoutY(200);
	        imageView3.setFitHeight(600);
	        imageView3.setFitWidth(500);
	        pane.getChildren().add(imageView3);
		} catch (FileNotFoundException e) {
			System.err.println("Error while loading quad.png: " + e.getMessage());
		}
        
        //Primo riquadro
        Label label2 = new Label("Personal Info");
        label2.setFont(new Font(fontBold, 24));
        label2.setLayoutX(375);
        label2.setLayoutY(258);
        pane.getChildren().add(label2);
        
        Label label3 = new Label("Name");
        label3.setFont(new Font(font, 24));
        label3.setLayoutX(250);
        label3.setLayoutY(350);
        pane.getChildren().add(label3);
        
        TextField nameField = new TextField("name");
        nameField.setLayoutX(400);
        nameField.setLayoutY(350);
        nameField.setPrefWidth(252);
        pane.getChildren().add(nameField);
        
        Label label4 = new Label("Surname");
        label4.setFont(new Font(font, 24));
        label4.setLayoutX(250);
        label4.setLayoutY(450);
        pane.getChildren().add(label4);
        
        TextField surnameField = new TextField("surname");
        surnameField.setLayoutX(400);
        surnameField.setLayoutY(450);
        surnameField.setPrefWidth(252);
        pane.getChildren().add(surnameField);
        
        Label label5 = new Label("Birthdate");
        label5.setFont(new Font(font, 24));
        label5.setLayoutX(250);
        label5.setLayoutY(550);
        pane.getChildren().add(label5);
        
        TextField daybirthField = new TextField("dd");
        daybirthField.setLayoutX(400);
        daybirthField.setLayoutY(550);
        daybirthField.setPrefWidth(55);
        pane.getChildren().add(daybirthField);
        
        Label label6 = new Label("/");
        label6.setFont(new Font(font, 24));
        label6.setLayoutX(463);
        label6.setLayoutY(550);
        pane.getChildren().add(label6);
        
        TextField monthbirthField = new TextField("mm");
        monthbirthField.setLayoutX(480);
        monthbirthField.setLayoutY(550);
        monthbirthField.setPrefWidth(55);
        pane.getChildren().add(monthbirthField);
        
        Label label7 = new Label("/");
        label7.setFont(new Font(font, 24));
        label7.setLayoutX(545);
        label7.setLayoutY(550);
        pane.getChildren().add(label7);
        
        TextField yearbirthField = new TextField("yyyy");
        yearbirthField.setLayoutX(560);
        yearbirthField.setLayoutY(550);
        yearbirthField.setPrefWidth(92);
        pane.getChildren().add(yearbirthField);
        
        Label label8 = new Label("Phone num.");
        label8.setFont(new Font(font, 24));
        label8.setLayoutX(250);
        label8.setLayoutY(650);
        pane.getChildren().add(label8);
        
        TextField phoneField = new TextField("phone number");
        phoneField.setLayoutX(400);
        phoneField.setLayoutY(650);
        phoneField.setPrefWidth(252);
        pane.getChildren().add(phoneField);
        
        //secondo riquadro
        Label label9 = new Label("Account Info");
        label9.setFont(new Font(fontBold, 24));
        label9.setLayoutX(1075);
        label9.setLayoutY(258);
        pane.getChildren().add(label9);
        
        Label label10 = new Label("Username");
        label10.setFont(new Font(font, 24));
        label10.setLayoutX(950);
        label10.setLayoutY(350);
        pane.getChildren().add(label10);
        
        TextField usernameField = new TextField("username");
        usernameField.setLayoutX(1100);
        usernameField.setLayoutY(350);
        usernameField.setPrefWidth(252);
        pane.getChildren().add(usernameField);
        
        Label label12 = new Label("E-mail");
        label12.setFont(new Font(font, 24));
        label12.setLayoutX(950);
        label12.setLayoutY(450);
        pane.getChildren().add(label12);
        
        TextField emailField = new TextField("email");
        emailField.setLayoutX(1100);
        emailField.setLayoutY(450);
        emailField.setPrefWidth(252);
        pane.getChildren().add(emailField);
        
        Label label13 = new Label("Password");
        label13.setFont(new Font(font, 24));
        label13.setLayoutX(950);
        label13.setLayoutY(550);
        pane.getChildren().add(label13);
        
        PasswordField passwordField = new PasswordField();
        passwordField.setText("password");
        passwordField.setLayoutX(1100);
        passwordField.setLayoutY(550);
        passwordField.setPrefWidth(252);
        pane.getChildren().add(passwordField);
        
        Label label14 = new Label("Password");
        label14.setFont(new Font(font, 24));
        label14.setLayoutX(950);
        label14.setLayoutY(650);
        pane.getChildren().add(label14);
        
        PasswordField passwordFieldCheck = new PasswordField();
        passwordFieldCheck.setLayoutX(1100);
        passwordFieldCheck.setText("password");
        passwordFieldCheck.setLayoutY(650);
        passwordFieldCheck.setPrefWidth(252);
        pane.getChildren().add(passwordFieldCheck);
        
        Button signInButton = new Button("Sig-in");
        signInButton.setFont(new Font(font, 24));
        signInButton.setUnderline(true);
        signInButton.setLayoutX(750);
        signInButton.setLayoutY(800);
        pane.getChildren().add(signInButton);
        
        Button languageButton = new Button("ENG");
        languageButton.setFont(new Font(font, 24));
        languageButton.setUnderline(true);
        languageButton.setLayoutX(1450);
        languageButton.setLayoutY(50);
        pane.getChildren().add(languageButton);
        
		try {
			FileInputStream input3 = new FileInputStream("Img/freccia.png");
			Image image3 = new Image(input3);
	        ImageView imageView4 = new ImageView(image3);
	        imageView4.setLayoutX(55);
	        imageView4.setLayoutY(35);
	        imageView4.setFitHeight(50);
	        imageView4.setFitWidth(50);
	        imageView4.setOnMouseClicked((e) -> {
				//backtoLogin
	        });
	        pane.getChildren().add(imageView4);
		} catch (FileNotFoundException e) {
			System.err.println("Error while loading freccia.png: " + e.getMessage());
		}
        
        Label label15 = new Label("Back to Log-in");
        label15.setFont(new Font(fontBold, 16));
        label15.setUnderline(true);
        label15.setLayoutX(32);
        label15.setLayoutY(85);
        pane.getChildren().add(label15);
	}
	
	public Scene getScene() {
		return myScene;
	}
	
}
