package stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;

import pages.createfolderPage;

public class createfolderSteps extends DriverManager{

	private AndroidDriver driver;
	
	private createfolderPage folder ; 
	
    private static final Logger logger = LogManager.getLogger(createfolderSteps.class);
	
	@When("user is logged in")
	public void user_is_logged_in() throws InterruptedException {
		DriverManager.initializeDriver();
	     folder = new createfolderPage(DriverManager.getDriver());
	     logger.info("Cloudcard app is installed");
		    Thread.sleep(3000);
		    
	}

	@When("user click on folder icon")
	public void user_click_on_folder_icon() {
	    folder.folderclick();
	}

	@When("user click on create icon in folders page")
	public void user_click_on_create_icon_in_folders_page() {
	    //folder.foldericonclick();
	}

	@When("user click on create folder button")
	public void user_click_on_create_folder_button() throws InterruptedException {
	    Thread.sleep(3000);

	    folder.createFolder();
	}

	@When("user click enter the name of folder")
	public void user_click_enter_the_name_of_folder() {
	   folder.nameOfFolder();
	   
	}

	@When("user click on create button of folder")
	public void user_click_on_create_button_of_folder() {
	   folder.createBtn();
	}

	@Then("user click on search bar")
	public void user_click_on_search_bar() {
	  folder.searchBtn();
	}

	@Then("enter name of added folder")
	public void enter_name_of_added_folder() {
	   //
	}

	@Then("click on created folder")
	public void click_on_created_folder() {
	 
	}

}
