package logic.dao;

import java.sql.ResultSet;

import logic.account.User;
import logic.db.DBManager;
import logic.stuff.Message;

public class MessagesDAO {

	private static MessagesDAO instance = null;

	private DBManager dbManager;
	private User newUser;
	private User userTemp;
	private ResultSet result;

	/* Abbiamo scelto arbitrariamente 20 messagi */
	public Message getLatest20Messages(User srcUser, User dstUser) {
		return null;
	}

	public static MessagesDAO getInstance() {
		if (instance == null)
			instance = new MessagesDAO();
		return instance;
	}
}
