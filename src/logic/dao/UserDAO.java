package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class UserDAO {

	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/TorVerBook";
	private static String user = "root";
	private static String pwd = "";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet result;
	
	public boolean verifyCredentials (String username, String password) throws SQLException{
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(dbUrl, user, pwd);
			stmt = (Statement) conn.createStatement();
			ResultSet result = stmt.executeQuery(Query.getLogInQuery(username, password));
			if(result.first())
				System.out.println("Creo l'oggetto utente");
			return result.first();	
		}  catch (ClassNotFoundException e) {
			System.err.println("Error while loading DB driver");
			e.printStackTrace();
			System.exit(0);
		} finally {
			stmt.close();
			conn.close();
		}
		return false;
	}
	
	
	
}
