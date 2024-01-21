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
import com.orangeHRM.pages.LeaveListPage;
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
	LeaveListPage leaveListPage;
	public StepDefinition(BaseClass base) {
		this.base =base;
		this.driver = base.driver;
		this.scenario = base.scenario;
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashboardPage(driver);
		employeeInformationPage = new EmployeeInformationPage(driver);
		common = new Common(driver);
		addEmployeePage = new AddEmployeePage(driver);
		leaveListPage = new LeaveListPage(driver);
	}
	@Given("Login page is Displayed")
	public void is_login_page_displayed() {
		try {
			if(loginPage.isLoginPageDisplayed()) {
				scenario.log("Login page is displayed");
			}
			else {
				throw new RuntimeException("Login page is not displayed");
			}
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
			if(loginPage.isErrorDisplayed()) {
				scenario.log("Login page error is displayed");
			}
			else {
				throw new RuntimeException("Login page error is not displayed");
			}
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
	@Then("Validate Header Title of Page is {string}")
	public void check_header_title_page(String page) {
		try {
				common.waitForPageLoadersInvisible();
				if(common.checkHeaderDisplayed(page)) {
					scenario.log("Header title of page is:"+page);
				}
				else {
					throw new RuntimeException("Header title of page is not:"+page);
				}
		}
		catch(Exception e) {
		 throw new RuntimeException(e.getMessage());
		}
	}
	@Then("Validate Main Title of Page is {string}")
	public void check_main_title_page(String page) {
		try {
				common.waitForPageLoadersInvisible();
				if(common.checkMainTitleDisplayed(page)) {
					scenario.log("Main title of page is:"+page);
				}
				else {
					throw new RuntimeException("Main title of page is not:"+page);
				}
		}
		catch(Exception e) {
		 throw new RuntimeException(e.getMessage());
		}
	}
	@Then("Validate Title of Table is {string}")
	public void check_table_title(String page) {
		try {
				common.waitForPageLoadersInvisible();
				if(common.checkTableTitleDisplayed(page)) {
					scenario.log("Table title of page is:"+page);
				}
				else {
					throw new RuntimeException("Table title of page is not:"+page);
				}
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
			if(common.checkSuccessMessage()) {
				scenario.log("Success message is displayed");
			}
			else {
				throw new RuntimeException("Success message is not displayed");
			}
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
			if(common.checkConfirmationPopup()) {
				scenario.log("Confirmation popup is displayed");
			}
			else {
				throw new RuntimeException("Confirmation popup is not displayed");
			}
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
	@And("Validate Leave Applications are Displayed")
	public void validate_leave_application() {
		try {
			int size = leaveListPage.getListOfApplications();
			if(size==0) {
				throw new RuntimeException("No leave applications");
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@When("User clicks on Approve")
	public void approve_leave_application() {
		try {
			leaveListPage.approveLeave();
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
