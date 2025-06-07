package stepDefinitions;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pages.gmailSignUpPage;
import utils.MailosaurUtil;
import utils.Util;



public class gmailSignUpSteps extends DriverManager{
	
private AndroidDriver driver;
	
	private gmailSignUpPage signUp; 
	
    private static final Logger logger = LogManager.getLogger(gmailSignUpSteps.class);

	@Given("the user launches the application")
	public void the_user_launches_the_application() throws InterruptedException {
		DriverManager.initializeDriver();
	     signUp = new gmailSignUpPage(DriverManager.getDriver());
	     logger.info("Cloudcard app is installed");
		    Thread.sleep(3000);
	}

	@When("the user completes the onboarding skip")
	public void the_user_completes_the_onboarding_skip() {
	    signUp.onboardingSkip();
	    
	}

	@When("the user taps on the Sign Up button")
	public void the_user_taps_on_the_sign_up_button() {
		logger.info("Signup page");
	    signUp.signup();
	}

	@When("the user enters a valid email ID")
	public void the_user_enters_a_valid_email_id() throws InterruptedException {
		logger.info("enters email id");
		signUp.Email();

       Thread.sleep(3000);
       getDriver().hideKeyboard();
	}
	
	@When("the user accepts the Terms and Conditions")
	public void the_user_accepts_the_terms_and_conditions() {
	    signUp.termsCheck();
	}
	
	
	@When("the user taps the Verify Email button inside the email")

	public void the_user_taps_the_verify_email_button_inside_the_email() throws Exception {

	    logger.info("Fetching email verification link...");

	    Thread.sleep(5000);
	    String link = MailosaurUtil.fetchVerificationLink();

	    System.out.println("Verification link: " + link);
	 
	    if (link == null || link.isEmpty()) {

	        throw new Exception("Verification link is missing.");

	    }
	 
	    // Extract the token from the original URL

	    String token = null;

	    try {

	        URI uri = new URI(link);

	        String query = uri.getQuery(); // e.g., "token=dfldfdklkdfj"

	        for (String param : query.split("&")) {

	            if (param.startsWith("token=")) {

	                token = param.split("=")[1];

	                break;

	            }

	        }

	    } catch (Exception e) {

	        throw new Exception("Failed to extract token from link: " + e.getMessage());

	    }
	 
	    if (token == null || token.isEmpty()) {

	        throw new Exception("Token is missing in the verification link.");

	    }
	 
	    // Prepare the final verification endpoint

	    String verificationUrl = "https://appapi.thecloudcard.com/webservices/v1/users/email-verify?token=" + token;
	 
	    // Send GET request with Basic Auth

	    URL url = new URL(verificationUrl);

	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    conn.setRequestMethod("GET");
	 
	    // Add Basic Auth header

	    String basicAuth = "Basic YWRtaW46TXlwY290QDIwMjU=";

	    conn.setRequestProperty("Authorization", basicAuth);
	 
	    int responseCode = conn.getResponseCode();

	    logger.info("GET Response Code: " + responseCode);
	 
	    // Read and log response body

	    BufferedReader in = new BufferedReader(new InputStreamReader(

	            (responseCode >= 200 && responseCode < 400) ? conn.getInputStream() : conn.getErrorStream()));

	    String inputLine;

	    StringBuilder response = new StringBuilder();
	 
	    while ((inputLine = in.readLine()) != null) {

	        response.append(inputLine);

	    }

	    in.close();
	 
	    logger.info("Response Body: " + response.toString());
	 
	    if (responseCode != 200) {

	        throw new Exception("Email verification failed. Response: " + response.toString());

	    }
	 
	    logger.info("Returned to app after email verification.");

	}

	 
	

@When("the user taps the Continue button on the verification success screen")
public void the_user_taps_the_continue_button_on_the_verification_success_screen() {
   signUp.verContinue();
}

	@When("the user creates a new security PIN")
	public void the_user_creates_a_new_security_pin() throws InterruptedException {
	   
		Thread.sleep(2000);
	  
		signUp.pinSet();
	}

	

	@Then("the user should be navigated to the Enter Email ID screen")
	public void the_user_should_be_navigated_to_the_enter_email_id_screen() {
	    
	}

	@When("the user taps on the Continue button")
	public void the_user_taps_on_the_continue_button() {
	    signUp.signContinue();
	}


	@When("the user confirms the PIN by tapping the Confirm and Continue button")
	public void the_user_confirms_the_pin_by_tapping_the_confirm_and_continue_button() {
	    signUp.confirmPin();
	}

	@When("the user taps Continue on the generated QR code page")
	public void the_user_taps_continue_on_the_generated_qr_code_page() {
	    signUp.continueQR();
	}

	@When("the user taps the Lets Get Started button")
	public void the_user_taps_the_lets_get_started_button() {
	    signUp.letstarted();
	}
	

	@When("the user enters a invalid email ID")
	public void the_user_enters_a_invalid_email_id() throws InterruptedException {
		logger.info("enters invalid email id");
		signUp.invalidEmail();;

       Thread.sleep(3000);
       getDriver().hideKeyboard();
	}

	@Then("an error message should be displayed {string}")
	public void an_error_message_should_be_displayed(String expectedMessage) {
	    logger.info("Error message");
	   
	    
	    String test =  signUp.invalidMsg();
    	System.out.println(test);
        // Capture the console output
        String consoleOutput = Util.stopConsoleCapture(); // Replace with your actual console capture method
        System.out.println(consoleOutput);
        
        expectedMessage = expectedMessage.trim();
        consoleOutput = consoleOutput.trim();

        // Compare the captured console output with the expected message
        if (consoleOutput.equals(expectedMessage)) {
            // If they match, log success
            ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
            logger.info("Success: Console Output is as expected: " + consoleOutput);
        } else {
            // If they don't match, log failure and print the expected vs actual output
            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
                                                        "Expected: " + expectedMessage + "\n" +
                                                        "Actual: " + consoleOutput + "</font>");
            logger.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                      "Expected: " + expectedMessage + "\n" +
                      "Actual: " + consoleOutput + "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();
	}



}
