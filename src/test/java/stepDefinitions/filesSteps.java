package stepDefinitions;





import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pages.filesPage;
import utils.NotificationUtil;
import utils.Util;

 
public class filesSteps extends DriverManager {
 
	
	private AndroidDriver driver;
	private NotificationUtil notification;
	private filesPage files;
	
    private static final Logger logger = LogManager.getLogger(filesSteps.class);
 
	
	
 
	@When("the user taps on the Create icon")
	public void the_user_taps_on_the_create_icon() {
		DriverManager.initializeDriver();
		
	     files = new filesPage(DriverManager.getDriver());
	    files.filesCreateicon();
	}
 
	@When("the user taps on the Upload File option")
	public void the_user_taps_on_the_upload_file_option() {
		DriverManager.initializeDriver();
	     files = new filesPage(DriverManager.getDriver());
	    files.uploadFiles();
	}
 
	@When("the user selects a file from the file picker")
	public void the_user_selects_a_file_from_the_file_picker() {
	    files.selectimage();
	}
 
 
	@Then("the file should be uploaded successfully and visible in the file list")
	public void the_file_should_be_uploaded_successfully_and_visible_in_the_file_list() {
		logger.info("File successfully uploaded");
	    files.filesVisible();
	}
 
	@When("user able to see notification of file uploaded")
	public void user_able_to_see_notification_of_file_uploaded() {
	    logger.info("Notification");
	     notification = new NotificationUtil(DriverManager.getDriver());
	     NotificationUtil.openNotificationAndRead(driver);
	}
	
	
	 @When("the user taps on the {string} sort option")
	    public void theUserSelectsSortOption(String option) throws InterruptedException {
		 DriverManager.initializeDriver();
	     files = new filesPage(DriverManager.getDriver());
	        files.selectSortOption(option);
	    }

	@Then("the file list should be sorted alphabetically from A to Z")
	public void the_file_list_should_be_sorted_alphabetically_from_a_to_z() {
	    logger.info("A to Z sorting");
	    List<String> fileNames = files.getDisplayedFileNames();
        List<String> sorted = new ArrayList<>(fileNames);
        Collections.sort(sorted);
        
        
	}

	@Then("the file list should be sorted alphabetically from Z to A")
	public void the_file_list_should_be_sorted_alphabetically_from_z_to_a() {
	    logger.info("Z to A sorting");
		List<String> fileNames = files.getDisplayedFileNames();
        List<String> sorted = new ArrayList<>(fileNames);
        sorted.sort(Collections.reverseOrder());
        Assert.assertEquals(fileNames, sorted);
	}

	@Then("the file list should be sorted in descending order of file size")
	public void the_file_list_should_be_sorted_in_descending_order_of_file_size() {
	    logger.info("files sorting");
		 List<Double> sizes = files.getDisplayedFileSizes();
	        List<Double> sorted = new ArrayList<>(sizes);
	        sorted.sort(Collections.reverseOrder());
	        Assert.assertEquals(sizes, sorted);
	}

	@When("user select file to delete")
	public void user_select_file_to_delete() {
		logger.info("file");
		DriverManager.initializeDriver(); // Ensure driver is initialized
	    files = new filesPage(DriverManager.getDriver()); // Initialize filesPage
	    files.file();
	    logger.info("file selected");
	}

	@When("click on delete button on files")
	public void click_on_delete_button_on_files() throws InterruptedException {
		logger.info("delete file");
		DriverManager.initializeDriver(); // Ensure driver is initialized
	    files = new filesPage(DriverManager.getDriver()); 
	    files.delete();
	  
	    
	}

	@Then("success message should be displayed {string}")
	public void success_message_should_be_displayed(String expectedMessage) throws InterruptedException {
		logger.info("Success message");
	   Util.startConsoleCapture();
	   
	    files.confimDel();
	    String test = files.successMsg();
    	System.out.println(test);
        
        // Capture the console output
        String consoleOutput = Util.stopConsoleCapture(); 
        
        expectedMessage = expectedMessage.trim();
        consoleOutput = consoleOutput.trim();

        // Compare the captured console output with the expected message
        if (consoleOutput.equals(expectedMessage)) {
            // If they match, log success
            //ExtentCucumberAdapter.getCurrentStep().info("<font color='green' style='background-color:white;'>Console Output is as expected: " + consoleOutput + "</font>");
            logger.info("Success: Console Output is as expected: " + consoleOutput);
        } else {
            // If they don't match, log failure and print the expected vs actual output
//            ExtentCucumberAdapter.getCurrentStep().fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message.\n" +
//                                                        "Expected: " + expectedMessage + "\n" +
//                                                        "Actual: " + consoleOutput + "</font>");
            logger.error("<font color='green' style='background-color:white;'>Error: Console Output does not match the expected message.\n" +
                      "Expected: " + expectedMessage + "\n" +
                      "Actual: " + consoleOutput + "</font>");
            // Optionally, fail the test if the message doesn't match
            Assert.fail("<font color='green' style='background-color:white;'>Console Output does not match the expected message. </font>");
        }
        Util.clearConsoleOutput();
	}

	

}