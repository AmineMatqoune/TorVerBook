package logic.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.account.User;

public class DBManager {
	
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/torverbook";
	private static String user = "root";
	private static String pwd = "";
	
	private Connection conn;
	private Statement stmt;
	
	private static DBManager instance = null;
	
	private DBManager() throws SQLException, ClassNotFoundException{
		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
	}
	
	public ResultSet logIn(String username, String password) throws SQLException {
		return stmt.executeQuery(QueriesGenerator.getLogInQuery(username, password));
	}
	
	public boolean insertNewUser(User user) throws SQLException{
		return !stmt.execute(QueriesGenerator.getSignUpCommand(user));
	}
	
	public boolean updateUserInfo(User user, String actualUsername) throws SQLException {
		return !stmt.execute(QueriesGenerator.getUpdateCommand(user, actualUsername));
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
