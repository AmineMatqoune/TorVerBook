package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javafx.stage.Stage;
import logic.dao.AccountDAO;
import logic.gui.LogInScene;
import logic.gui.popup.ErrorPopup;

public class LogInController {
	
	private GUIController guiController = GUIController.getInstance();
	private AccountDAO accountDao = AccountDAO.getInstance();
	
	public boolean checkLogin(String username, String password) {
		try {
			//if log-in is successful, create user object and load homepage
			if(accountDao.logIn(username, password)) {
//				User user = (User) userDao.getAccountObject();
				System.out.println("Logged IN!");
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
