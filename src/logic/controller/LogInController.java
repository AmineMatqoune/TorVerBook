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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.MyPopup;

public class LogInController {
	
	private UserDAO userDao = new UserDAO();
	private User user;
	
	public AnchorPane pane;
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
			//if log-in is successfull, create user object and load homepage
			if(userDao.logIn(usernameField.getText(), passwordField.getText())) {
				user = userDao.getUserObject();
				System.out.println("Benvenuto " + user.getName() + " - " + user.getSurname());
			}
			//Notify log-in error
			else {
				errorUsername.setText("Wrong username");
				errorPwd.setText("Wrong Password");
			}
			//exception maagement
		} catch (SQLException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		} catch (ClassNotFoundException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}
	
	public void loadSignIn(ActionEvent event) throws IOException{		
		Parent signInParent = FXMLLoader.load(getClass().getResource("/logic/gui/SignIn.fxml"));
		Scene signInScene = new Scene(signInParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(signInScene);
	}

}
