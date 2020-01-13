package logic.controller;

import java.sql.SQLException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import logic.bean.SignInBean;
import logic.dao.UserDAO;
import logic.gui.MyPopup;

public class SignInController {
	
	public AnchorPane pane;
	
	public TextField nameField;
	public TextField surnameField;
	public TextField ddField;
	public TextField mmField;
	public TextField yyyyField;
	public TextField phoneNumberField;
	public TextField usernameField;
	public TextField emailField;
	public TextField passwordField;
	public TextField confirmPasswordField;
	
	public Label labelNameError;
	public Label labelSurnameError;
	public Label labelBirthdateError;
	public Label labelPhoneNumberError;
	public Label labelUserameError;
	public Label labelEmailError;
	public Label labelPasswordError1;
	public Label labelPasswordError2;
	
	public Button btnLanguage;
	public Button btnSignIn;
	
	public void changeLanguage() { //apply observer GoF
		if(btnLanguage.getText().equals("ITA"))
			btnLanguage.setText("ENG");
		else
			btnLanguage.setText("ITA");
	}
	
	public void signIn() {
		//if user inputs are correct, proceed with the sign-in
		try {
			if(new SignInBean().checkInfo(nameField.getText(), surnameField.getText(),ddField.getText(), mmField.getText(), yyyyField.getText(), phoneNumberField.getText(), usernameField.getText(), emailField.getText(), passwordField.getText(), confirmPasswordField.getText()))
				new UserDAO().registerUser(nameField.getText(), surnameField.getText(), ddField.getText(), mmField.getText(), yyyyField.getText(), phoneNumberField.getText(), usernameField.getText(), emailField.getText(), passwordField.getText());
			else 
				notifyInputError();
		} catch (SQLException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
			notifyInputError();
		} catch (ClassNotFoundException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}

	private void notifyInputError() {
		labelNameError.setTextFill(Color.RED);
		labelSurnameError.setTextFill(Color.RED);
		labelBirthdateError.setTextFill(Color.RED);
		labelPhoneNumberError.setTextFill(Color.RED);
		labelUserameError.setTextFill(Color.RED);
		labelEmailError.setTextFill(Color.RED);
		labelPasswordError1.setTextFill(Color.RED);
		labelPasswordError2.setTextFill(Color.RED);
	}

}
