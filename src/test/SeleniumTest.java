package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class SeleniumTest {
   /*
	*Selenium test case by Matqoune Amine 0253478
	*Per far partire questo testcase è necessario avviare prima il server locale TomCat
	*in maniera tale da poter testare Selenium, altrimenti il sito risulta irraggiungibile
   */	
	@Test
	public void testLogInSuccessfull() {
		assertEquals(true, logIn("Amine139", "amine.pwd"));
	}
	
	public boolean logIn(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:5080");
		
		driver.findElement(By.id("username-input")).sendKeys(username);
		driver.findElement(By.id("password-input")).sendKeys(password);
		driver.findElement(By.id("loginBtn")).click();
		
		driver.findElement(By.id("SettingBtn")).click();
		WebElement textFieldContent = driver.findElement(By.id("first-name-input"));
		
		if(textFieldContent.getAttribute("value").equals("Amine")) {
			driver.close();
			return true;	
		}
		return false;
	}
	
}
