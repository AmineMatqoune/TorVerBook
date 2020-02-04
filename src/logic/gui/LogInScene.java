package logic.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.controller.LogInController;

public class LogInScene extends BaseScene{

	private static LogInScene instance = null;
	
	private TextField usernameField;
	private PasswordField passwordField;
	private Label errorUsername;
	private Label errorPassword;
	
	private static final String TEXT_FONT = "Arial";
	
	private LogInController loginController = new LogInController();
	
	private LogInScene() {
		super();
		Pane pane = (Pane) scene.getRoot();
		
		Label label1 = new Label("Username");
        label1.setFont(new Font(TEXT_FONT, 24));
        label1.setLayoutX(835);
        label1.setLayoutY(250);
        pane.getChildren().add(label1);
		
        usernameField = new TextField();
        usernameField.setLayoutX(835);
        usernameField.setLayoutY(305);
        usernameField.setPrefHeight(25);
        usernameField.setPrefWidth(280);    
        usernameField.setPromptText("Username");
        usernameField.setOnAction(event -> 
			attemptLogin()
        );
        pane.getChildren().add(usernameField);
        
        Label label2 = new Label("Password");
        label2.setFont(new Font(TEXT_FONT, 24));
        label2.setLayoutX(835);
        label2.setLayoutY(350);
        pane.getChildren().add(label2);
        
        passwordField = new PasswordField();
        passwordField.setLayoutX(835);
        passwordField.setLayoutY(405);
        passwordField.setPrefHeight(25);
        passwordField.setPrefWidth(280);    
        passwordField.setPromptText("Password");
        passwordField.setOnAction(event -> 
    		attemptLogin()
        );
        pane.getChildren().add(passwordField);
        
        Button logInButton = new Button("Log-in");
        logInButton.setFont(new Font(TEXT_FONT, 24));
        logInButton.setLayoutX(930);
        logInButton.setLayoutY(450);
        logInButton.setOnAction(event -> 
        	attemptLogin()
        );
        pane.getChildren().add(logInButton);
        
        Label label3 = new Label("Don't have an account yet?");
        label3.setFont(new Font(TEXT_FONT, 15));
        label3.setLayoutX(890);
        label3.setLayoutY(513);
        pane.getChildren().add(label3);
        
        Button signUpButton = new Button("Sign-up");
        signUpButton.setFont(new Font(TEXT_FONT, 24));
        signUpButton.setLayoutX(922);
        signUpButton.setLayoutY(549);
        signUpButton.setOnAction(event -> 
        	loadSignUp()
        );
        pane.getChildren().add(signUpButton);
        
        errorUsername = new Label();
        errorUsername.setFont(new Font(TEXT_FONT, 15));
        errorUsername.setLayoutX(845);
        errorUsername.setLayoutY(330);
        errorUsername.setPrefHeight(17);
        errorUsername.setPrefWidth(275);
        errorUsername.setTextFill(Color.RED);
        pane.getChildren().add(errorUsername);
        
        errorPassword = new Label();
        errorPassword.setFont(new Font(TEXT_FONT, 15));
        errorPassword.setLayoutX(845);
        errorPassword.setLayoutY(430);
        errorPassword.setPrefHeight(17);
        errorPassword.setPrefWidth(275);
        errorPassword.setTextFill(Color.RED);
        pane.getChildren().add(errorPassword);
    }
	
	private void attemptLogin() {
		if(usernameField.getText().equals("") || passwordField.getText().equals(""))
			notifyInputError();
		else if(!loginController.checkLogin(usernameField.getText(), passwordField.getText()))
			notifyInputError();
	}
	
	private void loadSignUp() {
		loginController.loadSignUp();
	}
	
	private void notifyInputError() {
		errorUsername.setTextFill(Color.RED);
		errorPassword.setTextFill(Color.RED);
		errorUsername.setText("Invalid username");
		errorPassword.setText("Invalid password");
	}
	
	public static LogInScene getInstance() {
		if(instance == null) 
			instance = new LogInScene();
		return instance;
	}
}