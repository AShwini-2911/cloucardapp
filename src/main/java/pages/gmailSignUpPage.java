package pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.MailosaurUtil;

public class gmailSignUpPage {

	private AndroidDriver driver;
    private static final Logger logger = LogManager.getLogger(gmailSignUpPage.class);

	public gmailSignUpPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Skip\"]")
	private WebElement onboardingskip;
	
	public void onboardingSkip() {
		onboardingskip.click();
	} 
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign up\"]")
	private WebElement signup;
	
	public void signup() {
		signup.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
	private WebElement foregroundPermission;
	
	public void foregroundPermission() {
		foregroundPermission.click();
	}
	@AndroidFindBy(xpath = "//android.widget.EditText")
	public WebElement Email;
	
	public void Email() {
		Email.click();
		Email.sendKeys(MailosaurUtil.getTestEmail());
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]")
	private WebElement termsCheck;
	
	public void termsCheck() {
		termsCheck.click();
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
	private WebElement signContinue;
	
	public void signContinue() {
		signContinue.click();
	}
	
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
    private WebElement verficationContinue;
    
    public void verContinue() {
    	verficationContinue.click();
    }
    
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement pinSet;
    
    public void pinSet() throws InterruptedException {
    	
    	pinSet.click();
    	pinSet.sendKeys("111111");
    }
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Confirm & Continue\"]")
    private WebElement confirm;
    
    public void confirmPin() {
    	confirm.click();
    }
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
    private WebElement continueQR;
    
    public void continueQR() {
    	continueQR.click();
    }
    
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Let’s get started!\"]")
    private WebElement started;
    
    public void letstarted() {
    	started.click();
    }
}
