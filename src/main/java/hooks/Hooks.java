package hooks;

	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.Scenario;
	import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

	public class Hooks {
	    
	    @Before
	    public void beforeScenario(Scenario scenario) {
	        ExtentCucumberAdapter.getCurrentStep();  // Initialize step tracking
	        System.out.println("Starting Scenario: " + scenario.getName());
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



