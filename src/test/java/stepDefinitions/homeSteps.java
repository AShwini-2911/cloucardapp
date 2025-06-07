package stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.When;
import pages.homePage;

public class homeSteps extends DriverManager{
	
	private AndroidDriver driver;
	private homePage home;
	
    private static final Logger logger = LogManager.getLogger(homeSteps.class);

    @When("the user taps on the Files module")
	public void the_user_taps_on_the_files_module() throws InterruptedException {
		DriverManager.initializeDriver();
	     home = new homePage(DriverManager.getDriver());
	     logger.info("files module");
		    Thread.sleep(3000);
		    home.filesM();
	}
}
