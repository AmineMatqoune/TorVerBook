package logic.bean;

import java.text.SimpleDateFormat;
import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.SettingScene;

public class SettingsBean {

	private User user;
	
	private UserDAO userDAO = UserDAO.getInstance();
	private SettingScene settingScene = SettingScene.getInstance();

	//METODI PER IMPOSTARE STRINGHE NELLE TEXTFIELD
	public String getUserName() {
		user = userDAO.getUserObject();
		return user.getName();
	}

	public String getUserSurname() {
		user = userDAO.getUserObject();
		return user.getSurname();
	}

	public String getUserBirthdate() {
		user = userDAO.getUserObject();
		return user.getBirthDateString();
	}

	public String getUserPhoneNumber() {
		user = userDAO.getUserObject();
		return user.getPhoneNumber();
	}
	
	public String getUserUsername() {
		user = userDAO.getUserObject();
		return user.getUsername();
	}

	public String getUserEmail() {
		user = userDAO.getUserObject();
		return user.getEmail();
	}

	public String getUserPassword() {
		user = userDAO.getUserObject();
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
		
		//user inputs are correct, check if birthDate is a valid date, if so, set user's birthdate			
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		//no syntax errors found, return true
		return !expression;
	}
}
