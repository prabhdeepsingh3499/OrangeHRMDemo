package com.orangeHRM.utility;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class LoggerHelper {
	private static boolean root = false;

	@SuppressWarnings("rawtypes")
	public synchronized static Logger getLogger(Class clas) {
		if (root) {
			return LogManager.getLogger(clas);
		}
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
		File file = new File("src/main/resources/Log4j2.xml");
		context.setConfigLocation(file.toURI());
		root = true;
		return LogManager.getLogger(clas);
	}

}
