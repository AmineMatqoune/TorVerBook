package logic.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javafx.stage.Stage;
import logic.account.User;
import logic.bean.SettingsBean;
import logic.dao.UserDAO;
import logic.gui.SettingScene;
import logic.gui.popup.ErrorPopup;

public class SettingController {
	
	private UserDAO userDAO = UserDAO.getInstance();
	
	private SettingsBean settingsBean;
	
	public boolean applyChanges() {
		settingsBean = SettingScene.getInstance().getSettingsBean();
		
		try {
			//controllo dei dati
			User tmpUser = new User(settingsBean.getUserName(), settingsBean.getUserSurname(), settingsBean.getUserUsername(), settingsBean.getUserEmail(), settingsBean.getUserPassword());
			tmpUser.setBirthDate(settingsBean.getUserBirthdate());
			tmpUser.setPhoneNumber(settingsBean.getUserPhoneNumber());
		
			if(!settingsBean.checkInfo(tmpUser))
				return false;
		
			//aggiorno database
			userDAO.updateUserInfoDAO(tmpUser);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			new ErrorPopup(e.getMessage(), (Stage) SettingScene.getInstance().getScene().getWindow());
		}
		return true;
	}
	
	private void updateUserDAO(User user) {
		user.changeProfileSettings(settingsBean.getUserName(), settingsBean.getUserSurname(), settingsBean.getUserUsername(), settingsBean.getUserEmail(), settingsBean.getUserPassword());
		user.setBirthDate(settingsBean.getUserBirthdate());
		user.setPhoneNumber(settingsBean.getUserPhoneNumber());
	}
}
