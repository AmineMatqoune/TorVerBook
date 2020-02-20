package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.ad.AdCategory;
import logic.ad.AdType;
import logic.dao.AccountDAO;
import logic.exceptions.InvalidCredentialsException;
import logic.highlight.HighlightType;
import torverbook.web.bean.AddAdBean;

public class SeleniumTest {
	/*
	 * Per far partire questo testcase è necessario avviare prima il server embedded
	 * locale TomCat in maniera tale da poter testare Selenium, altrimenti il sito
	 * risulta irraggiungibile
	 */
	private String webChromeDriver = "webdriver.chrome.driver";
	private String chromeDriverPath = "driver/chromedriver.exe";
	private String site = "localhost:5080";
	private String usernameID = "username-input";
	private String passwordID = "password-input";

	@Test
	public void testLogInSuccessfull() {
		assertEquals(true, logIn("Amine139", "amine.pwd"));
	}

	@Test
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
		Random random = new Random(85);
		String trimmedRandomString = String.valueOf(random.nextInt()).substring(1, 6);
		String generatedEmail = "Pippone" + trimmedRandomString + "@gmail.com";
		assertEquals(true, signUp("UtenteProva" + trimmedRandomString, generatedEmail));
	}

	public boolean signUp(String username, String email) {
		System.setProperty(webChromeDriver, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		String tmpPW = "12345688";
		driver.get(site);
		while (!driver.getCurrentUrl().contains("signup")) {
			driver.findElement(By.id("sign-up-btn")).click();
		}
		driver.findElement(By.id("first-name-input")).sendKeys("PippoNome");
		driver.findElement(By.id("last-name-input")).sendKeys("PippoCognome");
		driver.findElement(By.id("email-input")).sendKeys(email);
		driver.findElement(By.id(usernameID)).sendKeys(username);
		driver.findElement(By.id("phone-number-input")).sendKeys("0123456789");
		driver.findElement(By.id("birth-date-input")).sendKeys("07-02-1997");
		driver.findElement(By.id(passwordID)).sendKeys(tmpPW);
		driver.findElement(By.id("password-confirm-input")).sendKeys(tmpPW);
		driver.findElement(By.id("register-btn")).click();
		boolean registered = false;
		try {
			registered = AccountDAO.getInstance().logIn(username, tmpPW);
		} catch (SQLException | ParseException | InvalidCredentialsException e) {
			Logger.getLogger("Sel").warning(e.getMessage());
		}
		return registered;
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
		WebDriver driver = new ChromeDriver();
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
		driver.findElement(By.id("add-new-ad-btn")).click();
		while (!driver.getCurrentUrl().contains("personal-ads")) {
			driver.findElement(By.id("my-ads-btn")).click();
		}

		List<WebElement> titles = driver.findElement(By.className("ads-container")).findElements(By.className("title"));
		List<WebElement> descs = driver.findElement(By.className("ads-container"))
				.findElements(By.className("description"));

		for (int i = 0; i < titles.size(); i++) {
			if (titles.get(i).getText().contains(adBean.getTitle())
					&& descs.get(i).getText().contains(adBean.getDescription())) {
				driver.close();
				return true;
			}
		}
		return false;
	}
}
