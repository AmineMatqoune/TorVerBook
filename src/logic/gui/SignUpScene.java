package logic.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.controller.GUIController;
import logic.controller.SignUpController;

public class SignUpScene extends BaseScene{

	private static SignUpScene instance = null; // riferimento all' istanza
	
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
	
	private Label labelNameError;
	private Label labelSurnameError;
	private Label labelBirthdateError;
	private Label labelPhoneNumberError;
	private Label labelUsernameError;
	private Label labelEmailError;
	private Label labelPasswordError1;
	private Label labelPasswordError2;
	
	private static final String TEXT_FONT = "Arial";
	
	private GUIController guiController = GUIController.getInstance();
	private SignUpController signupController = new SignUpController();

	private SignUpScene() {
		super();
		
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
		
		labelNameError = new Label("Name: max 15 char");
		labelNameError.setLayoutX(300);
		labelNameError.setLayoutY(270);
		labelNameError.setPrefHeight(25);
		labelNameError.setPrefWidth(200);
		pane.getChildren().add(labelNameError);
		
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
		
		labelSurnameError = new Label("Surname: max 15 char");
		labelSurnameError.setLayoutX(300);
		labelSurnameError.setLayoutY(370);
		labelSurnameError.setPrefHeight(43);
		labelSurnameError.setPrefWidth(200);
		pane.getChildren().add(labelSurnameError);
		
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
		
		labelBirthdateError = new Label("Valid date");
		labelBirthdateError.setLayoutX(300);
		labelBirthdateError.setLayoutY(470);
		labelBirthdateError.setPrefHeight(43);
		labelBirthdateError.setPrefWidth(200);
		pane.getChildren().add(labelBirthdateError);
		
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
		
		labelPhoneNumberError = new Label("10 digits");
		labelPhoneNumberError.setLayoutX(300);
		labelPhoneNumberError.setLayoutY(570);
		labelPhoneNumberError.setPrefHeight(43);
		labelPhoneNumberError.setPrefWidth(200);
		pane.getChildren().add(labelPhoneNumberError);
		
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
		
		labelUsernameError = new Label("Username: max 20 char");
		labelUsernameError.setLayoutX(900);
		labelUsernameError.setLayoutY(270);
		labelUsernameError.setPrefHeight(43);
		labelUsernameError.setPrefWidth(200);
		pane.getChildren().add(labelUsernameError);
		
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
		
		labelEmailError = new Label("Email: max 30 char");
		labelEmailError.setLayoutX(900);
		labelEmailError.setLayoutY(370);
		labelEmailError.setPrefHeight(43);
		labelEmailError.setPrefWidth(200);
		pane.getChildren().add(labelEmailError);
		
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
		
		labelPasswordError1 = new Label("Password: max 30 char");
		labelPasswordError1.setLayoutX(900);
		labelPasswordError1.setLayoutY(470);
		labelPasswordError1.setPrefHeight(43);
		labelPasswordError1.setPrefWidth(200);
		pane.getChildren().add(labelPasswordError1);
		
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
		
		labelPasswordError2 = new Label("Same password above");
		labelPasswordError2.setLayoutX(900);
		labelPasswordError2.setLayoutY(570);
		labelPasswordError2.setPrefHeight(43);
		labelPasswordError2.setPrefWidth(200);
		pane.getChildren().add(labelPasswordError2);
		
		Button signUpButton = new Button("Sign-up");
		signUpButton.setFont(new Font(TEXT_FONT, 24));
		signUpButton.setLayoutX(550);
		signUpButton.setLayoutY(620);
		signUpButton.setOnMouseClicked(event -> 
			attemptSignUp()
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
		return usernameField.getText();
	}
	
	public String getEmail() {
		return emailField.getText();
	}
	
	public String getPwd() {
		return passwordField.getText();
	}
	
	public String getConfirmPwd() {
		return confirmPasswordField.getText();
	}
	
	private void attemptSignUp() {
		if(!signupController.signUp())
			notifyInputError();
	}
	
	private void notifyInputError() {
		labelNameError.setTextFill(Color.RED);
		labelSurnameError.setTextFill(Color.RED);
		labelBirthdateError.setTextFill(Color.RED);
		labelPhoneNumberError.setTextFill(Color.RED);
		labelUsernameError.setTextFill(Color.RED);
		labelEmailError.setTextFill(Color.RED);
		labelPasswordError1.setTextFill(Color.RED);
		labelPasswordError2.setTextFill(Color.RED);
	}
	
	public static SignUpScene getInstance() {
		if(instance == null)
			instance = new SignUpScene();
	    return instance;
	}
}