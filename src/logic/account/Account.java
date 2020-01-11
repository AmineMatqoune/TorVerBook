package logic.account;

import java.util.Calendar;

public abstract class Account {
	
	//User's info
	protected String name;
	protected String surname;
	protected Calendar birthDate;
	protected String birthPlace;
	protected String phoneNumber;
		
	//User's account info
	protected String username;
	protected String email;
	protected String pwdHash;
	
	public Account(String name, String surname, String username, String email, String pwdHash) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.pwdHash = pwdHash;
	}
	
	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public Calendar getBirthDate() {
		return this.birthDate;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {		
		return this.email;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public String getPwdHash() {
		return this.pwdHash;
	}
}
