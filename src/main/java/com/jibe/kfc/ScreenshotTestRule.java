/**
 * 
 */
package com.jibe.kfc;


import com.thoughtworks.selenium.Selenium;
import java.io.File;
import java.io.FileOutputStream;
import org.junit.rules.MethodRule;
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
	
	private static WebDriver driver;
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

            public void captureScreenshot(String fileName) {
                try {
                    new File("target/surefire-reports/").mkdirs(); // Insure directory is there
                    FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
                    out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                    out.close();
                } catch (Exception e) {
                    // No need to crash the tests if the screenshot fails
                }
            }
        };
    }
}
