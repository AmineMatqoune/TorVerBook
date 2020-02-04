package logic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import logic.account.User;
import logic.db.DBManager;

public class UserDAO {
	
	private static UserDAO instance = null;
	
	private DBManager dbManager;	
	private User newUser;
	private User userTemp;	//user temporaneo per mantenere modifiche non salvate ancora
	private ResultSet result;
	
	private UserDAO() {}
	
	//login case
	public boolean logIn (String username, String password) throws SQLException, ClassNotFoundException, ParseException {
		dbManager = DBManager.getInstance();
		result = dbManager.logIn(username, password);

		//if exists 1 row in result, then we succesfully logged in
		if(result.first()) {
			createUserObject();
			return true;
		}
		return false;
	}
	
	public void registerUser(User user) throws SQLException, ClassNotFoundException {
		dbManager = DBManager.getInstance();

		if(dbManager.insertNewUser(user))
			newUser = user;
	}
	
	private void createUserObject() throws SQLException, ClassNotFoundException, ParseException {
		//creazione dell'effettivo oggetto User
		newUser = new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"), result.getString("Email"), result.getString("Password"));
		newUser.setPhoneNumber(result.getString("PhoneNumber"));
		newUser.setBirthDate(result.getString("Birthdate"));
		newUser.setMoney(result.getInt("Money"));
		newUser.setNumViolations(result.getInt("NumViolations"));
		
		//gli attributi di userTemp hanno lo stesso valore di quelli di newUser
		userTemp = new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"), result.getString("Email"), result.getString("Password"));
		userTemp.setPhoneNumber(result.getString("PhoneNumber"));
		userTemp.setBirthDate(result.getString("Birthdate"));
	}
	
	public void updateUserInfoDAO(User user) throws ClassNotFoundException, SQLException {
		//quando un utente aggiorna le proprie informazioni
		dbManager = DBManager.getInstance();
		if(dbManager.updateUserInfo(user, newUser.getUsername())) {
			//se l'update è andato a buon fine gli attributi di newUser vengono aggiornati
			newUser.changeProfileSettings(user.getName(), user.getSurname(), user.getUsername(), user.getEmail(), user.getPassword());
			newUser.setBirthDate(user.getBirthDateString());
			newUser.setPhoneNumber(user.getPhoneNumber());
		}
	}
	
	public User getUserObject() {
		return newUser;
	}
	
	public static UserDAO getInstance() {
		if(instance == null) 
			instance = new UserDAO();
		return instance;
	}
}
