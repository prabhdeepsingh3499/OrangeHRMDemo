package com.orangeHRM.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class PropertyReader {
	Properties properties = new Properties();
	InputStream inputStream = null;
	public static String getApplicationProperty(String propertyName) throws NullPointerException {
		Properties prop = new Properties();
		String propertyValue = "";
		try {
			InputStream inputStream = new FileInputStream(
					new File("./src/test/resources/environment.properties"));
			prop.load(inputStream);
			propertyValue = prop.getProperty(propertyName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			throw new NullPointerException(propertyName + "does not exist in Config file.");
		}
		return propertyValue;

	}


}
