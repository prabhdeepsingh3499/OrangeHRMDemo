package com.orangeHRM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.orangeHRM.utility.RandomData;
public class AddEmployeePage {
	private WebDriver driver;
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
	}
	public void clickSave() {
		driver.findElement(save).click();
	}

}
