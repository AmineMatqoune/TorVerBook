package logic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBManager {
	
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/TorVerBook";
	private static String user = "root";
	private static String pwd = "";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet result;
	
	private static DBManager instance = null;
	
	public DBManager() throws SQLException, ClassNotFoundException{
		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = (Statement) conn.createStatement();
	}
	
	public ResultSet logIn(String username, String password) throws SQLException {
		result = stmt.executeQuery(QueriesGenerator.getLogInQuery(username, password));
		
		//Se user esiste
		if(result.first())
			return result;
		return null;
	}
	public void close() throws SQLException {
		stmt.close();
		conn.close();
	}
	
	public static DBManager getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) 
			instance = new DBManager();
		return instance;
	}
	
}
