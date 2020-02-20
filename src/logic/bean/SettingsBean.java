package logic.bean;

import static logic.utils.DataValidationUtils.checkByMaxLength;
import static logic.utils.DataValidationUtils.checkNotEmpty;

import logic.account.Account;
import logic.dao.AccountDAO;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;

public class SettingsBean {

	private Account account;

	private AccountDAO accountDAO = AccountDAO.getInstance();

	public SettingsBean() {
		account = accountDAO.getAccountObject();
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

	public boolean checkInfo(Account account) throws ExcessiveInputLengthException, EmptyFieldException {
		return checkByMaxLength(account.getName(), 15) && checkNotEmpty(account.getName())
				&& checkByMaxLength(account.getSurname(), 15) && checkNotEmpty(account.getSurname())
				&& checkByMaxLength(account.getUsername(), 20) && checkNotEmpty(account.getUsername())
				&& checkByMaxLength(account.getEmail(), 30) && checkNotEmpty(account.getEmail())
				&& checkByMaxLength(account.getPassword(), 30) && checkNotEmpty(account.getPassword());
	}

}
