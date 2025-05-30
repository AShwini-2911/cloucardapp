package pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class createfolderPage {

	private AndroidDriver driver;
    private static final Logger logger = LogManager.getLogger(createfolderPage.class);

	public createfolderPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Folder\"]")
	private WebElement folderclick;
	
	public void folderclick() {
		folderclick.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
	private WebElement foldericonclick;
	
	public void foldericonclick() {
		foldericonclick.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Create folder\"]")
	private WebElement createFolder;
	
	public void createFolder() {
		createFolder.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement nameOfFolder;
	
	public void nameOfFolder() {
		nameOfFolder.click();
		nameOfFolder.sendKeys("Ash");
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Create\"]")
	private WebElement createBtn;
	
	public void createBtn() {
		createBtn.click();
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Folders\"]/android.widget.ImageView[2]")
	private WebElement searchBtn;
	
	public void searchBtn() {
		searchBtn.click();
//		searchBtn.sendKeys("Ash");
	}
	
	
}
