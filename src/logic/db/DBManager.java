package logic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import logic.account.User;
import logic.ad.Ad;

public class DBManager {

	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://torverbook.clnw3ivtnsjr.eu-west-2.rds.amazonaws.com:3306/torverbook?autoReconnect=true&useSSL=false";
	private static String user = "admin";
	private static String pwd = "QVIavmKCXTKFkSbRMX34";

	private static DBManager instance = null;

	Statement stmt = null;
	Connection conn = null;
	
	public ResultSet ruleCheckerLogIn(String username, String password) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;
		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getRuleCheckerLogInQuery(username, password));
	}
	
	public ResultSet userLogIn(String username, String password) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;
		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getUserLogInQuery(username, password));
	}

	public boolean insertNewUser(User userObj) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getSignUpCommand(userObj));
	}

	public boolean updateUserInfo(User userObj, String actualUsername) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getUpdateUserInfoCommand(userObj, actualUsername));
	}

	public ResultSet getHomepageAds() throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getHomepageAdsQuery());
	}

	public ResultSet getMyAds(String username) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getMyAdsQuery(username));
	}

	public ResultSet getFavouriteAds(String username) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getFavouriteAdsQuery(username));
	}

	public boolean addAdToFavouriteList(long id, String username) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getAddAdToFavouriteListCommand(id, username));
	}

	public ResultSet getHighlight(String hlType) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getHighlightQuery(hlType));
	}

	// metodo per convalidare l'annuncio
	public boolean updateReviewState(String writer, String receiver) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getUpdateReviewStateCommand(writer, receiver));
	}

	// metodo per rifiutare l'annuncio
	public boolean deleteRCReview(String writer, String receiver) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getDeleteReviewCommand(writer, receiver));
	}

	public ResultSet getMyReview(String username) throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getMyReviewQuery(username));
	}

	public ResultSet getRCReview() throws SQLException, ClassNotFoundException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getRCReviewQuery());
	}

	public ResultSet getNumViolations(String username) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return stmt.executeQuery(QueriesGenerator.getNumViolationsQuery(username));
	}

	public boolean setBannedUser(String username) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getBannedCommand(username));
	}

	public boolean incNumViolations(String username, int violations) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getIncNumViolationsCommand(username, violations));
	}

	public boolean addAd(Ad ad) throws ClassNotFoundException, SQLException {
		stmt = null;
		conn = null;

		Class.forName(driverClass);
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
		return !stmt.execute(QueriesGenerator.getAddAdCommand(ad));
	}

	public void close() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

	public static DBManager getInstance() {
		if (instance == null)
			instance = new DBManager();
		return instance;
	}
}
