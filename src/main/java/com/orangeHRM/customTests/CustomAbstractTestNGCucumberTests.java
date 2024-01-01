package com.orangeHRM.customTests;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class CustomAbstractTestNGCucumberTests {
	private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios",dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper,FeatureWrapper featureWrapper) {
    	 testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }

    @DataProvider
    public Iterator<Object[]> scenarios() {
    	ArrayList<Object[]> modifiedList = new ArrayList<>();
        if (testNGCucumberRunner == null) {
            return modifiedList.iterator();
        }
        
        modifiedList = filterTheFeature(testNGCucumberRunner.provideScenarios());
        return modifiedList.iterator();
    }
    private ArrayList<Object[]> filterTheFeature(Object[][] data){
    	String tagValue = System.getProperty("TagName");
    	if(tagValue == null || tagValue.isEmpty()) {
    		return getFeatureList(data);
    	}
    	
    	List<String> tagList = Arrays.asList(tagValue.split(","));
    	ArrayList<Object[]> modifiedList = new ArrayList<>();
    	
    	if(data!=null) {
    		for(int i = 0; i < data.length; i++) {
    			PickleWrapper pickleWrapper = (PickleWrapper)data[i][0];
    			if(!pickleWrapper.getPickle().getTags().isEmpty()) {
    				for(String aTag : tagList) {
    					if(isTagPresent(aTag, pickleWrapper.getPickle().getTags())) {
    						modifiedList.add(data[i]);
    					}
    				}
    			}
    		}
    	}
    	return modifiedList;
    }
    
    private boolean isTagPresent(String aTag, List<String> aTagList) {
    	for(String tag : aTagList) {
    		if(aTag.equalsIgnoreCase(tag)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private ArrayList<Object[]> getFeatureList(Object[][] data){
    	ArrayList<Object[]> modifiedList = new ArrayList<>();
    	if(data != null) {
    		for(int i = 0; i < data.length; i++) {
    			modifiedList.add(data[i]);
    		}
    	}
    	return modifiedList;
    }

}
