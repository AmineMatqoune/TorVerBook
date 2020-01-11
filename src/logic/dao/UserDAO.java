package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import logic.account.User;
import logic.db.DBManager;

public class UserDAO {

	private DBManager dbManager;	
	
	private ResultSet result;
	
	public boolean logIn (String username, String password) throws SQLException, ClassNotFoundException {
		dbManager = DBManager.getInstance();
		result = dbManager.logIn(username, password);

		//if exists 1 row in result, we succesfully logged in
		if(result != null)
			return result.first();
		return false;
	}
	
	public User getUserObject() throws SQLException {
		return new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"), result.getString("Email"), result.getString("Password"));
	}
}
