package logic.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {
	
	public Button btnLanguage;
	public Button login;
	public Button signin;
	
	public Label errorUsername;
	public Label errorPwd;
	
	public TextField username;
	public PasswordField password;
	
	public void changeLanguage() { //apply observer GoF
		if(btnLanguage.getText().equals("ITA"))
			btnLanguage.setText("ENG");
		else
			btnLanguage.setText("ITA");
	}
	
	public void checkLogin() {
		System.out.println("Hai provato ad accedere con credenziali: " + username.getText() + " - " + password.getText());
		errorUsername.setText("Wrong username");
		errorPwd.setText("Wrong Password");
	}
	
	public void signIn(ActionEvent event) throws IOException{
		System.out.println("Vuoi fare la registrazione");
		
		Parent signInParent = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
		Scene signInScene = new Scene(signInParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(signInScene);
	
	}

}
