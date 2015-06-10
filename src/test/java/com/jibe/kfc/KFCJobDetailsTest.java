/**
 * 
 */
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
public class KFCJobDetailsTest {

	KFCHomeMobile KFCHomePage;
	KFCJobDetails KFCJobDetailsPage;
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(432,595));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://kfc.staging.jibeapply.com/");
		
		KFCHomePage = new KFCHomeMobile(driver);
		KFCJobDetailsPage = new KFCJobDetails(driver);
		
		KFCHomePage.searchJobKeywordLocation("general manager", "North Carolina");
		KFCHomePage.clickOnFirstJob();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void JobDetailsPageCorrect() {
		KFCJobDetailsPage = new KFCJobDetails(driver);
		assertTrue(KFCJobDetailsPage.getPageTexts().contains("Job Description"));
	}
	
	@Test
	public void ApplyFromJobDetailsSuccess() throws InterruptedException {
		KFCJobDetailsPage.clickApplyButton();
		Thread.sleep(5000);
		assertTrue(KFCJobDetailsPage.getPageTexts().contains("Login"));
	}
	
	
}
