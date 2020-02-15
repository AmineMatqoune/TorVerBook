package logic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.account.Account;
import logic.account.AccountType;
import logic.account.User;
import logic.ad.Ad;

public class DBManager {

	private static String dbUrl = "jdbc:mysql://torverbook.clnw3ivtnsjr.eu-west-2.rds.amazonaws.com:3306/torverbook?autoReconnect=true&useSSL=false";
	private static String user = "admin";
	private static String pwd = "QVIavmKCXTKFkSbRMX34";

	private static DBManager instance = null;
	
	Statement stmt = null;
	Connection conn = null;

	public ResultSet ruleCheckerLogIn(String username, String password) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getRuleCheckerLogInQuery(username, password));
	}

	public ResultSet userLogIn(String username, String password) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getUserLogInQuery(username, password));
	}

	public boolean insertNewUser(User userObj) throws SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getSignUpCommand(userObj));
	}

	public ResultSet getSearchAds(String category, String type, double price) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getSearchListAds(category, type, price));
	}
	
	public boolean updateAccountInfo(Account accountObj, AccountType accountType, String actualUsername) throws SQLException {
		init();
		if (accountType == AccountType.RULE_CHECKER) {
			return !stmt.execute(QueriesGenerator.getUpdateRuleCheckerInfoCommand(accountObj, actualUsername));
		} else {
			return !stmt.execute(QueriesGenerator.getUpdateUserInfoCommand(accountObj, actualUsername));
		}
	}

	public ResultSet getHomepageAds() throws SQLException {
		init();
		//we don't have any parameter to pass to QueriesGenerator, that's why we wrote the query here
		return stmt.executeQuery("SELECT * FROM Ad WHERE isConvalidated = TRUE ORDER BY Highlight DESC, Date DESC LIMIT 100");
	}
	
	public ResultSet checkIsFavouriteAd(long adId, String username) throws  SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.checkIsFavourite(adId, username));
	}

	public ResultSet getMyAds(String username) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getMyAdsQuery(username));
	}

	public ResultSet getFavouriteAds(String username) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getFavouriteAdsQuery(username));
	}

	public boolean addAdToFavouriteList(long id, String username) throws  SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getAddAdToFavouriteListCommand(id, username));
	}
	
	public boolean removeAdFromFavouriteList(long id, String currentUser) throws  SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getRemoveAdFromFavouriteListCommand(id, currentUser));
		
	}

	public ResultSet getHighlight(String hlType) throws  SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getHighlightQuery(hlType));
	}

	// metodo per rifiutare l'annuncio
	public boolean deleteRCReview(String writer, String receiver) throws  SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getDeleteReviewCommand(writer, receiver));
	}

	public ResultSet getMyReview(String username) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getMyReviewQuery(username));
	}
	
	// metodo per convalidare l'annuncio
	public boolean updateReviewState(String writer, String receiver, String rulechecker) throws SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getUpdateReviewStateCommand(writer, receiver, rulechecker));
	}

	public ResultSet getRCReview() throws SQLException {
		init();
		return stmt.executeQuery("SELECT * FROM Review WHERE isConvalidated = FALSE ORDER BY Time ASC");
	}
	
	public ResultSet getRCAd() throws SQLException {
		init();
		return stmt.executeQuery("SELECT * FROM Ad WHERE isConvalidated = FALSE ORDER BY Date ASC");
	}

	public ResultSet getNumViolations(String username) throws  SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getNumViolationsQuery(username));
	}

	public boolean setBannedUser(String username) throws SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getBannedCommand(username));
	}

	public boolean incNumViolations(String username, int violations) throws  SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getIncNumViolationsCommand(username, violations));
	}

	public boolean addAd(Ad ad, int newMoney) throws SQLException {
		init();
		return (!stmt.execute(QueriesGenerator.getAddAdCommand(ad)) && !stmt.execute(QueriesGenerator.getPaymentCommand(ad.getOwnerUsername(), newMoney)));
		
	}

	public boolean updateAdState(long id) throws SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getUpdateAdStateCommand(id));
	}

	public boolean deleteAd(long id) throws SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getDeleteAdCommand(id));
	}
	
	public boolean markAsSold(long id) throws SQLException {
		init();
		return !stmt.execute(QueriesGenerator.getMarkAsSoldCommand(id));
	}
	
	public ResultSet getAverageRank(String username) throws SQLException {
		init();
		return stmt.executeQuery(QueriesGenerator.getRankAverageQuery(username));
	}
	
	private void init() throws SQLException {
		stmt = null;
		conn = null;
		
		conn = DriverManager.getConnection(dbUrl, user, pwd);
		stmt = conn.createStatement();
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
