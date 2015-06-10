package com.jibe.kfc;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * @author winstonchang
 *
 */
public class PrivacyPolicyTest {

	KFCHomeMobile KFCHomePage;
	KFCJobDetails KFCJobDetailsPage;
	KFCLogInPage KFCLogInPage;
	PrivacyPolicyPage PrivacyPolicyPage;
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setup() throws InterruptedException {
		driver.manage().window().setSize(new Dimension(432,595));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://kfc.staging.jibeapply.com/");
		
		KFCHomePage = new KFCHomeMobile(driver);
		KFCJobDetailsPage = new KFCJobDetails(driver);
		KFCLogInPage = new KFCLogInPage(driver);
		PrivacyPolicyPage = new PrivacyPolicyPage(driver);
		
		KFCHomePage.searchJobKeywordLocation("general manager", "North Carolina");
		Thread.sleep(3000);
		KFCHomePage.clickOnFirstJob();
		KFCJobDetailsPage.clickApplyButton();
		Thread.sleep(3000);
		KFCLogInPage.clickLinkText("Create One");
	}
	
	@After
	public void tearDown() throws IOException {
		driver.quit();
	}
	
	@Rule
	public TestRule testWatcher = new TestWatcher() {
	  @Override
	  public void failed(Throwable e, Description test){
	      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	      try {
	          FileUtils.copyFile(scrFile, new File("/Users/winstonchang/documents/Selenium_Screenshots/" + test.getMethodName() + timeStamp + ".png"));
	      } catch (IOException e1) {
	          e1.printStackTrace();
	      }
	  }
	};
		
	@Test
	public void PrivacyPolicyAgreeTest() {
		PrivacyPolicyPage.clickAgreeButton();
		assertTrue(PrivacyPolicyPage.getPageTexts().contains("Security Question"));
	}
	
	@Test
	public void PrivacyPolicyDisagreeTest() {
		PrivacyPolicyPage.clickDisagreeButton();
		assertTrue(PrivacyPolicyPage.getPageTexts().contains("Login"));
	}
}