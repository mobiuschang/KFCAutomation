package com.jibe.kfc;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KFCHomeTest {

	KFCHome KFCHomePage;
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
	public void KFCHomePageCorrect() {
		KFCHomePage = new KFCHome(driver);
		assertTrue(KFCHomePage.getTitle().toLowerCase().contains("kfc apply"));
	}

}
