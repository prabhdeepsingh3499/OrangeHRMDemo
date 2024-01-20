package com.orangeHRM.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.utility.LoggerHelper;

public class LoginPage {
	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(this.getClass());
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	private By username = By.name("username");
	private By password = By.name("password");
	private By submit = By.xpath("//button[contains(@class,'oxd-button')]");
	private By error = By.xpath("//div[@class='orangehrm-login-error']//p[contains(@class,'alert-content')]");
	public boolean isLoginPageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submit));
		if(button.isDisplayed()) {
			logger.debug("Login page is displayed");
			return true;
		}
		else {
			logger.error("Login page is not displayed");
			throw new RuntimeException("Login page is not displayed");
		}
		
	}
	public void enterUsername(String userName) {
		driver.findElement(username).sendKeys(userName);	
		logger.debug("User entered username");
	}
	public void enterPassword(String passWord) {
		driver.findElement(password).sendKeys(passWord);
		logger.debug("User entered password");
		
	}
	public void clickLogin() {
		driver.findElement(submit).click();
		logger.debug("Login button clicked successfully");
		
	}
	public boolean isErrorDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(error));
		if(message.isDisplayed()) {
			return true;
		}
		else {
			logger.error("Invalid Login error is not displayed");
			throw new RuntimeException("Invalid Login error is not displayed");
		}
		
	}
	

}
