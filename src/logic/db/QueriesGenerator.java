package logic.db;

import logic.account.User;
import logic.stuff.Message;
import logic.utils.DateAndTimeUtils;

/* DOC. TIPS:: Fields Types Are (CONDITION:SELECT,INSERT,UPDATE,QUERY) */
public interface QueriesGenerator {

	public static String getLogInQuery(String username, String password) {
		/* CONDITION FIELDS: [USERNAME] [PASSWORD] */
		return "SELECT * FROM User WHERE Username = '" + username + "'" + " AND Password = '" + password + "';";
	}

	public static String getSignUpCommand(User user) {
		/*
		 * INSERT FIELDS: [USERNAME] [NAME] [SURNAME] [BIRTHDAY] [PHONENUMBER] [EMAIL]
		 * [PASSWORD] [IS_BANNED] [N_VIOLATIONS] [MONEY]
		 */
		return "INSERT INTO User VALUES ('" + user.getUsername() + "', '" + user.getName() + "', '" + user.getSurname()
				+ "', '" + user.getBirthDateString() + "', '" + user.getPhoneNumber() + "', " + "'" + user.getEmail()
				+ "', '" + user.getPassword() + "', FALSE, 0, 0)";
	}

	public static String getUpdateUserInfoCommand(User user, String actualUsername) {
		/*
		 * UPDATE FIELDS: [USERNAME] [NAME] [SURNAME] [BIRTHDAY] [PHONENUMBER] [EMAIL]
		 * [PASSWORD]
		 */
		/* CONDITION FIELDS: [CURRENT_USERNAME] */
		return "UPDATE User SET Username = '" + user.getUsername() + "', Name = '" + user.getName() + "', Surname = '"
				+ user.getSurname() + "', Birthdate = '" + user.getBirthDateString() + "', " + "PhoneNumber = '"
				+ user.getPhoneNumber() + "', Email = '" + user.getEmail() + "', Password = '" + user.getPassword()
				+ "' WHERE Username = '" + actualUsername + "';";
	}

	public static String getLatestMessagesQuery(User srcUser, User dstUser, int maxNumberOfMessages) {
		/* CONDITION FIELDS: [WRITERUSER] [RECEIVERUSER] */
		/* QUERY FIELDS: [QUERY_LIMIT] */
		return "SELECT * FROM Message WHERE WriterUser='" + srcUser.getUsername() + "' AND ReceiverUser='"
				+ dstUser.getUsername() + "' ORDER BY Time AND Date Desc Limit " + maxNumberOfMessages;
	}

	public static String sendMessageCommand(User srcUser, User dstUser, Message message) {
		/* INSERT FIELDS: [WRITERUSER] [RECEIVERUSER] [TEXT] [TIME] [DATE] */
		return "INSERT INTO Message (WriterUser,ReceiverUser,Text,Time,Date) VALUES ('" + srcUser.getUsername() + "',"
				+ dstUser.getUsername() + "'," + message.getText() + "'," + DateAndTimeUtils.getTimeString() + ",'"
				+ DateAndTimeUtils.getDateString() + "')";
	}
}
