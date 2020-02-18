package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import logic.account.Account;
import logic.account.User;
import logic.bean.SettingsBean;

public class TestSettingsBean {

	//TEST CASE SVILUPPATO DA: Ludovico Di Iorio 0254277
	@Test
	public void testCheckInfoCorrect() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Ludovico", "Di Iorio", "Ludo98", "ludovico479@gmail.com", "ludo.pwd");
		assertEquals(true, sBean.checkInfo(account)); // mi aspetto true
	}

	@Test
	public void testCheckInfoWrongName() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("", "Di Iorio", "Ludo98", "ludovico479@gmail.com", "ludo.pwd");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongSurname() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Ludovico", "", "Ludo98", "ludovico479@gmail.com", "ludo.pwd");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongUsername() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Ludovico", "Di Iorio", "", "ludovico479@gmail.com", "ludo.pwd");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongEmail() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Ludovico", "Di Iorio", "Ludo98", "", "ludo.pwd");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongPassword() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Ludovico", "Di Iorio", "Ludo98", "ludovico479@gmail.com", "");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	//Ora iniziano i test sulle informazioni che eccedono la lunghezza massima
	
	//TEST CASE SVILUPPATO DA: Abedel Abdelrahman 0253048
	@Test
	public void testCheckInfoCorrect2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Abdel", "Abdel", "CptPackage", "abdelrhmanabdalla15@gmail.com", "A3bdalla");
		assertEquals(true, sBean.checkInfo(account)); // mi aspetto true
	}
	
	@Test
	public void testCheckInfoWrongName2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("abcdefghijklmnopq", "Abdel", "CptPackage", "abdelrhmanabdalla15@gmail.com", "A3bdalla");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongSurname2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Abdel", "abcdefghijklmnopq", "CptPackage", "abdelrhmanabdalla15@gmail.com", "A3bdalla");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongUsername2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Abdel", "Abdel", " ", "abdelrhmanabdalla15@gmail.com", "A3bdalla");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongEmail2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Abdel", "Abdel", "CptPackage", "abcdefghijklmnopqrstuvwxyz123456", "A3bdalla");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

	@Test
	public void testCheckInfoWrongPassword2() throws SQLException, ParseException {
		SettingsBean sBean = new SettingsBean();
		Account account = new User("Abdel", "Abdel", "CptPackage", "abdelrhmanabdalla15@gmail.com", "0123456789032145678901236547891");
		assertEquals(false, sBean.checkInfo(account)); // mi aspetto false
	}

}
