package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LoggerHelper {

	private static boolean root = false;
	
	public static Logger getLogger(Class clas) {
		if(root)
			return Logger.getLogger(clas);
		String log4jconfigfile = "E:\\Appium\\amazon\\src\\test\\resources\\log4j.properties";
		PropertyConfigurator.configure(log4jconfigfile);
		root = true;
		return Logger.getLogger(clas);
	}
}
