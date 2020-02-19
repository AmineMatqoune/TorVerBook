package torverbook.web.bean;

import torverbook.web.account.Account;
import torverbook.web.dao.AccountDAO;

public class SettingsBean {

	private Account account;

	private AccountDAO accountDAO = AccountDAO.getInstance();

	public SettingsBean() {
		account =  accountDAO.getAccountObject();
	}

	// METODI PER IMPOSTARE STRINGHE NELLE TEXTFIELD
	public String getAccountName() {
		return account.getName();
	}

	public String getAccountSurname() {
		return account.getSurname();
	}

	public String getAccountBirthdate() {
		return account.getBirthDateString();
	}

	public String getAccountPhoneNumber() {
		return account.getPhoneNumber();
	}

	public String getAccountUsername() {
		return account.getUsername();
	}

	public String getAccountEmail() {
		return account.getEmail();
	}

	public String getAccountPassword() {
		return account.getPassword();
	}

	public void setAccountName(String name) {
		account.setName(name);
	}

	public void setAccountSurname(String surname) {
		account.setSurname(surname);
	}

	public void setAccountBirthdate(String date) {
		account.setBirthDate(date);
	}

	public void setAccountPhoneNumber(String phoneNumber) {
		account.setPhoneNumber(phoneNumber);
	}

	public void setAccountUsername(String username) {
		account.setUsername(username);
	}

	public void setAccountEmail(String email) {
		account.setEmail(email);
	}

	public void setAccountPassword(String password) {
		account.setPassword(password);
	}

	public boolean checkInfo(Account account) {
		boolean expression = false;

		if ((account.getName().length() > 15) || account.getName().equals(""))
			return expression;
		if ((account.getSurname().length() > 15) || account.getSurname().equals(""))
			return expression;
		if ((account.getUsername().length() > 20) || account.getUsername().equals(""))
			return expression;
		if ((account.getEmail().length() > 30) || account.getEmail().equals(""))
			return expression;
		if ((account.getPassword().length() > 30) || account.getPassword().equals(""))
			return expression;

		// no syntax errors found, return true
		return !expression;
	}
}
