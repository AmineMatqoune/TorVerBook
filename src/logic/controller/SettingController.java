package logic.controller;

import java.sql.SQLException;
import logic.account.User;
import logic.bean.SettingsBean;
import logic.dao.UserDAO;

public class SettingController {
	
	private UserDAO userDAO = UserDAO.getInstance();
	
	private SettingsBean settingsBean;
	
	public boolean applyChanges() {
		settingsBean = new SettingsBean();
		
		//controllo dei dati
		User userChecker = new User(settingsBean.getNewName(), settingsBean.getNewSurname(), settingsBean.getNewUsername(), settingsBean.getNewEmail(), settingsBean.getNewPassword());
		userChecker.setBirthDate(settingsBean.getNewBirthdate());
		userChecker.setPhoneNumber(settingsBean.getNewPhoneNumber());
		
		if(!settingsBean.checkInfo(userChecker))
			return false;
		
		//aggiorno istanza
		updateUserDAO(userDAO.getUserObject());

		//agiorno database
		try {
			userDAO.UpdateUserInfoDAO();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("Errore nell'aggiornamento delle info dell'utente nel db");
		}
		return true;
	}
	
	private void updateUserDAO(User user) {
		user.changeProfileSettings(settingsBean.getNewName(), settingsBean.getNewSurname(), settingsBean.getNewUsername(), settingsBean.getNewEmail(), settingsBean.getNewPassword());
		user.setBirthDate(settingsBean.getNewBirthdate());
		user.setPhoneNumber(settingsBean.getNewPhoneNumber());
	}
}
