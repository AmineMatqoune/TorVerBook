package logic.db;

import logic.account.User;

public interface QueriesGenerator {
	
	public static String getLogInQuery(String username, String password) {
		return "SELECT * FROM User WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';";
	}
	
	public static String getSignUpCommand(User user) {
		return "INSERT INTO User VALUES ('" + user.getUsername() + "', '" + user.getName() + "', '" + user.getSurname() + "', '" + user.getBirthDateString() + "', '" + user.getPhoneNumber() + "', "
				+ "'" + user.getEmail() + "', '" + user.getPassword() + "', FALSE, 0, 0)";
	}
	
	public static String getUpdateCommand(User user, String actualUsername) {
		return "UPDATE User SET Username = '" + user.getUsername() + "', Name = '" + user.getName() + "', Surname = '" + user.getSurname() + "', Birthdate = '" + user.getBirthDateString() + "', "
				+ "PhoneNumber = '" + user.getPhoneNumber() + "', Email = '" + user.getEmail() + "', Password = '" + user.getPassword() + "' WHERE Username = '" + actualUsername + "';";
	}

	public static String getMyAdsQuery(String username) {
		return "SELECT * FROM Ad WHERE User = '" + username + "' ORDER BY Date DESC";
	}
}
