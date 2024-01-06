package com.orangeHRM.reporter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class CreateReport {
	@SuppressWarnings("rawtypes")
	static Map extentTestMap = new HashMap();
    private static ExtentReports extent = getReporter();
    private static ExtentSparkReporter  sparkReporter;

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
    public static synchronized ExtentTest startTest(String testName) {
        return startTest(testName, "");
    }
    public static synchronized void endTest() {
        endTest();
    }
    @SuppressWarnings("unchecked")
	public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    public synchronized static ExtentReports getReporter(String filePath) throws IOException {
		if (sparkReporter == null) {
        	sparkReporter = new ExtentSparkReporter(new File(filePath));
        	sparkReporter.loadXMLConfig(new File("src/main/resources/ExtentConfig.xml").getAbsolutePath());
            extent = new ExtentReports();
            extent.setSystemInfo("Execution Browser", System.getProperty("browser"));
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
    
    public synchronized static ExtentReports getReporter() {
        return extent;
    }
    
}
