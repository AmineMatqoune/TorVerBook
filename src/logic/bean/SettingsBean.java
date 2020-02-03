package logic.bean;

import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.SettingScene;

public class SettingsBean {

	private User user;
	
	private UserDAO userDAO = UserDAO.getInstance();
	private SettingScene settingScene;

	public SettingsBean() {
		user = userDAO.getUserObject();
	}
	
	public void link() {
		settingScene = SettingScene.getInstance();
	}
	
	//METODI PER IMPOSTARE STRINGHE NELLE TEXTFIELD
	public String getUserName() {
		return user.getName();
	}

	public String getUserSurname() {
		return user.getSurname();
	}

	public String getUserBirthdate() {
		return user.getBirthDateString();
	}

	public String getUserPhoneNumber() {
		return user.getPhoneNumber();
	}
	
	public String getUserUsername() {
		return user.getUsername();
	}

	public String getUserEmail() {
		return user.getEmail();
	}

	public String getUserPassword() {
		return user.getPassword();
	}
	
	//METODI PER PRENDERE DA SETTINGSSCENE LE STRINGHE MODIFICATE
	public String getNewName() {
		return settingScene.getName();
	}

	public String getNewSurname() {
		return settingScene.getSurname();
	}

	public String getNewBirthdate() {
		return settingScene.getBirthdate();
	}

	public String getNewPhoneNumber() {
		return settingScene.getPhoneNumber();
	}
	
	public String getNewUsername() {
		return settingScene.getUsername();
	}

	public String getNewEmail() {
		return settingScene.getEmail();
	}

	public String getNewPassword() {
		return settingScene.getPassword();
	}
	///////////////////////////////////////
	
	public boolean checkInfo(User user) {
		
		boolean expression = false;
		
		if((user.getName().length() > 15) || user.getName().equals(""))
			return expression;
		if((user.getSurname().length() > 15) || user.getSurname().equals(""))
			return expression;
		if((user.getUsername().length() > 20) || user.getUsername().equals(""))
			return expression;
		if((user.getEmail().length() > 30) || user.getEmail().equals(""))
			return expression;
		if((user.getPassword().length() > 30) || user.getPassword().equals(""))
			return expression;
		
		//no syntax errors found, return true
		return !expression;
	}
}
