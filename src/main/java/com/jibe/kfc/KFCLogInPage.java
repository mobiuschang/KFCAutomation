/**
 * 
 */
package com.jibe.kfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author winstonchang
 *
 */
public class KFCLogInPage {

	WebDriver driver;
	By body = By.tagName("body");
	
	/**
	 * Class constructor
	 * @param driver
	 */
	public KFCLogInPage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method returns the texts on the whole page
	 * @return texts of the whole page
	 */
	public String getPageTexts() {
		return driver.findElement(body).getText();
	}
	
	/**
	 * Enter user name in the login page
	 * @param username
	 */
	public void enterUsername(String usernames) {
	    driver.findElement((By.id("username"))).sendKeys(usernames);
	}
	
	/**
	 * Enter password in the login page
	 * @param password
	 */
	public void enterPassword(String passwords) {
		driver.findElement((By.id("password"))).sendKeys(passwords);
	}
	
	/**
	 * Click sumbit button
	 * Sleep for three seconds so the command can be processed
	 * @throws InterruptedException 
	 */
	public void clickLogInButton() {
		driver.findElement(By.name("submit")).click();
	}
	
	/**
	 * Click on specific link text
	 * @param linkText
	 */
	public void clickLinkText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
}
