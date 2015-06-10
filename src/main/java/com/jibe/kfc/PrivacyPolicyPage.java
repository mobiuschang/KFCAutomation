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
public class PrivacyPolicyPage {

	WebDriver driver;
	By body = By.tagName("body");
	
	/**
	 * Class constructor
	 * @param driver
	 */
	public PrivacyPolicyPage (WebDriver driver) {
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
	 * Click Agree button on the Privacy Policy page
	 */
	public void clickAgreeButton() {
		driver.findElement(By.xpath("//*[@id=\"content-root\"]/div[2]/div[2]/div[1]/button")).click();
	}
	
	/**
	 * Click Agree button on the Privacy Policy page
	 */
	public void clickDisagreeButton() {
		driver.findElement(By.xpath("//*[@id=\"content-root\"]/div[2]/div[2]/div[2]/button")).click();
	}
}
	