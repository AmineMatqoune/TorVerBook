package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javafx.stage.Stage;
import logic.account.AccountType;
import logic.dao.AccountDAO;
import logic.gui.LogInScene;
import logic.gui.popup.ErrorPopup;
import logic.gui.popup.InfoPopup;

public class LogInController {
	
	private GUIController guiController = GUIController.getInstance();
	private AccountDAO accountDao = AccountDAO.getInstance();
	
	public boolean checkLogin(String username, String password) {
		try {
			//if log-in is successful, create user object and load homepage
			if(accountDao.logIn(username, password)) {
				if(accountDao.getAccountType() == AccountType.USER) {
					loadUserHomepage();
					return true;
				}
				else if(accountDao.getAccountType() == AccountType.RULE_CHECKER) {
					loadRCHomepage();
					return true;
				}				
			} else {
				new InfoPopup("Account bannato!",  (Stage) LogInScene.getInstance().getScene().getWindow());
			}
		} catch (SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) LogInScene.getInstance().getScene().getWindow());
		}
		//Notify log-in error
		return false; 
	}
	
	public void loadSignUp() {
		guiController.setSignUpScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}
	
	//metodo per caricare l'homepage per l'user
	public void loadUserHomepage() {
		guiController.setHomepageScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}
	
	//metodo per caricare l'homepage per il rulechecker
	public void loadRCHomepage() {
		guiController.setRCSettingsScene((Stage) LogInScene.getInstance().getScene().getWindow());
	}
}
