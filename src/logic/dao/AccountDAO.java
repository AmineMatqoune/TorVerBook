package logic.dao;

import static logic.account.AccountType.RULE_CHECKER;
import static logic.account.AccountType.USER;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import logic.account.Account;
import logic.account.AccountType;
import logic.account.RuleChecker;
import logic.account.User;
import logic.db.DBManager;

public class AccountDAO {

	private static AccountDAO instance = null;

	private DBManager dbManager;
	private Account currentAccount;
	private ResultSet result;
	private AccountType accountType;
	private String errorMessage = "";

	// login case
	public boolean logIn(String username, String password) throws SQLException, ParseException {
		dbManager = DBManager.getInstance();
		errorMessage = "";
		accountType = getAccountTypeByPrefix(username);
		if (accountType == USER) {
			result = dbManager.userLogIn(username, password);
		} else if (accountType == RULE_CHECKER) {
			result = dbManager.ruleCheckerLogIn(username, password);
		}
		// if exists 1 row in result, then we succesfully logged in
		if (result.first()) {
			return createAccountObject(); 
		}
		return false;
	}

	public void registerUser(User user) throws SQLException {
		dbManager = DBManager.getInstance();
		if (dbManager.insertNewUser(user)) {
			currentAccount = user;
			accountType = USER;
		}
	}

	private boolean createAccountObject() throws SQLException, ParseException {
		// creazione dell'effettivo oggetto User/Rule Checker
		if (accountType == USER) {
			User user = new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"),
					result.getString("Email"), result.getString("Password"));
			user.setPhoneNumber(result.getString("PhoneNumber"));
			user.setBirthDate(result.getString("Birthdate"));
			user.setMoney(result.getInt("Money"));
			user.setNumViolations(result.getInt("NumViolations"));
			user.setStatus(result.getInt("isBanned"));
			currentAccount = user;
			if(user.isBanned()) {
				errorMessage = "USER_BANNED";System.out.println("errorMessage = " + errorMessage);
				return false;
			}
		} else if (accountType == RULE_CHECKER) {
			RuleChecker ruleChecker = new RuleChecker(result.getString("Name"), result.getString("Surname"),
					result.getString("Username"), result.getString("Email"), result.getString("Password"));
			ruleChecker.setPhoneNumber(result.getString("PhoneNumber"));
			ruleChecker.setBirthDate(result.getString("Birthdate"));
			ruleChecker.setSalary(result.getInt("Salary"));
			ruleChecker.setWorkStartTime(LocalDate.parse(result.getString("WorkStartTime")));
			ruleChecker.setworkFinishTime(LocalDate.parse(result.getString("WorkFinishTime")));
			currentAccount = ruleChecker;
		}
		return true;
	}

	public void updateAccountInfo(Account modifiedAccount) throws SQLException {
		// quando un utente aggiorna le proprie informazioni
		dbManager = DBManager.getInstance();
		boolean operationSucceded = false;
		operationSucceded = dbManager.updateAccountInfo(modifiedAccount, accountType, currentAccount.getUsername());

		if (operationSucceded) {
			// se l'update va a buon fine gli attributi di newUser vengono aggiornati
			currentAccount.changeProfileSettings(modifiedAccount.getName(), modifiedAccount.getSurname(),
					modifiedAccount.getUsername(), modifiedAccount.getEmail(), modifiedAccount.getPassword());
			currentAccount.setBirthDate(modifiedAccount.getBirthDateString());
			currentAccount.setPhoneNumber(modifiedAccount.getPhoneNumber());
		}
	}

	public Account getAccountObject() {
		return currentAccount;
	}

	public int getNumViolation(String username) throws SQLException {
		dbManager = DBManager.getInstance();
		return dbManager.getNumViolations(username).getInt("NumViolations");
	}

	public void toBan(String username) throws SQLException {
		dbManager = DBManager.getInstance();
		dbManager.setBannedUser(username);
	}

	public void incViolations(String username, int violations) throws SQLException {
		dbManager = DBManager.getInstance();
		dbManager.incNumViolations(username, violations);
	}

	public static AccountDAO getInstance() {
		if (instance == null)
			instance = new AccountDAO();
		return instance;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public AccountType getAccountTypeByPrefix(String username) {
		final String prefixFlag = "@";
		return username.startsWith(prefixFlag) ? RULE_CHECKER : USER;
	}
}
