package com.jibe.kfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class KFCHome {

	WebDriver driver;
	
	By searchKeyword = By.className("advanced-search-keyword");
	By jobCategory = By.name("ac");
	By jobCity = By.name("City");
	By jobState = By.name("State");
	By jobSearchButton = By.xpath("/html/body/div/main/div[2]/form/div/div/button");
	
	/*
	 * Constructor
	 */
	public KFCHome (WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Get the page's title
	 */
	public String getTitle() {
		return driver.getTitle();
		
	}
	
	
	/*
	 * Set the search keyword
	 */
	public void setSearchKeyword(String keyword) {
		driver.findElement(searchKeyword).sendKeys(keyword);
	}
	
	/*
	 * Set the job category
	 */
	public void setJobCategory(String category) {
		Select stateDropList = new Select(driver.findElement(jobCategory));
		stateDropList.selectByVisibleText(category);
		
	}
	
	/*
	 * Set the city
	 */
	public void setJobCity(String city) {
		Select stateDropList = new Select(driver.findElement(jobCity));
		stateDropList.selectByVisibleText(city);
		
	}
	
	/**
	 * Set the state
	 */
	public void setJobState(String state) {
		Select stateDropList = new Select(driver.findElement(jobState));
		stateDropList.selectByVisibleText(state);
		
	}
	
	/**
	 * 
	 */
	public void clickSubmit() {
		driver.findElement(jobSearchButton).click();
	}
	
	/**
	 * Search for a job by entering keyboard, category, city and state
	 */
	public void searchJob(String keyword, String category, String city, String state) {
		this.setSearchKeyword(keyword);
		this.setJobCategory(category);
		this.setJobCity(city);
		this.setJobState(state);
		this.clickSubmit();
	}
	/**
	 * Search for a job using keyword only
	 * @param keyword
	 */
	public void searchJobKeyword(String keyword) {
		this.setSearchKeyword(keyword);
		this.clickSubmit();
	}
}

