package utils;





import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportUtil {

    private static ExtentReports extentReports = new ExtentReports();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Initialize and create a test instance for logging
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Set the test instance (usually in the Before step)
    public static void setTest(ExtentTest test) {
        extentTest.set(test);
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to the reporter
        extentReports.flush();
    }

}

