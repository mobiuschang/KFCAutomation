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
public class KFCJobDetails {

	WebDriver driver;
	
	
	/**
	 * Class constructor
	 * @param driver
	 */
	public KFCJobDetails (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method returns the texts on the whole page
	 * @return texts of the whole page
	 */
	public String getPageTexts() {
		return driver.findElement(By.tagName("body")).getText(); 
	}
	
	/**
	 * Click on the Apply button
	 */
	public void clickApplyButton() {
		driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div[3]/a")).click();
	}
	
	/**
	 * Enter user name in the login page
	 * @param username
	 */
	public void enterUsername(String usernames) {
	    driver.findElement((By.id("username"))).sendKeys(usernames);
	}
}