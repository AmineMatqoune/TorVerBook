package logic.db;

import logic.account.User;

public class QueriesGenerator {
	
	public static String getLogInQuery(String username, String password) {
		return "SELECT * FROM User WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';";
	}
	
	public static String getSignInCommand(User user) {
		return "INSERT INTO User VALUES ('" + user.getUsername() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getBirthDateString() + "', '" + user.getPhoneNumber() + "', "
				+ "'" + user.getEmail() + "', '" + user.getPassword() + "', FALSE)";
	}
}
