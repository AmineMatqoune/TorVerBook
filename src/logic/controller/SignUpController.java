package logic.controller;


import java.sql.SQLException;

import javafx.stage.Stage;

import logic.account.User;
import logic.bean.SignUpBean;
import logic.dao.UserDAO;
import logic.gui.GUIController;
import logic.gui.MyPopup;
import logic.gui.SignUpScene;

public class SignUpController {
	
	private SignUpBean signUpBean;
	private SignUpScene signUpScene;
	private GUIController gui;
	private User user;
	
	public boolean signUp() {
		signUpBean = new SignUpBean();
		
		//check if user's inputs are correct, if so, proceed with the sign-up
		try {
			if(signUpBean.getPassword().equals(signUpBean.getConfirmPassword())) {
				
				//if password fields are same, proceed creating a temporary user object and check information consistency
				user = new User(signUpBean.getName(), signUpBean.getSurname(), signUpBean.getUsername(), signUpBean.getEmail(), signUpBean.getPassword());
				user.setPhoneNumber(signUpBean.getPhoneNumber());

				if(signUpBean.checkInfo(user)) {
					//if date doesn't throwed any ParseException, it means that user inserted a valid date, so we can finally sign-up the new user
					user.setBirthDate(signUpBean.getYear() + "-" + signUpBean.getMonth() + "-" + signUpBean.getDay());
					new UserDAO().registerUser(user);
					
					//return to log-in page
					loadLogIn();
				}
				else //if user's inputs are wrong, signUp will not proceed
					return false;
			}
			else //passwords don't match
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			signUpScene = SignUpScene.getInstance();
			new MyPopup(e.getMessage(), (Stage) signUpScene.getScene().getWindow());
			return false;
		} 
		return true;
	}

	private void loadLogIn() {
		signUpScene = SignUpScene.getInstance();
		gui = GUIController.getInstance();
		gui.setLogInScene((Stage) signUpScene.getScene().getWindow());
	}
}
