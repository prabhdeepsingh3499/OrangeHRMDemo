package com.orangeHRM.testRunner;

import java.util.Iterator;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.orangeHRM.customTests.CustomAbstractTestNGCucumberTests;
import com.orangeHRM.utility.PropertyReader;

import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = ".//feature",
		glue = {"com.orangeHRM.stepDefinition"},
		dryRun = false,
		monochrome = true,
		plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		}
)
public class TestRunner extends CustomAbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Iterator<Object[]> scenarios() {
		return super.scenarios();
	}	

	@BeforeSuite
	public void setProperty() {
		System.setProperty("TagName", PropertyReader.getApplicationProperty("tagName"));
	}


}
