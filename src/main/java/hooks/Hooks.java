package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import base.DriverManager;
import utils.Util;

public class Hooks {

    private static boolean isLoggedIn = false;

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        System.out.println("Starting Scenario: " + scenario.getName());
        DriverManager.initializeDriver();

        if (!isLoggedIn) {
            Util.performLogin(DriverManager.getDriver());
            isLoggedIn = true;
            System.out.println("Logged in successfully.");
        } else {
            System.out.println("Already logged in, skipping login step.");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("❌ Scenario Failed: " + scenario.getName());
        } else {
            System.out.println("✅ Scenario Passed: " + scenario.getName());
        }
    }
}
