package com.orangeHRM.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.orangeHRM.utility.RandomData;

public class EmployeeInformationPage {
	private WebDriver driver;
	public EmployeeInformationPage(WebDriver driver) {
		this.driver = driver;
	}
	private By addButton = By.xpath("//i[contains(@class,'plus')]/ancestor::button");
	private By deleteButton = By.xpath("//i[contains(@class,'trash')]/ancestor::button");
	private By clickDelete(int i) {
		return By.xpath("(//i[contains(@class,'trash')]/ancestor::button)["+i+"]");
	}
	RandomData random = new RandomData();
	public void clickAdd() {
		driver.findElement(addButton).click();
		
	}
	public void clickDelete() {
		List<WebElement> deleteList = driver.findElements(deleteButton);
		int randomElement = random.getRandomNumber(deleteList.size());
		WebElement delete = driver.findElement(clickDelete(randomElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", delete);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);
		
		
	}
}
