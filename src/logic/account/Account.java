package logic.account;

import java.util.Date;


public abstract class Account {
	
	//User's info
	protected String name;
	protected String surname;
	protected Date birthDate;
	protected String phoneNumber;
		
	//User's account info
	protected String username;
	protected String email;
	protected String password;
	
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

	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {		
		return this.email;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public String getPassword() {
		return this.password;
	}
}
