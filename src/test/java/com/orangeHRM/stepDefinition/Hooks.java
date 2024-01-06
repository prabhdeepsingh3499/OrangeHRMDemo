package com.orangeHRM.stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.orangeHRM.library.BaseClass;

import com.orangeHRM.utility.PropertyReader;
import com.orangeHRM.driver.DriverSetter;

public class Hooks extends BaseClass {
	private BaseClass base;
	DriverSetter driverSetter = new DriverSetter();
	LinkedHashMap<String,String> testCases;
	Scenario scenario;
	public Hooks(BaseClass base) {
		this.base = base;
	}

	@Before
	public void initDriver(Scenario scenario) throws IOException  {
		DriverSetter driverSetter = new DriverSetter();
		base.driver = driverSetter.setDriver(PropertyReader.getApplicationProperty("browser"));
		this.scenario = scenario;
		base.scenario = scenario;
		base.testID = scenario.getName();

	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image"); 
			System.out.println("Status: Fail");
		} else {
			final byte[] screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image"); 
			System.out.println("Status: Pass");
		}
		base.driver.quit();
	}

}
