package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import logic.account.Account;
import logic.account.User;
import logic.bean.SettingsBean;
import logic.exceptions.EmptyFieldException;
import logic.exceptions.ExcessiveInputLengthException;

public class TestSettingsBean {

	private String pwdLudo = "ludo.pwd";
	private String emailLudo = "ludovico479@gmail.com";
	private String nameLudo = "Ludovico";
	private String usernameLudo = "Ludo98";
	private String surnameLudo = "Di Iorio";

	private String pwdAbdel = "A3bdalla";
	private String nameAbdel = "Abdel";
	private String emailAbdel = "abdelrhmanabdalla15@gmail.com";
	private String usernameAbdel = "CptPackage";

	@Test
	public void testCheckInfoCorrect()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameLudo, surnameLudo, usernameLudo, emailLudo, pwdLudo);
		assertEquals(true, sBean.checkInfo(account)); // mi aspetto true
	}

	@Test
	public void testCheckInfoWrongName()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("", surnameLudo, usernameLudo, emailLudo, pwdLudo);

		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (EmptyFieldException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongSurname()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameLudo, "", usernameLudo, emailLudo, pwdLudo);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (EmptyFieldException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongUsername()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameLudo, surnameLudo, "", emailLudo, pwdLudo);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (EmptyFieldException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongEmail()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameLudo, surnameLudo, usernameLudo, "", pwdLudo);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (EmptyFieldException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongPassword()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameLudo, surnameLudo, usernameLudo, emailLudo, "");
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (EmptyFieldException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	// Ora iniziano i test sulle informazioni che eccedono la lunghezza massima

	@Test
	public void testCheckInfoCorrect2()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameAbdel, nameAbdel, usernameAbdel, emailAbdel, pwdAbdel);
		assertEquals(true, sBean.checkInfo(account)); // mi aspetto true
	}

	@Test
	public void testCheckInfoWrongName2()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("abcdefghijklmnopq", nameAbdel, usernameAbdel, emailAbdel, pwdAbdel);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (ExcessiveInputLengthException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongSurname2()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameAbdel, "abcdefghijklmnopq", usernameAbdel, emailAbdel, pwdAbdel);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (ExcessiveInputLengthException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongUsername2()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameAbdel, nameAbdel, "qwemopwqmepomwqpoenwqnrqwndaspodnwqiondoiwq",
				"abdelrhmanabdalla15@gmail.com", pwdAbdel);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (ExcessiveInputLengthException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongEmail2()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameAbdel, nameAbdel, usernameAbdel, "abcdefghijklmnopqrstuvwxyz123456", pwdAbdel);
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (ExcessiveInputLengthException ex) {
			checkResult = false;
		}
		assertEquals(false, checkResult); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongPassword2()
			throws SQLException, ParseException, ExcessiveInputLengthException, EmptyFieldException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User(nameAbdel, nameAbdel, usernameAbdel, emailAbdel, "0123456789032145678901236547891");
		boolean checkResult = true;
		try {
			sBean.checkInfo(account);
		} catch (ExcessiveInputLengthException ex) {
			checkResult = false;
		}

		assertEquals(false, checkResult); // mi aspetto false
	}

}
