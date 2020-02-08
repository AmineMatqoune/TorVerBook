package logic.account;

import java.util.Date;

public abstract class Account {

	// User's account info
	protected String username;
	protected String email;
	protected String password;

	// User's info
	protected String name;
	protected String surname;
	protected Date birthDate;
	protected String birthDateString;
	protected String phoneNumber;

	public Account(String name, String surname, String username, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public String getBirthDateString() {
		return this.birthDateString;
	}

	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDateString = birthDate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void changeProfileSettings(String name, String surname, String username, String email, String pwdHash){
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = pwdHash;
	}
	
}
