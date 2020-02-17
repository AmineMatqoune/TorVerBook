package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import logic.controller.LogInController;

public class TestLogInController {
	
	//TEST CASE SVILUPPATO DA: Amine Matqoune 0253478
	
	//CORRECT CREDENTIALS: Username = Amine139
	//					   Password = amine.pwd
	
	@Test
	public void testCheckLoginCorrect() {
		LogInController login = new LogInController();
		assertEquals(true, login.checkLogin("Amine139", "amine.pwd"));
	}
	
	@Test
	public void testCheckLoginWrongPassword() {
		LogInController login = new LogInController();
		assertEquals(false, login.checkLogin("Amine139", "ludo.pwd")); 
	}
	
	@Test
	public void testCheckLoginWrongUsername() {
		LogInController login = new LogInController();
		assertEquals(false, login.checkLogin("Ludo98", "A3bdalla"));
	}
	
	@Test
	public void testCheckLoginWrongUsernameUpperCase() {
		LogInController login = new LogInController();
		assertEquals(true, login.checkLogin("amine139", "amine.pwd"));
	}
	
	@Test
	public void testCheckLoginWrongPasswordUpperCase() { 
		LogInController login = new LogInController();
		assertEquals(false, login.checkLogin("Ludo98", "ludo.PWD"));
	}
	
	@Test
	public void testCheckLoginWrongUsernameAndPasswordUpperCase() {
		LogInController login = new LogInController();
		assertEquals(false, login.checkLogin("amine139", "wrongPWD"));
	}

}
