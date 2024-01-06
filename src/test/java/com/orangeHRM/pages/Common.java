package com.orangeHRM.pages;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Common {
	private WebDriver driver;
	public Common(WebDriver driver) {
		this.driver = driver;
	}
	private By headerHeading(String pageheading) {
		return By.xpath("//h6[text()='"+pageheading+"']");
	}
	private By mainTitleHeading(String pageheading) {
		return By.xpath("//h6[text()='"+pageheading+"']");
	}
	private By tableHeading(String pageheading) {
		return By.xpath("//h5[text()='"+pageheading+"']");
	}
	private By successMessage = By.xpath("//i[contains(@class,'check')]");
	private By pageLoad = By.xpath("//div[contains(@class,'oxd-table-loader')]");
	private By deleteButton = By.xpath("//button[contains(@class,'danger')]");

	public boolean checkSuccessMessage() {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		if(message.isDisplayed()){
			return true;
		}
		else {
			throw new RuntimeException("Success message is not displayed");
		}
		
	}
	public boolean waitForPageLoadersInvisible() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        boolean present = wait
		                .ignoring(StaleElementReferenceException.class)
		                .ignoring(NoSuchElementException.class)
		                .until(ExpectedConditions.invisibilityOfElementLocated(pageLoad));

		        return present;
		    } catch (Exception e) {
		        return false;
		    } finally {
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    }
		
	}
	public void checkConfirmationPopup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
		
	}
	public void clickDelete() {
		driver.findElement(deleteButton).click();
		
	}
	public boolean checkHeaderDisplayed(String heading) {
		//waitForPageLoadersInvisible();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		WebElement pageHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(headerHeading(heading)));
		if(pageHeading.isDisplayed()) {
			return true;
		}
		else {
			throw new RuntimeException("page is not displayed");
		}
		
	}
	public boolean checkMainTitleDisplayed(String heading) {
		//waitForPageLoadersInvisible();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		WebElement pageHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(mainTitleHeading(heading)));
		if(pageHeading.isDisplayed()) {
			return true;
		}
		else {
			throw new RuntimeException("page is not displayed");
		}
		
	}
	public boolean checkTableTitleDisplayed(String page) {
		//waitForPageLoadersInvisible();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
		WebElement tableHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(tableHeading(page)));
		if(tableHeading.isDisplayed()) {
			return true;
		}
		else {
			throw new RuntimeException("page is not displayed");
		}
		
	}
}
