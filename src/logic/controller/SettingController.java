package logic.controller;

import java.sql.SQLException;

import javafx.stage.Stage;

import logic.account.User;
import logic.bean.SettingsBean;
import logic.dao.UserDAO;
import logic.gui.MyPopup;
import logic.gui.SettingScene;

public class SettingController {
	
	private UserDAO userDAO = UserDAO.getInstance();
	
	private SettingsBean settingsBean;
	
	public boolean applyChanges() {
		settingsBean = new SettingsBean();
		
		//controllo dei dati
		User tmpUser = new User(settingsBean.getNewName(), settingsBean.getNewSurname(), settingsBean.getNewUsername(), settingsBean.getNewEmail(), settingsBean.getNewPassword());
		tmpUser.setBirthDate(settingsBean.getNewBirthdate());
		tmpUser.setPhoneNumber(settingsBean.getNewPhoneNumber());
		
		if(!settingsBean.checkInfo(tmpUser))
			return false;
		
		//aggiorno database
		try {
			userDAO.updateUserInfoDAO(tmpUser);
		} catch (ClassNotFoundException | SQLException e) {
			new MyPopup(e.getMessage(), (Stage) SettingScene.getInstance().getScene().getWindow());
		}
		return true;
	}
	
	private void updateUserDAO(User user) {
		user.changeProfileSettings(settingsBean.getNewName(), settingsBean.getNewSurname(), settingsBean.getNewUsername(), settingsBean.getNewEmail(), settingsBean.getNewPassword());
		user.setBirthDate(settingsBean.getNewBirthdate());
		user.setPhoneNumber(settingsBean.getNewPhoneNumber());
	}
}