package pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;



public class LoginPage {

	private AndroidDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement permissionAllow;
	
	public void permissionAllow() {
		permissionAllow.click();
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Skip\"]")
	private WebElement onboardingskip;
	
	public void onboardingSkip() {
		onboardingskip.click();
	}
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
	private WebElement picturePermission;
	
	public void picPermission() {
		picturePermission.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
	private WebElement uploadQR;
	
	public void uploadQRBtn() {
		uploadQR.click();
	}
	
	@AndroidFindBy(id = "android:id/button_once")
	private WebElement album;
	
	public void album() {
		//album.click();
	}
	
	@FindBy(id = "com.vivo.gallery:id/content")
	private WebElement selectQR;
	
	@FindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"com.vivo.gallery:id/content\"]/android.widget.ImageView")
	private WebElement selectOne;
	public void selectQR() throws InterruptedException {
		//selectQR.click();
		Thread.sleep(2000);
		selectOne.click();
	}
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement qrImage;

    public void tapOnQRImage() {
        qrImage.click();
    }
    
   
	
	
	@FindBy(xpath = "//android.widget.EditText")
	private WebElement securityPin;
	
	public void securityPin() {
		securityPin.click();
		securityPin.sendKeys("111111");
	}
	
	@FindBy(xpath = "(//android.view.View[@content-desc=\"Login\"])[2]")
	private WebElement login;
	
	public void loginBtn() {
		login.click();
	}
	
}
