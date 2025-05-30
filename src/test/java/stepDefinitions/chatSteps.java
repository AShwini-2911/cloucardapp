package stepDefinitions;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pages.chatPage;

public class chatSteps extends DriverManager {
	private AndroidDriver driver;
	
	private chatPage chat; 
	
	
	
    private static final Logger logger = LogManager.getLogger(chatSteps.class);
    
    @And("user click on chat module")
    public void user_click_on_chat_module() {
    	DriverManager.initializeDriver();
	     chat = new chatPage(DriverManager.getDriver());
	     
	     chat.chatM();
	     logger.info("Chat module opened");
    }

    @And("user click on create chat icon")
    public void user_click_on_create_chat_icon() {
        chat.createChat();
        logger.info("create chat icon");
    }

    @And("user click on username")
    public void user_click_on_username() {
        chat.username();
        logger.info("Search by username");
    }

    @And("user enter username")
    public void user_enter_username() {
        chat.enterUsername();
        getDriver().hideKeyboard();
        logger.info("enter username");
    }

    @And("user click on continue username button")
    public void user_click_on_continue_username_button() {
        chat.continueUsername();
        logger.info("username continue");
    }

    @And("user type the message")
    public void user_type_the_message() throws InterruptedException {
    	
    	chat.clickAsh();
       chat.helloMes();
       getDriver().hideKeyboard();
       logger.info("message");
    }

    @Then("user click on send message button")
    public void user_click_on_send_message_button() {
        chat.sendBtn();
        logger.info("send message button");
    }



}
