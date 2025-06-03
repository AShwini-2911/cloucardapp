package hooks;

	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
import utils.Util;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.DriverManager;

	public class Hooks {
	    private WebDriver driver;

	    
	    @Before
	    public void beforeScenario(Scenario scenario) {
			DriverManager.initializeDriver();

	        ExtentCucumberAdapter.getCurrentStep();  // Initialize step tracking
	        System.out.println("Starting Scenario: " + scenario.getName());
	        Util.performLogin(driver);
	        
	    }

	    @After
	    public void afterScenario(Scenario scenario) {
	        if (scenario.isFailed()) {
	            ExtentCucumberAdapter.getCurrentStep().fail("Scenario Failed: " + scenario.getName());
	        } else {
	            ExtentCucumberAdapter.getCurrentStep().pass("Scenario Passed: " + scenario.getName());
	        }
	    }
	}



