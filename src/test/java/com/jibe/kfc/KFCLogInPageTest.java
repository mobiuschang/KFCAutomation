package com.jibe.kfc;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author winstonchang
 *
 */
public class KFCLogInPageTest {

	KFCHomeMobile KFCHomePage;
	KFCJobDetails KFCJobDetailsPage;
	KFCLogInPage KFCLogInPage;
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setup() throws InterruptedException {
		driver.manage().window().setSize(new Dimension(432,595));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://kfc.staging.jibeapply.com/");
		
		KFCHomePage = new KFCHomeMobile(driver);
		KFCJobDetailsPage = new KFCJobDetails(driver);
		KFCLogInPage = new KFCLogInPage(driver);
		
		KFCHomePage.searchJobKeywordLocation("general manager", "North Carolina");
		Thread.sleep(3000);
		KFCHomePage.clickOnFirstJob();
		KFCJobDetailsPage.clickApplyButton();
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void UsernameOnlyLogInFail() throws InterruptedException {
		KFCLogInPage.enterUsername("flyingsaucer");
		KFCLogInPage.clickLogInButton();
		Thread.sleep(3000);
		assertTrue(KFCLogInPage.getPageTexts().contains("This field is required"));
	}
	
	@Test
	public void PasswordOnlyLogInFail() throws InterruptedException {

		KFCLogInPage.enterPassword("flyingsaucer");
		KFCLogInPage.clickLogInButton();
		Thread.sleep(3000);
		assertTrue(KFCLogInPage.getPageTexts().contains("This field is required"));
	}
	
	@Test
	public void InvalidUser() throws InterruptedException {

		KFCLogInPage.enterUsername("flyingsaucer");
		KFCLogInPage.enterPassword("flyingsaucer");
		KFCLogInPage.clickLogInButton();
		Thread.sleep(3000);
		assertTrue(KFCLogInPage.getPageTexts().contains("Invalid Username / Password Combination"));
	}
	
	@Test
	public void CreateNewAccount() throws InterruptedException {
		KFCLogInPage.clickLinkText("Create One");
		Thread.sleep(3000);
		assertTrue(KFCLogInPage.getPageTexts().contains("Privacy Policy"));
	}
	
	@Test
	public void ClickForgotYourPassword() throws InterruptedException {
		KFCLogInPage.clickLinkText("Forgot your password?");
		Thread.sleep(3000);
		assertTrue(KFCLogInPage.getPageTexts().contains("Password Recovery"));
	}
}