package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javafx.stage.Stage;
import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.LogInScene;
import logic.gui.popup.ErrorPopup;

public class LogInController {
	
	private GUIController guiController = GUIController.getInstance();
	private UserDAO userDao = UserDAO.getInstance();
	
	public boolean checkLogin(String username, String password) {
		try {
			//if log-in is successful, create user object and load homepage
			if(userDao.logIn(username, password)) {
				User user = userDao.getUserObject();
				loadHomepage();
				return true;
			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) LogInScene.getInstance().getScene().getWindow());
		}
		//Notify log-in error
		return false; 
	}
	
	public void loadSignUp() {
		guiController.setSignUpScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}
	
	//metodo per caricare l'homepage
	public void loadHomepage() {
		guiController.setHomepageScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}
}
