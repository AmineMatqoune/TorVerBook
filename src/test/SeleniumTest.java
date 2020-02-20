package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.Location;

import logic.ad.AdCategory;
import logic.ad.AdType;
import logic.highlight.HighlightType;
import torverbook.web.bean.AddAdBean;

public class SeleniumTest {
	/*
	 * Per far partire questo testcase è necessario avviare prima il server embedded
	 * locale TomCat in maniera tale da poter testare Selenium, altrimenti il sito
	 * risulta irraggiungibile
	 */
	private String webChromeDriver = "webdriver.chrome.driver";
	private String chromeDriverPath =  "driver/chromedriver.exe";
	private String site = "localhost:5080";
	private String usernameID = "username-input";
	private String passwordID = "password-input";
	
	
//	@Test
	public void testLogInSuccessfull() {
		assertEquals(true, logIn("Amine139", "amine.pwd"));
	}

//	@Test
	public void testAddAd() {
		AddAdBean adBean = new AddAdBean("Java Essentials", "The best book for java beginners.", 25, 5,
				AdCategory.COMPUTER_SCIENCE.toString(), AdType.SALE.toString());
		adBean.setHighlight(HighlightType.SUPER.toString());
		adBean.setStartHighlight(LocalDate.now());
		adBean.setEndHighlightDate(LocalDate.now().plusDays(10));
		assertEquals(true, addAd(adBean));
	}
	
	@Test
	public void testSignUp() {
		assertEquals(true, signUp("UtenteProva5"));
	}
	
	public boolean signUp(String username) {
		System.setProperty(webChromeDriver, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(site);
		driver.findElement(By.id("sign-up-btn")).click();
		driver.findElement(By.id("first-name-input")).sendKeys("PippoNome");
		driver.findElement(By.id("last-name-input")).sendKeys("PippoCognome");
		driver.findElement(By.id("email-input")).sendKeys("Pippo@email.it");
		driver.findElement(By.id(usernameID)).sendKeys(username);
		driver.findElement(By.id("phone-number-input")).sendKeys("0123456789");
		driver.findElement(By.id("birth-date-input")).sendKeys("03-03-2020");
		driver.findElement(By.id(passwordID)).sendKeys("123456");
		driver.findElement(By.id("password-confirm-input")).sendKeys("123456");
		driver.findElement(By.id("register-btn")).click();
		return true;
	}
	
	public boolean logIn(String username, String password) {
		System.setProperty(webChromeDriver, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(site);

		driver.findElement(By.id(usernameID)).sendKeys(username);
		driver.findElement(By.id(passwordID)).sendKeys(password);
		driver.findElement(By.id("login-btn")).click();

		driver.findElement(By.id("settings-btn")).click();
		WebElement textFieldContent = driver.findElement(By.id("first-name-input"));

		if (textFieldContent.getAttribute("value").equals("Amine")) {
			driver.close();
			return true;
		}
		return false;
	}

	public boolean addAd(AddAdBean adBean) {
		System.setProperty(webChromeDriver, chromeDriverPath);
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.setLocation(new Location(41.8542282, 12.62333329, 10));
		WebDriver driver = chromeDriver;
		driver.get(site);

		final String username = "CptPackage";
		final String password = "A3bdalla";
		driver.findElement(By.id(usernameID)).sendKeys(username);
		driver.findElement(By.id(passwordID)).sendKeys(password);
		driver.findElement(By.id("login-btn")).click();

		while (!driver.getCurrentUrl().contains("add-ad")) {
			driver.findElement(By.id("add-ad-btn")).click();
		}
		driver.findElement(By.id("ad-title-input")).sendKeys(adBean.getTitle());
		driver.findElement(By.id("ad-description-input")).sendKeys(adBean.getDescription());
		driver.findElement(By.id("ad-type-input")).sendKeys(adBean.getType());
		driver.findElement(By.id("ad-price-input")).sendKeys(String.valueOf(adBean.getPrice()));
		driver.findElement(By.id("ad-quantity-input")).sendKeys(String.valueOf(adBean.getQuantity()));
		driver.findElement(By.id("ad-category-input")).sendKeys(adBean.getCourse());
		driver.findElement(By.id("ad-highlight-input")).sendKeys(adBean.getHighlight());
		driver.findElement(By.id("ad-from-date-input")).sendKeys("03-03-2020");
		driver.findElement(By.id("ad-to-date-input")).sendKeys("04-04-2020");
		return false;
	}
}
