package logic.bean;

import logic.account.User;
import logic.dao.UserDAO;
import logic.gui.SettingScene;

public class SettingsBean {

	private User user;

	private UserDAO userDAO = UserDAO.getInstance();

	public SettingsBean() {
		user = userDAO.getUserObject();
	}


	// METODI PER IMPOSTARE STRINGHE NELLE TEXTFIELD
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

	public void setUserName(String name) {
		user.setName(name);
	}

	public void setUserSurname(String surname) {
		user.setSurname(surname);
	}

	public void setUserBirthdate(String date) {
		user.setBirthDate(date);
	}

	public void setUserPhoneNumber(String phoneNumber) {
		user.setPhoneNumber(phoneNumber);
	}

	public void setUserUsername(String username) {
		user.setUsername(username);
	}

	public void setUserEmail(String email) {
		user.setEmail(email);
	}

	public void setUserPassword(String password) {
		user.setPassword(password);
	}


	public boolean checkInfo(User user) {

		boolean expression = false;

		if ((user.getName().length() > 15) || user.getName().equals(""))
			return expression;
		if ((user.getSurname().length() > 15) || user.getSurname().equals(""))
			return expression;
		if ((user.getUsername().length() > 20) || user.getUsername().equals(""))
			return expression;
		if ((user.getEmail().length() > 30) || user.getEmail().equals(""))
			return expression;
		if ((user.getPassword().length() > 30) || user.getPassword().equals(""))
			return expression;

		// no syntax errors found, return true
		return !expression;
	}
}
