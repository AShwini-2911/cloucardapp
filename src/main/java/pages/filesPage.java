package pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;

public class filesPage {
 
	private AndroidDriver driver;
    private static final Logger logger = LogManager.getLogger(filesPage.class);

 
	public filesPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
	

	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
	private WebElement filesCreateicon;
	
	public void filesCreateicon() {
		filesCreateicon.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Upload file\"]")
	private WebElement uploadfile;
	
	public void uploadFiles() {
		uploadfile.click();
	}
	
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.google.android.documentsui:id/item_root\"])[2]")
	private WebElement selectQR;
	
	public void selectimage() {
		selectQR.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[3]")
	private WebElement filesVisible;
	
	public void filesVisible() {
		boolean isDisplayed = filesVisible.isDisplayed();
        if (!isDisplayed) {
            throw new AssertionError("Uploaded file is not visible in the list.");
        }	}
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"A - Z\"]")
	private WebElement AZsorting;
	
	public void AZsorting() {
		AZsorting.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Z - A\"]")
	private WebElement ZAsorting;
	
	public void ZAsorting() {
		AZsorting.click();
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"File size\"]")
	private WebElement filesizesorting;
	
	public void filesizesorting() {
		AZsorting.click();
	}
	
	  @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, '.')]")
	    private List<WebElement> fileItemElements;
	  
	    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Chat_175_1748253221350.png 0.41 KB 03 Jun 2025\"]")
	    public WebElement fileElement;
	   
	  @AndroidBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]")
	  private WebElement deleteBtn;
	  
	  @AndroidBy(xpath = "//android.view.View[@content-desc=\"Delete\"]")
	  private WebElement delete;
	  
	  public void delete() {
		  deleteBtn.click();
		  delete.click();
	  }
	  
	  @AndroidBy(xpath = "//android.view.View[@content-desc=\"Moved to trash successfully\"]")
	  private WebElement successMsg;
	
		
		public String successMsg() {
			return successMsg.getText();
		}
	public void selectSortOption(String option) throws InterruptedException {
        switch (option.toUpperCase()) {
            case "A-Z":
            	Thread.sleep(3000);
                AZsorting.click();
                break;
            case "Z-A":
                ZAsorting.click();
                break;
            case "FILE SIZE":
                filesizesorting.click();
                break;
        }
    }

    public List<String> getDisplayedFileNames() {
        return fileItemElements.stream()
                .map(e -> e.getAttribute("content-desc").split("\\n")[0].trim())
                .collect(Collectors.toList());
    }

    public List<Double> getDisplayedFileSizes() {
        return fileItemElements.stream()
                .map(e -> {
                    String[] parts = e.getAttribute("content-desc").split("\\n");
                    if (parts.length >= 2) {
                        return convertSizeToKB(parts[1].trim());
                    }
                    return 0.0;
                })
                .collect(Collectors.toList());
    }

    private double convertSizeToKB(String sizeText) {
        if (sizeText.endsWith("KB")) {
            return Double.parseDouble(sizeText.replace("KB", "").trim());
        } else if (sizeText.endsWith("MB")) {
            return Double.parseDouble(sizeText.replace("MB", "").trim()) * 1024;
        }
        return 0.0;
    }
	
    
    
}
