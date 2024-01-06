package com.orangeHRM.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangeHRM.utility.RandomData;
public class LeaveListPage {
	private WebDriver driver;
	public LeaveListPage(WebDriver driver) {
		this.driver = driver;
	}
	private By leaveList = By.xpath("//div[contains(@class,'card-item card-body')]");
	private By approve = By.xpath("//button[contains(@class,'success')]");
	private By clickApprove(int i) {
		return By.xpath("(//button[contains(@class,'success')])["+i+"]");
	}
	public int getListOfApplications() {
		List<WebElement> leaveListWeb = driver.findElements(leaveList);
		return leaveListWeb.size();
	}
	RandomData random = new RandomData();
	public void approveLeave() {
		List<WebElement> approveList = driver.findElements(approve);
		int randomElement = random.getRandomNumber(approveList.size());
		WebElement approve = driver.findElement(clickApprove(randomElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", approve);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", approve);
		
	}

}
