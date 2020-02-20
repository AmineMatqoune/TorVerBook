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
		
	}
	
	public boolean logIn(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:5080");

		driver.findElement(By.id("username-input")).sendKeys(username);
		driver.findElement(By.id("password-input")).sendKeys(password);
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
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.setLocation(new Location(41.8542282, 12.62333329, 10));
		WebDriver driver = chromeDriver;
		driver.get("localhost:5080");

		final String username = "CptPackage";
		final String password = "A3bdalla";
		driver.findElement(By.id("username-input")).sendKeys(username);
		driver.findElement(By.id("password-input")).sendKeys(password);
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
