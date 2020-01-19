package logic.controller;

import java.sql.SQLException;

import javafx.stage.Stage;
import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.GUIController;
import logic.gui.LogInScene;
import logic.gui.MyPopup;

public class LogInController {
	
	private GUIController guiController = GUIController.getInstance();
	private UserDAO userDao = new UserDAO();
	private User user;
	
	public boolean checkLogin(String username, String password) {
		try {
			//if log-in is successful, create user object and load homepage
			if(userDao.logIn(username, password)) {
				user = userDao.getUserObject();
				System.out.println("Benvenuto: " + user.getEmail() + " " + user.getBirthDateString());
				//loadHomePage
				return true;
			}
			//exception management
		} catch (ClassNotFoundException | SQLException e) {
			new MyPopup(e.getMessage(), (Stage) LogInScene.getInstance().getScene().getWindow());
		}
		//Notify log-in error
		return false; 
	}
	
	public void loadSignUp() {
		guiController.setSignUpScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}
}
