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
public class KFCJobSearchTest {

	KFCHomeMobile KFCHomePage;
	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(432,595));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://kfc.staging.jibeapply.com/");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void SearchJobKeywordOnly () {
		KFCHomePage = new KFCHomeMobile(driver);
		KFCHomePage.searchJobKeyword("member");
		assertTrue(KFCHomePage.getPageTexts().contains("Team Member"));
		

	}

}
