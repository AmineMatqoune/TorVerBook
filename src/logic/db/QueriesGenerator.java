package logic.db;

public class QueriesGenerator {
	
	public static String getLogInQuery(String username, String password) {
		return "SELECT * FROM Usfder WHERE Username = '" + username + "'"
				+ " AND Password = '" + password + "';";
	}
	
	public static String getSignInCommand(String name, String surname, String dd, String mm, String yyyy, String phoneNumber, String username, String email, String password) {
		return "INSERT INTO User VALUES ('" + username + "', '" + name + "', '" + surname + "', '" + yyyy + "-" + mm + "-" + dd + "', '" + phoneNumber + "', "
				+ "'" + email + "', '" + password + "', FALSE)";
	}
}
