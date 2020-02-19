package torverbook.web.dao;

public class MessagesDAO {

	private static MessagesDAO instance = null;

	private MessagesDAO() {}
	
	public static MessagesDAO getInstance() {
		if (instance == null)
			instance = new MessagesDAO();
		return instance;
	}
}
