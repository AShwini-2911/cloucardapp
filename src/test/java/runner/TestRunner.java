package runner;

import base.CustomizeTestNGCucum;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "E:\\Ashwini\\CloudcardApp\\cloudcardApp\\src\\test\\resources\\features",
		glue = { "stepDefinitions", "hooks" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
				, "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}

		
		)

public class TestRunner extends CustomizeTestNGCucum{

}
