package logic.db;

public class QueriesGenerator {
	
	public static String getLogInQuery(String username, String password) {
		return "SELECT * FROM Usfder WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';";
	}
	
}
