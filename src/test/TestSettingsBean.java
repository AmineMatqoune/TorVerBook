package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import logic.account.Account;
import logic.account.User;
import logic.bean.SettingsBean;

public class TestSettingsBean {

	@Test
	public void testCheckInfoCorrect() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "Amine139", "ciao@email.it", "123456");
		assertEquals(true, sBean.checkInfo(account)); // mi aspetto true
	}

	@Test
	public void testCheckInfoWrongName() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("", "Matqoune", "Amine139", "ciao@email.it", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongSurname() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "", "Amine139", "ciao@email.it", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongUsername() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "", "ciao@email.it", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongEmail() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "Amine139", "", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongPassword() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "Amine139", "ciao@email.it", "");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	//Ora iniziano i test sulle informazioni che eccedono la lunghezza massima
	
	@Test
	public void testCheckInfoWrongName2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("abcdefghijklmnopq", "Matqoune", "Amine139", "ciao@email.it", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongSurname2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "abcdefghijklmnopq", "Amine139", "ciao@email.it", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongUsername2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "1230456789012345678910", "ciao@email.it", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongEmail2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "Amine139", "abcdefghijklmnopqrstuvwxyz123456", "123456");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongPassword2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Amine", "Matqoune", "Amine139", "ciao@email.it", "0123456789032145678901236547891");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

}
