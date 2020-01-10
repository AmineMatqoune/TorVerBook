package logic.controller;

import java.io.IOException;
import java.sql.SQLException;

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
import logic.dao.UserDAO;

public class LogInController {
	
	public Scene myScene;
	public Button btnLanguage;
	public Button login;
	public Button signin;
	
	public Label errorUsername;
	public Label errorPwd;
	
	public TextField usernameField;
	public PasswordField passwordField;
	
	public void changeLanguage() { //apply observer GoF
		if(btnLanguage.getText().equals("ITA"))
			btnLanguage.setText("ENG");
		else
			btnLanguage.setText("ITA");
	}
	
	public void checkLogin() {
		try {
			if(new UserDAO().verifyCredentials(usernameField.getText(), passwordField.getText()))
				System.out.println("Sei loggato come: " + usernameField.getText() + " - " + passwordField.getText());
			else {
				errorUsername.setText("Wrong username");
				errorPwd.setText("Wrong Password");
			}
		} catch (SQLException e) {
			System.err.println("Error while interacting with DB");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void loadSignIn(ActionEvent event) throws IOException{		
		Parent signInParent = FXMLLoader.load(getClass().getResource("/logic/gui/SignIn.fxml"));
		Scene signInScene = new Scene(signInParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(signInScene);
	}

}
