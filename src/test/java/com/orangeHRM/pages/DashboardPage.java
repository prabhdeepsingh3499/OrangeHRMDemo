package com.orangeHRM.pages;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.utility.LoggerHelper;
public class DashboardPage {
	private WebDriver driver;
	private Logger logger = LoggerHelper.getLogger(this.getClass());
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	private By selectMenuOption(String option) {
		return By.xpath("//span[text()='"+option+"']/ancestor::a");
	}
	public void selectOption(String option) {
		driver.findElement(selectMenuOption(option)).click();
		logger.info(option+"is clicked successfully");
		
	}
}
