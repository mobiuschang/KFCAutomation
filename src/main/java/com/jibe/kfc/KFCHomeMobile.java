/**
 * 
 */
package com.jibe.kfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author winstonchang
 *
 */
public class KFCHomeMobile {

	WebDriver driver;
	//Default mobile job search field. Users click on this field to bring up hidden fields (location and submit button)
	By jobSearchMobileField = By.xpath("//*[@id=\"MobileSearchEntrance\"]/input");
	
	/*
	 * Job search field after users have clicked on the default mobile search field
	 * This is different from the default mobile search field
	 */
	By jobSearchField = By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/input");
	By jobLocation = By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div/div/div/input");
	By submitButton = By.xpath("//*[@id=\"page\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[5]/div/button");
	
	/**
	 * Class constructor
	 * @param driver
	 */
	public KFCHomeMobile (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 
	 * @return title of the page
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method returns the texts on the whole page
	 * @return texts of the whole page
	 */
	public String getPageTexts() {
		return driver.findElement(By.tagName("body")).getText();
	}

	/**
	 * Click on the Search text field to make other fields (location, submit button) visible
	 * The location and click button are invisible by default
	 * Currently only KFC career portal behaves this way. 
	 * Can refactor this method if other career portals have this same behavior
	 */
	public void clickSearchField() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(jobSearchMobileField)).perform();
		driver.findElement(jobSearchMobileField).click(); 
	}
	
	/**
	 * Enter specific job key term
	 * @param jobKeyword
	 */
	public void setJobSearchKeyword (String jobKeyword) {
		clickSearchField();
		driver.findElement(jobSearchField).sendKeys(jobKeyword);
	}
	
	/**
	 * Enter job location
	 * @param location
	 */
	public void setJobLocation (String location) {
		driver.findElement(jobLocation).clear();
		driver.findElement(jobLocation).sendKeys(location);
	}
	
	/**
	 * Click the Sumbit button
	 */
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
	
	/**
	 * Click on a specific job in the job results page
	 * @param jobTitle
	 */
	public void clickOnFirstJob () {
		driver.findElement(By.cssSelector("#page > div > div.all-content > div.main-content.jobSearch.ng-scope > div.search-results.ng-scope > span:nth-child(2) > div:nth-child(2) > table > tbody > tr:nth-child(1) > td.job-title > a.absolute-fill.visible-xs.ng-scope")).click();
	}
	
	/**
	 * Search for jobs using the keyword search only. No location
	 * @param jobKeyword
	 */
	public void searchJobKeyword (String jobKeyword) {
		this.setJobSearchKeyword(jobKeyword);
		this.clickSubmit();
		
	}
	
	/**
	 * Search for jobs using both keyword and location search
	 * @param jobKeyword
	 * @param location
	 */
	public void searchJobKeywordLocation (String jobKeyword, String location) {
		this.setJobSearchKeyword(jobKeyword);
		this.setJobLocation(location);
		this.clickSubmit();
	}
	
}
