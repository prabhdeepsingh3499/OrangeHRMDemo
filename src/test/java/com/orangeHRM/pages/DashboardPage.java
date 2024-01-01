package com.orangeHRM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashboardPage {
	private WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	private By selectMenuOption(String option) {
		return By.xpath("//span[text()='"+option+"']/ancestor::a");
	}
	public void selectOption(String option) {
		// TODO Auto-generated method stub
		driver.findElement(selectMenuOption(option)).click();
		
	}
}
