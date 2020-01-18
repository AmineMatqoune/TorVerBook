package logic.controller;

import java.sql.SQLException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.MyPopup;

public class LogInController {
	
	private UserDAO userDao = new UserDAO();
	private User user;
	
	public boolean checkLogin(String username, String password) {
		try {
			//if log-in is successful, create user object and load homepage
			System.out.println("flag2");
			if(userDao.logIn(username, password)) {
				user = userDao.getUserObject();
				System.out.println("Benvenuto: " + user.getEmail() + " " + user.getBirthDateString());
				//loadHomePage
				return true;
			}
			//exception management
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("LoginController.checkLogin(ERROR)");
			//new MyPopup(e.getMessage(), (Stage)pane.getScene().getWindow());
		}
		//Notify log-in error
		return false; 
	}
}
