package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import logic.account.AccountType;
import logic.dao.AccountDAO;

public class TestAccountDAO {

	@Test
	public void testLogInCorrect() throws SQLException, ParseException {
		AccountDAO account = new AccountDAO();
		assertEquals(true, account.logIn("Ludo98", "ludo.pwd"));
	}
	
	@Test
	public void testLogInWrong() throws SQLException, ParseException {
		AccountDAO account = new AccountDAO();
		assertEquals(false, account.logIn("notExistingUser", "notExistingUserPWD"));
	}
	
	@Test
	public void testAccountTypeByPrefixCorrect() {
		AccountDAO account = new AccountDAO();
		assertEquals(AccountType.USER, account.getAccountTypeByPrefix("Ludo98"));
	}
	
	@Test
	public void testAccountTypeByPrefixWrong() {
		AccountDAO account = new AccountDAO();
		assertEquals(AccountType.RULE_CHECKER, account.getAccountTypeByPrefix("@CarloRossi"));
	}
	
}
