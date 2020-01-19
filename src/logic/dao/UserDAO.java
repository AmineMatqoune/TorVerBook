package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.account.User;
import logic.db.DBManager;

public class UserDAO {
	
	private DBManager dbManager;	
	private User newUser;
	private ResultSet result;
	
	//login case
	public boolean logIn (String username, String password) throws SQLException, ClassNotFoundException {
		dbManager = DBManager.getInstance();
		result = dbManager.logIn(username, password);

		//if exists 1 row in result, we succesfully logged in
		if(result.first()) {
			createUserObject();
			return true;
		}
			
		return false;
	}
	
	public void registerUser(User user) throws SQLException, ClassNotFoundException {
		dbManager = DBManager.getInstance();

		if(dbManager.insertNewUser(user))
			newUser = user;
	}
	
	private User createUserObject() throws SQLException {
		//create UserObject
		newUser = new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"), result.getString("Email"), result.getString("Password"));
		newUser.setPhoneNumber(result.getString("PhoneNumber"));
		newUser.setBirthDate(result.getString("Birthdate"));
		return newUser;
	}
	
	public User getUserObject() {
		return newUser;
	}
}
