package logic.dao;

public class Query {
	
	public static String getLogInQuery(String username, String password) {
		return "SELECT * FROM User WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';";
	}
	
}
