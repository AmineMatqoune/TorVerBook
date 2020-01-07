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
	
	private static LogInController instance = null;
	
	public Scene myScene;
	public Button btnLanguage;
	public Button login;
	public Button signin;
	
	public Label errorUsername;
	public Label errorPwd;
	
	public TextField username;
	public PasswordField password;
	
	private LogInController() {
		
	}
	
	public void changeLanguage() { //apply observer GoF
		if(btnLanguage.getText().equals("ITA"))
			btnLanguage.setText("ENG");
		else
			btnLanguage.setText("ITA");
	}
	
	public void checkLogin() {
		errorUsername.setText("Wrong username");
		errorPwd.setText("Wrong Password");
	}
	
	public void signIn(ActionEvent event) throws IOException{		
		Parent signInParent = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
		Scene signInScene = new Scene(signInParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(signInScene);
	}
	
	public static LogInController getInstance() {
		if(instance == null)
			instance = new LogInController();
		return instance;
	}

}