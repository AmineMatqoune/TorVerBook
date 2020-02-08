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

	private AccountDAO() {
	}

	// login case
	public boolean logIn(String username, String password) throws SQLException, ClassNotFoundException, ParseException {
		dbManager = DBManager.getInstance();
		accountType = getAccountTypeByPrefix(username);
		if (accountType == USER) {
			result = dbManager.userLogIn(username, password);
		} else if (accountType == RULE_CHECKER) {
			result = dbManager.ruleCheckerLogIn(username, password);
		}
		// if exists 1 row in result, then we succesfully logged in
		if (result.first()) {
//			createUserObject();
			createAccountObject();
			return true;
		}
		return false;
	}

	public void registerUser(User user) throws SQLException, ClassNotFoundException {
		dbManager = DBManager.getInstance();

		if (dbManager.insertNewUser(user)) {
			currentAccount = (Account) user;
			accountType = USER;
		}

	}

	private void createAccountObject() throws SQLException, ClassNotFoundException, ParseException {
		// creazione dell'effettivo oggetto User/Rule Checker
		if (accountType == USER) {
			User user = new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"),
					result.getString("Email"), result.getString("Password"));
			user.setPhoneNumber(result.getString("PhoneNumber"));
			user.setBirthDate(result.getString("Birthdate"));
			user.setMoney(result.getInt("Money"));
			user.setNumViolations(result.getInt("NumViolations"));
			currentAccount = user;
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
	}

//	private void createUserObject() throws SQLException, ClassNotFoundException, ParseException {
//		// creazione dell'effettivo oggetto User
//		newUser = new User(result.getString("Name"), result.getString("Surname"), result.getString("Username"),
//				result.getString("Email"), result.getString("Password"));
//		newUser.setPhoneNumber(result.getString("PhoneNumber"));
//		newUser.setBirthDate(result.getString("Birthdate"));
//		newUser.setMoney(result.getInt("Money"));
//		newUser.setNumViolations(result.getInt("NumViolations"));
//	}

	public void updateAccountInfo(Account modifiedAccount) throws ClassNotFoundException, SQLException {
		// quando un utente aggiorna le proprie informazioni
		dbManager = DBManager.getInstance();
		boolean operationSucceded = false;
		operationSucceded = dbManager.updateAccountInfo(modifiedAccount, accountType, currentAccount.getUsername());

		if (operationSucceded) {
			// se l'update è andato a buon fine gli attributi di newUser vengono aggiornati
			currentAccount.changeProfileSettings(modifiedAccount.getName(), modifiedAccount.getSurname(),
					modifiedAccount.getUsername(), modifiedAccount.getEmail(), modifiedAccount.getPassword());
			currentAccount.setBirthDate(modifiedAccount.getBirthDateString());
			currentAccount.setPhoneNumber(modifiedAccount.getPhoneNumber());
		}
	}

	public Account getAccountObject() {
		return currentAccount;
	}

	public int getNumViolation(String username) throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
		return dbManager.getNumViolations(username).getInt("NumViolations");
	}

	public void toBan(String username) throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
		dbManager.setBannedUser(username);
	}

	public void incViolations(String username, int violations) throws ClassNotFoundException, SQLException {
		dbManager = DBManager.getInstance();
		dbManager.incNumViolations(username, violations);
	}

	public static AccountDAO getInstance() {
		if (instance == null)
			instance = new AccountDAO();
		return instance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	private AccountType getAccountTypeByPrefix(String username) {
		final String prefixFlag = "@";
		return username.startsWith(prefixFlag) ? RULE_CHECKER : USER;
	}
}
