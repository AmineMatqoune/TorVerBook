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

	public static String getHomepageAdsQuery() {
		return "SELECT * FROM Ad WHERE isConvalidated = TRUE ORDER BY Highlight DESC, Date DESC LIMIT 100";
	}
	
	public static String getMyAdsQuery(String username) {
		return "SELECT * FROM Ad WHERE User = '" + username + "' ORDER BY Date DESC";
	}
	
	public static String getUpdateReviewStateCommand(String writer, String receiver) {
		return "UPDATE Review SET isConvalidated = TRUE WHERE WriterUser = '" + writer + "' AND ReceiverUser = '" + receiver + "';";
	}
		
	public static String getDeleteReviewCommand(String writer, String receiver) {
		return "DELETE FROM Review WHERE WriterUser = '" + writer + "' AND ReceiverUser = '" + receiver + "';";
	}
		
	public static String getMyReviewQuery(String username) {
		return "SELECT * FROM Review WHERE isConvalidated = TRUE AND ReceiverUser = '" + username + "' ORDER BY Time ASC";
	}
		
	public static String getFavouriteAdsQuery(String username) {
		return "SELECT ID, Date, Description, Title, Price, Course, Type, isSold, Quantity, StartHighlight, FinishHighlight, "
				+ "isConvalidated, Highlight, Ad.User, RuleChecker FROM Ad JOIN FavouriteList ON ID_Ad = ID WHERE FavouriteList.User = '" + username + "';";
	}
	
	public static String getRCReviewQuery() {
		return "SELECT * FROM Review WHERE isConvalidated = FALSE ORDER BY Time ASC";
	}
	
	public static String getHighlightQuery(String hlType) {
		return "SELECT * FROM HighLight WHERE Type = '" + hlType + "'";
	}
	
	public static String getNumViolationsQuery(String username) {
		return "SELECT NumViolations FROM User WHERE Username = '" + username + "';";
	}
	
	public static String getBannedCommand(String username) {
		return "UPDATE User SET isBanned = TRUE WHERE Username = '" + username + "';";
	}
	
	public static String getIncNumViolationsCommand(String username, int violations) {
		return "UPDATE User SET NumViolations = " + violations + " WHERE Username = '" + username + "';";
	}
	
	public static String getAddAdCommand(String date, String description, String title, double price, String course, String type, int quantity, String startHighlight, String finishHighlight, String highlight, String username) {
		return "INSERT INTO Ad (Date, Description, Title, Price, Course, Type, Quantity, StartHighlight, FinishHighlight, Highlight, User, RuleChecker) "
				+ "VALUES ('" + date + "', '" + description +"', '" + title + "', '" + price + "', '" + course + "', '" + type + "', '" + quantity + "', '" + startHighlight 
				+ "', '" + finishHighlight + "', '" + highlight + "', '" + username + "', NULL);";
	}
}
