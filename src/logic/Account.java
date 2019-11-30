package logic;

public class Account implements AccountInterface{
	
	//User's info
	protected String name;
	protected String surname;
	protected String address;
	protected int age;
		
	//User's account info
	protected String username;
	protected String email;
	protected String pwdHash;
	
	public Account(String name, String surname, String address, int age, String username, String email, String pwdHash) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.age = age;
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

	public int getAge() {
		return this.age;
	}

	public String getAddress() {
		return this.address;
	}

	public String getEmail() {		
		return this.email;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPwdHash() {
		return this.pwdHash;
	}
}
