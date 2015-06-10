/**
 * 
 */
package com.jibe.kfc;


import com.thoughtworks.selenium.Selenium;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author winstonchang
 *
 */
public class ScreenshotTestRule implements MethodRule {
	WebDriver driver;
	

	  public void takeScreen(Throwable e, Description test){
	      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	      try {
	          FileUtils.copyFile(scrFile, new File("/Users/winstonchang/documents/Selenium_Screenshots/" + test.getMethodName() + timeStamp + ".png"));
	      } catch (IOException e1) {
	          e1.printStackTrace();
	      }
	  }


	/* (non-Javadoc)
	 * @see org.junit.rules.MethodRule#apply(org.junit.runners.model.Statement, org.junit.runners.model.FrameworkMethod, java.lang.Object)
	 */
	  public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
	        return new Statement() {
	            @Override
	            public void evaluate() throws Throwable {
	                try {
	                    statement.evaluate();
	                } catch (Throwable t) {
	                    captureScreenshot(frameworkMethod.getName());
	                    throw t; // rethrow to allow the failure to be reported to JUnit
	                }
	            }

				private void captureScreenshot(String name) {
					// TODO Auto-generated method stub
					
				}
	        };
	  }
}
