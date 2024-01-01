package com.orangeHRM.stepDefinition;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import com.orangeHRM.driver.DriverSetter;
import com.orangeHRM.library.BaseClass;
import com.orangeHRM.utility.PropertyReader;



import com.orangeHRM.pages.DashboardPage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.EmployeeInformationPage;
import com.orangeHRM.pages.Common;
import com.orangeHRM.pages.AddEmployeePage;
public class StepDefinition extends BaseClass {
	private BaseClass base;
	private WebDriver driver;
	private Scenario scenario;

	DriverSetter driverSetter;
	PropertyReader prReader = new PropertyReader();
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	EmployeeInformationPage employeeInformationPage;
	AddEmployeePage addEmployeePage;
	Common common;
	public StepDefinition(BaseClass base) {
		this.base =base;
		this.driver = base.driver;
		this.scenario = base.scenario;
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashboardPage(driver);
		employeeInformationPage = new EmployeeInformationPage(driver);
		common = new Common(driver);
		addEmployeePage = new AddEmployeePage(driver);
	}
	@Given("Login page is Displayed")
	public void is_login_page_displayed() {
		try {
			loginPage.isLoginPageDisplayed();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@When("User enters {string} and {string}")
	public void enter_username_password(String username,String password) {
		try {
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@And("Clicks on Login")
	public void click_login() {
		try {
			loginPage.clickLogin();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Then("Invalid Credentials Error is Displayed")
	public void is_error_displayed() {
		try {
			loginPage.isErrorDisplayed();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@When("User Select {string} from Main Menu")
	public void select_option(String option) {
		try {
			dashBoardPage.selectOption(option);
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Then("{string} Page is Displayed")
	public void check_page(String page) {
		try {
				common.waitForPageLoadersInvisible();
				common.checkPageDisplayed(page);
		}
		catch(Exception e) {
		 throw new RuntimeException(e.getMessage());
		}
	}
	@When("User clicks on Add")
	public void click_add() {
		try {
			employeeInformationPage.clickAdd();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@When("User enter Employee Information")
	public void enter_employee_information() {
		try {
			addEmployeePage.enterEmployeeInformation();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@And("User Submit Employee Information")
	public void submit_employee_information() {
		try {
			addEmployeePage.clickSave();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Then("Success Message is Displayed")
	public void check_success_message() {
		try {
			common.checkSuccessMessage();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@When("User clicks on Delete button")
	public void click_delete_button() {
		try {
			employeeInformationPage.clickDelete();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Then("Confirmation Popup is Displayed")
	public void check_confirmation_popup() {
		try {
			common.checkConfirmationPopup();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@When("User confirms Deletion")
	public void click_delete() {
		try {
			common.clickDelete();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
