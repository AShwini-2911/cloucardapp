package stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps extends DriverManager {
	private AndroidDriver driver;
	
	private LoginPage login ; 
	
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

	@Given("the mobile app is installed on the device")
	@Step("the mobile app is installed on the device")
	public void the_mobile_app_is_installed_on_the_device() throws InterruptedException {
		DriverManager.initializeDriver();
	     login = new LoginPage(DriverManager.getDriver());
	     logger.info("Cloudcard app is installed");
		    Thread.sleep(3000);
		    
	}

	@When("the user launches the app")
	@Step("the user launches the app")
	public void the_user_launches_the_app() {
		//login.permissionAllow();
	     logger.info("Cloudcard app is Launched");

	}

	@When("the user completes the onboarding steps")
	@Step("the user completes the onboarding steps")
	public void the_user_completes_the_onboarding_steps() {
		login.onboardingSkip();
	     logger.info("Skip button");

	}

	@When("the user taps the Upload QR button")
	@Step("the user taps the Upload QR button")
	public void the_user_taps_the_upload_qr_button() {
//		login.picPermission();
//		 login.uploadQRBtn();
//	     logger.info("upload QR button");

	}

	@Then("the user should be prompted to choose an app to select a photo")
	@Step("the user should be prompted to choose an app to select a photo")
	public void the_user_should_be_prompted_to_choose_an_app_to_select_a_photo() {
//	    login.album();
	}

	@When("the user selects the photo app and chooses the QR code image")
	@Step("the user selects the photo app and chooses the QR code image")
	public void the_user_selects_the_photo_app_and_chooses_the_qr_code_image() throws InterruptedException {
//		Thread.sleep(2000);
//		logger.info("album");
//	 login.tapOnQRImage();
	   logger.info("QR selected");
	}

	@Then("the user should be navigated to the login page")
	@Step("the user should be navigated to the login page")
	public void the_user_should_be_navigated_to_the_login_page() throws InterruptedException {
	    logger.info("login page");
	    Thread.sleep(3000);
	}

	@When("the user enters the security PIN")
	@Step("the user enters the security PIN")
	public void the_user_enters_the_security_pin() {
		logger.info("Security PIN");
	    login.securityPin();
	}
	
	@When("the user taps the Login button")
	@Step("the user taps the Login button")
	public void the_user_taps_the_login_button() {
	    login.loginBtn();
	}

	@Then("the user should land on the home page of the app")
	@Step("the user should land on the home page of the app")
	public void the_user_should_land_on_the_home_page_of_the_app() {
	    logger.info("Home page");
	}

	

}
