package logic.db;

import logic.account.User;

public interface QueriesGenerator {
	
	public static String getLogInQuery(String username, String password) {
		System.out.println("flag4: " + "SELECT * FROM User WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';");
		return "SELECT * FROM User WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';";
		
	}
	
	public static String getSignUpCommand(User user) {
		return "INSERT INTO User VALUES ('" + user.getUsername() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getBirthDateString() + "', '" + user.getPhoneNumber() + "', "
				+ "'" + user.getEmail() + "', '" + user.getPassword() + "', FALSE)";
	}
}
