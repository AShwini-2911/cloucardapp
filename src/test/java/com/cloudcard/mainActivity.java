//test program

//package com.cloudcard;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.android.AndroidDriver;
//
//public class mainActivity {
//
//	
//	public static void main(String[] args) {
//        AndroidDriver driver = null;
//
//        try {
//            // Set desired capabilities
//            DesiredCapabilities dc = new DesiredCapabilities();
//            dc.setCapability("platformName", "Android"); 
//            dc.setCapability("appium:deviceName", "1387243978000B5"); 
//            dc.setCapability("appium:automationName", "UiAutomator2"); 
//            dc.setCapability("appium:appPackage", "com.example.cloudcard"); 
//            dc.setCapability("appium:appActivity", "com.example.cloudcard.MainActivity"); 
//            dc.setCapability("appium:platformVersion", "14"); // FIXED
//
//            // Initialize Appium Driver
//            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), dc);
//            System.out.println("Session started successfully: " + driver.getSessionId());
//
//            // Implicit wait
//            Thread.sleep(3000);
//            
//            
//        } catch (MalformedURLException e) {
//            System.err.println("Invalid URL for Appium Server!");
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println("Error occurred while starting the session!");
//            e.printStackTrace();
//        } finally {
//            if (driver != null) {
//                driver.quit();
//                System.out.println("Session closed successfully!");
//            }
//        }
//    }
//}
