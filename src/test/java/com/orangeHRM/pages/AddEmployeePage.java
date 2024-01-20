package com.orangeHRM.pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.utility.LoggerHelper;
import com.orangeHRM.utility.RandomData;
public class AddEmployeePage {
	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(this.getClass());
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}
	private By firstName = By.name("firstName");
	private By lastName = By.name("lastName");
	private By save = By.xpath("//button[@type='submit']");
	public void enterEmployeeInformation() {
		RandomData random = new RandomData();
		driver.findElement(firstName).sendKeys(random.getFirstName());
		driver.findElement(lastName).sendKeys(random.getLastName());
		logger.info("Employee name details entered");
	}
	public void clickSave() {
		driver.findElement(save).click();
		logger.info("Save button clicked successfully");
	}

}
