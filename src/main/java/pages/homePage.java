package pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class homePage {

	private AndroidDriver driver;
    private static final Logger logger = LogManager.getLogger(homePage.class);

 
	public homePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Files\"]")
	private WebElement filesM;
	
	public void filesM() {
		filesM.click();
	}
}
