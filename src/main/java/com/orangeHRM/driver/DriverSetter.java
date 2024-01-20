package com.orangeHRM.driver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.orangeHRM.utility.PropertyReader;
import com.orangeHRM.utility.LoggerHelper;
public class DriverSetter {
	private Logger logger = LoggerHelper.getLogger(this.getClass());
	protected WebDriver driver=null;
	PropertyReader prReader = new PropertyReader();
	private String appURL = PropertyReader.getApplicationProperty("baseURL");
	 public WebDriver setDriver(String browserType){
			switch (browserType.toLowerCase()){
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Setting Chrome Driver");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Setting Firefox Driver");
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Setting Edge Driver");
				break;
			default:
				System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			if(PropertyReader.getApplicationProperty("maximizeBrowser").equalsIgnoreCase("true")) {
				driver.manage().window().maximize();
			}
			driver.get(appURL);
			logger.info("Opening website");
			return driver;
		}
}
