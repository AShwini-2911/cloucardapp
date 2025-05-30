package pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class chatPage {
	private AndroidDriver driver;
    private static final Logger logger = LogManager.getLogger(chatPage.class);

	public chatPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Chat\"]")
	private WebElement chatM;
	
	public void chatM() {
		chatM.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
	private WebElement createChat;
	
	public void createChat() {
		createChat.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"By username\"]")
	private WebElement username;
	
	public void username() {
		username.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement enterUsername;
	
	public void enterUsername() {
		enterUsername.click();
		enterUsername.sendKeys("ashwini r");
		
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement continueUsername;
	
	public void continueUsername() {
		continueUsername.click();
	}
	
	@AndroidFindBy(xpath ="//android.widget.ImageView[@content-desc=\"qTllpliNYp 30 May 2025\"]")
	private WebElement clickAshwini;
	
	public void clickAsh() throws InterruptedException {
		Thread.sleep(3000);
		clickAshwini.click();
	}
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement helloMes;
	
	public void helloMes() {
		helloMes.click();
		helloMes.sendKeys("Hello");
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]")
	private WebElement sendBtn;
	
	public void sendBtn() {
		sendBtn.click();
	}
}
