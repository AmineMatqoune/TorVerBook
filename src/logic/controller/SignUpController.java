package logic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.account.User;
import logic.bean.SignUpBean;
import logic.dao.UserDAO;
import logic.gui.MyPopup;

public class SignUpController {
	
	private SignUpBean signUpBean;
	
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
	
	public void signUp() {
		signUpBean.printC();
		signUpBean = new SignUpBean();
		signUpBean.printC();
		System.out.println(signUpBean.getPassword());
		System.out.println(signUpBean.getConfirmPassword());
		System.out.println(signUpBean.getUsername());
		/*if user inputs are correct, proceed with the sign-up
		try {
			
			/*if(!signUpBean.getPassword().equals(signUpBean.getConfirmPassword())) {
				notifyInputError();
				return;
			}
			
			//if password fields are same, proceed creating a temporary user object and check information consistency
			SignUpBean signUpBean = new SignUpBean();
			User user = new User(signUpBean.getName(), signUpBean.getSurname(), signUpBean.getUsername(), signUpBean.getEmail(), signUpBean.getPassword());
			
			if(signUpBean.checkInfo(user)) {
				
				//user inputs are correct, check if birthDate is a valid date				
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				dateFormat.setLenient(false);
				Date date = dateFormat.parse(signUpBean.getMonth() + "-" + signUpBean.getDay() + "-" + signUpBean.getYear());
				user.setBirthDate(date);
				user.setPhoneNumber(signUpBean.getPhoneNumber());

				//if date doesn't throwed any ParseException, it means that user inserted a valid date, so we can finally sign-up the new user
				new UserDAO().registerUser(user);
				
				//return to log-in page
				loadLogIn();
			}
			else 
				notifyInputError();
		} catch (SQLException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
			notifyInputError();
		} catch (ClassNotFoundException | ParseException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}*/
	}

	private void loadLogIn() {
		try {
			Parent logInParent = FXMLLoader.load(getClass().getResource("/logic/gui/LogIn.fxml"));
			Scene logInScene = new Scene(logInParent);
			Stage window = (Stage)pane.getScene().getWindow();
			window.setScene(logInScene);
		} catch (IOException e) {
			new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
	}

	private void notifyInputError() {
		/*
		labelNameError.setTextFill(Color.RED);
		labelSurnameError.setTextFill(Color.RED);
		labelBirthdateError.setTextFill(Color.RED);
		labelPhoneNumberError.setTextFill(Color.RED);
		labelUserameError.setTextFill(Color.RED);
		labelEmailError.setTextFill(Color.RED);
		labelPasswordError1.setTextFill(Color.RED);
		labelPasswordError2.setTextFill(Color.RED);*/
		System.err.println("ERRORE!");
	}
	
	
	

}
