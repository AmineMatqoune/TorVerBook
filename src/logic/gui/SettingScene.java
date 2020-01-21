package logic.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import logic.bean.SettingsBean;
import logic.controller.SettingController;

//classe create per le impostazioni del profilo dell'utente
public class SettingScene extends DashBoardScene{
	
	//SINGLETON come le altri classe per la gui
	private static SettingScene instance = new SettingScene();
	
	//oggetto per ottenere dati dal DB e per aggiornarli
	private SettingsBean settingsBean = new SettingsBean();
	private SettingController settingController = new SettingController();	
	
	private static final String TEXT_FONT = "Arial";
	
	private TextField nameField;
	private TextField surnameField;
	private TextField dayField; 
	private TextField monthField;
	private TextField yearField;
	private TextField phoneNumberField;
	private TextField emailField;
	private TextField usernameField;
	private PasswordField passwordField;
	private PasswordField confirmPasswordField;
	
	private SettingScene() {
		super();
		
		homepageLabel.setTextFill(Color.WHITE);
		settingsLabel.setTextFill(Color.YELLOW);
		
		Label usernameLabel = new Label("USERNAME: " + settingsBean.getUserUsername());
		usernameLabel.setFont(new Font(TEXT_FONT, 33));
		usernameLabel.setLayoutX(25);
		usernameLabel.setLayoutY(17);
		usernameLabel.setPrefHeight(40);
        centralPane.getChildren().add(usernameLabel);
        
        Label label1 = new Label("Name");
        label1.setFont(new Font(TEXT_FONT, 20));
        label1.setLayoutX(25);
        label1.setLayoutY(80);
        centralPane.getChildren().add(label1);
        
        nameField = new TextField(settingsBean.getUserName());
        nameField.setPrefHeight(25);
		nameField.setPrefWidth(300);
		nameField.setLayoutX(250);
		nameField.setLayoutY(80);
		centralPane.getChildren().add(nameField);
        
        Label label2 = new Label("Surname");
        label2.setFont(new Font(TEXT_FONT, 20));
        label2.setLayoutX(25);
        label2.setLayoutY(125);
        centralPane.getChildren().add(label2);
        
        surnameField = new TextField(settingsBean.getUserSurname());
        surnameField.setPrefHeight(25);
		surnameField.setPrefWidth(300);
		surnameField.setLayoutX(250);
		surnameField.setLayoutY(125);
		centralPane.getChildren().add(surnameField);
        
        Label label3 = new Label("Birthdate");
        label3.setFont(new Font(TEXT_FONT, 20));
        label3.setLayoutX(25);
        label3.setLayoutY(170);
        centralPane.getChildren().add(label3);
        
        dayField = new TextField(settingsBean.getUserBirthdate().substring(8, 10));
        dayField.setPrefHeight(25);
        dayField.setPrefWidth(75);
        dayField.setLayoutX(250);
        dayField.setLayoutY(170);
		centralPane.getChildren().add(dayField);
		
		Label label9 = new Label("/");
        label9.setFont(new Font(TEXT_FONT, 20));
        label9.setLayoutX(335);
        label9.setLayoutY(170);
        centralPane.getChildren().add(label9);
		
		monthField = new TextField(settingsBean.getUserBirthdate().substring(5, 7));
		monthField.setPrefHeight(25);
		monthField.setPrefWidth(75);
		monthField.setLayoutX(350);
		monthField.setLayoutY(170);
		centralPane.getChildren().add(monthField);
		
		Label label10 = new Label("/");
        label10.setFont(new Font(TEXT_FONT, 20));
        label10.setLayoutX(435);
        label10.setLayoutY(170);
        centralPane.getChildren().add(label10);
		
		yearField = new TextField(settingsBean.getUserBirthdate().substring(0, 4));
		yearField.setPrefHeight(25);
		yearField.setPrefWidth(100);
		yearField.setLayoutX(450);
		yearField.setLayoutY(170);
		centralPane.getChildren().add(yearField);
        
        Label label4 = new Label("Phone number");
        label4.setFont(new Font(TEXT_FONT, 20));
        label4.setLayoutX(25);
        label4.setLayoutY(215);
        centralPane.getChildren().add(label4);
        
        phoneNumberField = new TextField(settingsBean.getUserPhoneNumber());
        phoneNumberField.setPrefHeight(25);
		phoneNumberField.setPrefWidth(300);
		phoneNumberField.setLayoutX(250);
		phoneNumberField.setLayoutY(215);
		centralPane.getChildren().add(phoneNumberField);
	
        Label label5 = new Label("Username");
        label5.setFont(new Font(TEXT_FONT, 20));
        label5.setLayoutX(25);
        label5.setLayoutY(260);
        centralPane.getChildren().add(label5);
        
        usernameField = new TextField(settingsBean.getUserUsername());
        usernameField.setPrefHeight(25);
        usernameField.setPrefWidth(300);
        usernameField.setLayoutX(250);
        usernameField.setLayoutY(260);
		centralPane.getChildren().add(usernameField);
        
        Label label6 = new Label("E-mail");
        label6.setFont(new Font(TEXT_FONT, 20));
        label6.setLayoutX(25);
        label6.setLayoutY(305);
        centralPane.getChildren().add(label6);
        
        emailField = new TextField(settingsBean.getUserEmail());
        emailField.setPrefHeight(25);
        emailField.setPrefWidth(300);
        emailField.setLayoutX(250);
        emailField.setLayoutY(305);
		centralPane.getChildren().add(emailField);
        
        Label label7 = new Label("Password");
        label7.setFont(new Font(TEXT_FONT, 20));
        label7.setLayoutX(25);
        label7.setLayoutY(350);
        centralPane.getChildren().add(label7);
        
        passwordField = new PasswordField();
        passwordField.setText(settingsBean.getUserPassword());
        passwordField.setPrefHeight(25);
        passwordField.setPrefWidth(300);
        passwordField.setLayoutX(250);
        passwordField.setLayoutY(350);
		centralPane.getChildren().add(passwordField);
        
        Label label8 = new Label("Confirm password");
        label8.setFont(new Font(TEXT_FONT, 20));
        label8.setLayoutX(25);
        label8.setLayoutY(395);
        centralPane.getChildren().add(label8);
        
        confirmPasswordField = new PasswordField();
        confirmPasswordField.setText(settingsBean.getUserPassword());
        confirmPasswordField.setPrefHeight(25);
        confirmPasswordField.setPrefWidth(300);
        confirmPasswordField.setLayoutX(250);
        confirmPasswordField.setLayoutY(395);
		centralPane.getChildren().add(confirmPasswordField);
		
		Button saveChangesButton = new Button("SAVE");
		saveChangesButton.setFont(new Font(TEXT_FONT, 30));
		saveChangesButton.setLayoutX(225);
		saveChangesButton.setLayoutY(480);
		saveChangesButton.setOnMouseClicked(event -> 
			saveChanges()
	    );
		centralPane.getChildren().add(saveChangesButton);
	}
	
	//metodo per salvare i cambiamenti fatti sulle info dello user
	private void saveChanges() {
		if(!settingController.applyChanges()) {
			notifyInputError();
		} else {
			//metti tipo che ricarica la homepage o qualche messaggio di info
			System.out.println("Salvataggio riuscito");
		}
	}
	
	private void notifyInputError() {
		new MyPopup("Errore nel salvatggio dei dati!", (Stage) SettingScene.getInstance().getScene().getWindow());
	}

	//metodi per passare le stringhe dalle textfield alla Bean
	public String getName() {
		return nameField.getText();
	}
	
	public String getSurname() {
		return surnameField.getText();
	}
	
	public String getBirthdate() {
		return yearField.getText().concat("-" + monthField.getText().concat("-" + dayField.getText()));
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
	
	public String getPassword() {
		return passwordField.getText();
	}
	/////////////////////////////////////////////////
	
	public static SettingScene getInstance() {
		/*if(instance == null) 
			instance = new SettingScene();*/
		//System.out.println("FLAG");
		return instance;
	}	

}
