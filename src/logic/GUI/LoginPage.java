package logic.GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LoginPage extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("TorVerBook");
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 1600, 900);
		
        FileInputStream input = new FileInputStream("src/Images/logo.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setOpacity(0.045);
        pane.getChildren().add(imageView);
        
        Label label1 = new Label("TorVerBook");
        label1.setMinHeight(150);
        label1.setMinWidth(1600);
        label1.setStyle("-fx-background-color: #024a00");
        ///temporanei: da sostituire con logo
        label1.setTextFill(Color.WHITE);
        label1.setAlignment(Pos.CENTER);
        label1.setFont(new Font("Arial", 24));
        /////////////
        pane.getChildren().add(label1);
        
        FileInputStream input2 = new FileInputStream("src/Images/quad.png");
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
        
        Label label2 = new Label("Email/Username");
        label2.setFont(new Font("Arial", 24));
        label2.setLayoutX(1200);
        label2.setLayoutY(258);
        pane.getChildren().add(label2);
        
        TextField emailField = new TextField("email/username");
        emailField.setLayoutX(1142);
        emailField.setLayoutY(318);
        emailField.setPrefWidth(300);
        pane.getChildren().add(emailField);
        
        Label label3 = new Label("Password");
        label3.setFont(new Font("Arial", 24));
        label3.setLayoutX(1235);
        label3.setLayoutY(378);
        pane.getChildren().add(label3);
        
        TextField passwordField = new TextField("password");
        passwordField.setLayoutX(1142);
        passwordField.setLayoutY(438);
        passwordField.setPrefWidth(300);
        pane.getChildren().add(passwordField);
        
        Button loginButton = new Button("Log-in");
        loginButton.setFont(new Font("Arial", 24));
        loginButton.setLayoutX(1240);
        loginButton.setLayoutY(498);
        pane.getChildren().add(loginButton);
        
        Label label4 = new Label("Don't have an account yet?");
        label4.setFont(new Font("Arial", 15));
        label4.setLayoutX(1200);
        label4.setLayoutY(570);
        pane.getChildren().add(label4);
        
        Button siginButton = new Button("Sig-in");
        siginButton.setFont(new Font("Arial", 24));
        siginButton.setLayoutX(1245);
        siginButton.setLayoutY(618);
        siginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					SiginPage in = new SiginPage(stage);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
        });
        pane.getChildren().add(siginButton);
        
        String desc = "Torverbook � una piattaforma ideata da studenti \n\ndell'universit� di tor vergata al fine di consentire lo scambio,\n\n "
        		+ "l'acquisto e la vendita di libri universitari. Il sistema offre la \n\npossibilit� di cercare, anche tramite dei filtri, "
        		+ "il libro di cui si ha \n\nbisogno e di contattare il proprietario per concludere lo \n\nscambio o l'acquisto.";
        Label label5 = new Label(desc);
        label5.setFont(new Font("Arial Bold", 24));
        label5.setLayoutX(150);
        label5.setLayoutY(300);
        pane.getChildren().add(label5);
        
        Button languageButton = new Button("ENG");
        languageButton.setFont(new Font("Arial", 24));
        languageButton.setLayoutX(1450);
        languageButton.setLayoutY(50);
        pane.getChildren().add(languageButton);
        
        stage.setScene(scene);
        
        stage.setResizable(false);
        stage.show();
	}
}
