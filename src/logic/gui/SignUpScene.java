package logic.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.controller.SignUpController;

public class SignUpScene extends BaseScene{

	private static SignUpScene instance = null; // riferimento all' istanza
	private Scene scene;
	
	private TextField nameField;
	private TextField surnameField;
	private TextField ddField;
	private TextField mmField;
	private TextField yyyyField;
	private TextField phoneNumberField;
	private TextField usernameField;
	private TextField emailField;
	private PasswordField passwordField;
	private PasswordField confirmPasswordField;
	
	private static final String TEXT_FONT = "Arial";
	
	private GUIController guiController = GUIController.getInstance();
	private SignUpController signupController = new SignUpController();

	private SignUpScene() {
		super();
		scene = super.getScene();
		Pane pane = (Pane) scene.getRoot();
		
		Label label1 = new Label("Personal Info");
        label1.setFont(new Font(TEXT_FONT, 24));
        label1.setLayoutX(220);
        label1.setLayoutY(200);
		pane.getChildren().add(label1);
		
		Label label2 = new Label("Name");
		label2.setFont(new Font(TEXT_FONT, 24));
		label2.setLayoutX(100);
		label2.setLayoutY(250);
		pane.getChildren().add(label2);
		
		nameField = new TextField();
		nameField.setPrefHeight(25);
		nameField.setPrefWidth(200);
		nameField.setLayoutX(300);
		nameField.setLayoutY(250);
		nameField.setPromptText("Name");
		pane.getChildren().add(nameField);
		
		Label label3 = new Label("Surname");
		label3.setFont(new Font(TEXT_FONT, 24));
		label3.setLayoutX(100);
		label3.setLayoutY(350);
		pane.getChildren().add(label3);
		
		surnameField = new TextField();
		surnameField.setPrefHeight(25);
		surnameField.setPrefWidth(200);
		surnameField.setLayoutX(300);
		surnameField.setLayoutY(350);
		surnameField.setPromptText("Surname");
		pane.getChildren().add(surnameField);
		
		Label label4 = new Label("Birthdate");
		label4.setFont(new Font(TEXT_FONT, 24));
		label4.setLayoutX(100);
		label4.setLayoutY(450);
		pane.getChildren().add(label4);
		
		ddField = new TextField();
		ddField.setPrefHeight(25);
		ddField.setPrefWidth(45);
		ddField.setLayoutX(300);
		ddField.setLayoutY(450);
		ddField.setPromptText("dd");
		pane.getChildren().add(ddField);
		
		Label label11 = new Label("/");
		label11.setFont(new Font(TEXT_FONT, 24));
		label11.setLayoutX(347);
		label11.setLayoutY(450);
		pane.getChildren().add(label11);
		
		mmField = new TextField();
		mmField.setPrefHeight(25);
		mmField.setPrefWidth(45);
		mmField.setLayoutX(355);
		mmField.setLayoutY(450);
		mmField.setPromptText("mm");
		pane.getChildren().add(mmField);
		
		Label label12 = new Label("/");
		label12.setFont(new Font(TEXT_FONT, 24));
		label12.setLayoutX(402);
		label12.setLayoutY(450);
		pane.getChildren().add(label12);
		
		yyyyField = new TextField();
		yyyyField.setPrefHeight(25);
		yyyyField.setPrefWidth(90);
		yyyyField.setLayoutX(410);
		yyyyField.setLayoutY(450);
		yyyyField.setPromptText("yyyy");
		pane.getChildren().add(yyyyField);
		
		Label label5 = new Label("Phone num.");
		label5.setFont(new Font(TEXT_FONT, 24));
		label5.setLayoutX(100);
		label5.setLayoutY(550);
		pane.getChildren().add(label5);
		
		phoneNumberField = new TextField();
		phoneNumberField.setPrefHeight(25);
		phoneNumberField.setPrefWidth(200);
		phoneNumberField.setLayoutX(300);
		phoneNumberField.setLayoutY(550);
		phoneNumberField.setPromptText("Phone number");
		pane.getChildren().add(phoneNumberField);
		
		Label label6 = new Label("Account Info");
		label6.setFont(new Font(TEXT_FONT, 24));
		label6.setLayoutX(820);
        label6.setLayoutY(200);
		pane.getChildren().add(label6);
		
		Label label7 = new Label("Username");
		label7.setFont(new Font(TEXT_FONT, 24));
		label7.setLayoutX(700);
		label7.setLayoutY(250);
		pane.getChildren().add(label7);
		
		usernameField = new TextField();
		usernameField.setPrefHeight(25);
		usernameField.setPrefWidth(200);
		usernameField.setLayoutX(900);
		usernameField.setLayoutY(250);
		usernameField.setPromptText("Username");
		pane.getChildren().add(usernameField);
		
		Label label8 = new Label("E-mail");
		label8.setFont(new Font(TEXT_FONT, 24));
		label8.setLayoutX(700);
		label8.setLayoutY(350);
		pane.getChildren().add(label8);
		
		emailField = new TextField();
		emailField.setPrefHeight(25);
		emailField.setPrefWidth(200);
		emailField.setLayoutX(900);
		emailField.setLayoutY(350);
		emailField.setPromptText("E-mail");
		pane.getChildren().add(emailField);
		
		Label label9 = new Label("Password");
		label9.setFont(new Font(TEXT_FONT, 24));
		label9.setLayoutX(700);
		label9.setLayoutY(450);
		pane.getChildren().add(label9);
		
		passwordField = new PasswordField();
		passwordField.setPrefHeight(25);
		passwordField.setPrefWidth(200);
		passwordField.setLayoutX(900);
		passwordField.setLayoutY(450);
		passwordField.setPromptText("Password");
		pane.getChildren().add(passwordField);
		
		Label label10 = new Label("Confirm password");
		label10.setFont(new Font(TEXT_FONT, 24));
		label10.setLayoutX(700);
		label10.setLayoutY(550);
		pane.getChildren().add(label10);
		
		confirmPasswordField = new PasswordField();
		confirmPasswordField.setPrefHeight(25);
		confirmPasswordField.setPrefWidth(200);
		confirmPasswordField.setLayoutX(900);
		confirmPasswordField.setLayoutY(550);
		confirmPasswordField.setPromptText("Confirm password");
		pane.getChildren().add(confirmPasswordField);
		
		Button signUpButton = new Button("Sign-up");
		signUpButton.setFont(new Font(TEXT_FONT, 24));
		signUpButton.setLayoutX(550);
		signUpButton.setLayoutY(620);
		signUpButton.setOnMouseClicked(event -> 
				signupController.signUp()
		);
		pane.getChildren().add(signUpButton);
		
		Label label13 = new Label("Back to Log-in");
		label13.setFont(new Font(TEXT_FONT, 24));
		label13.setTextFill(Color.WHITE);
		label13.setUnderline(true);
		label13.setLayoutX(20);
		label13.setLayoutY(110);
		label13.setOnMouseClicked(event -> 
			guiController.setLogInScene((Stage)scene.getWindow())
		);
		pane.getChildren().add(label13);
	}
	
	public String getName() {
		return nameField.getText();
	}
	
	public String getSurname() {
		return surnameField.getText();
	}
	
	public String getDay() {
		return ddField.getText();
	}
	
	public String getMonth() {
		return mmField.getText();
	}
	
	public String getYear() {
		return yyyyField.getText();
	}
	
	public String getPhoneNumber() {
		return phoneNumberField.getText();
	}
	
	public String getUsername() {
		System.out.println("dimmi");
		return usernameField.getText();
	}
	
	public String getEmail() {
		return emailField.getText();
	}
	
	public String getPwd() {
		System.out.println("il contenuto è: " + passwordField.getText());
		return passwordField.getText();
	}
	
	public String getConfirmPwd() {
		System.out.println("il contenuto di confirm è: " + confirmPasswordField.getText());
		return confirmPasswordField.getText();
	}
	
	public static SignUpScene getInstance() {
		System.out.print("instance vale: " + instance == null);
		if(instance == null)
			instance = new SignUpScene();
		System.out.println("sto per ritornare instance che vale: " + instance == null);
	    return instance;
	}
}