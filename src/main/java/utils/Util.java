package utils;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import base.DriverManager;
import pages.LoginPage;

public class Util {

    private static Properties properties = new Properties();
    private static final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream captureOut = new PrintStream(consoleOutput);
    private static LoginPage login ; 
    private static final Logger logger = LogManager.getLogger(Util.class);
    private static boolean isLoggedIn = false;

    static {
        loadProperties();
    }

    /**
     * Loads properties from extent.properties file.
     */
    private static void loadProperties() {
        try (InputStream input = Util.class.getClassLoader().getResourceAsStream("extent.properties")) {
            if (input == null) {
                System.err.println("Unable to find extent.properties");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a property value from extent.properties.
     * @param key The property key.
     * @return The property value, or null if not found.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Retrieves a property value with a default if the key is not found.
     * @param key The property key.
     * @param defaultValue Default value if the key is missing.
     * @return The property value or defaultValue.
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Starts capturing console output.
     */
    public static void startConsoleCapture() {
        System.setOut(captureOut);
    }

    /**
     * Stops capturing console output and returns the captured content.
     * @return The captured console output.
     */
    public static String stopConsoleCapture() {
        System.setOut(originalOut);  // Restore original System.out
        return consoleOutput.toString();
    }

    /**
     * Clears captured console output for fresh capture in the next test.
     */
    public static void clearConsoleOutput() {
        consoleOutput.reset();
    }
    
    public static void performLogin(WebDriver driver) {
        // Replace with your actual login flow using driver + page objects
        System.out.println("Performing login through QR");
        if (!isLoggedIn) {
        DriverManager.initializeDriver();
	     login = new LoginPage(DriverManager.getDriver());
			login.onboardingSkip();
 logger.info("Click on skip button");
			//login.picPermission();
			 login.uploadQRBtn();
			 logger.info("click on upload file ");
			    login.album();
			 login.tapOnQRImage();
			    login.securityPin();
			    login.loginBtn();
			    logger.info("Home page");
			    isLoggedIn = true;
        } 
        
    }
}
