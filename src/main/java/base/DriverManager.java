package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.net.URL;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {
    private static AndroidDriver driver;
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static void initializeDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options()
                        .setPlatformName("Android")
                        .setDeviceName(properties.getProperty("appiumDeviceName"))
                        .setPlatformVersion(properties.getProperty("appiumPlatformVersion"))
                        .setAppPackage(properties.getProperty("appiumAppPackage"))
                        .setAppActivity(properties.getProperty("appiumAppActivity"))
                        .setAutomationName("UiAutomator2")
                        .setNoReset(true)
                        .amend("autoAcceptAlerts", true);

                driver = new AndroidDriver(new URL(properties.getProperty("appiumURL")), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize Appium driver");
            }
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
