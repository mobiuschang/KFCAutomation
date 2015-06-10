/**
 * 
 */
package com.jibe.kfc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author winstonchang
 *
 */
public class CreateNewAccountPage {

	WebDriver driver;
	By username = By.name("username");
	By password = By.name("password");
	By confirmPassword = By.name("confirmPassword");
	By securityQuestion = By.name("securityQuestion");
	By securityAnswer = By.name("securityAnswer");
	By body = By.tagName("body");
	By submitButton = By.name("submit");
	
	/**
	 * Class constructor
	 * @param driver
	 */
	public CreateNewAccountPage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Enter user name
	 * @param userNameString
	 */
	public void enterUserName(String userNameString) {
		driver.findElement(username).sendKeys(userNameString);
	}
	
	/**
	 * Enter password
	 * @param passwordString
	 */
	public void enterPassword(String passwordString) {
		driver.findElement(password).sendKeys(passwordString);
	}
	
	/**
	 * Enter same password again to confirm
	 * @param passwordString
	 */
	public void enterConfirmPassword(String passwordString) {
		driver.findElement(confirmPassword).sendKeys(passwordString);
	}
	
	/**
	 * Enter security answer
	 * @param securityAnswerString
	 */
	public void enterSecurityAnswer(String securityAnswerString) {
		driver.findElement(securityAnswer).sendKeys(securityAnswerString);
	}
	
	/**
	 * Pick a security question from the drop down
	 * @param questionString
	 */
	public void selectSecruityQuestion (String questionString) {
		Select stateDropList = new Select(driver.findElement(securityQuestion));
		stateDropList.selectByVisibleText(questionString);
	}

	/**
	 * This method returns the texts on the whole page
	 * @return texts of the whole page
	 */
	public String getPageTexts() {
		return driver.findElement(By.tagName("body")).getText();
	}
	
	/**
	 * Click submit button
	 */
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
}
