package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

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
	
	  @AndroidFindBy(xpath ="//android.widget.ImageView[contains(@content-desc, 'Chat_175_')]")
	    private List<WebElement> fileItemElements;
	  

//	    public void file() {
//	    	
//    	
//	    	WebElement fileElement = driver.findElement(By.xpath("//android.widget.ImageView[contains(@content-desc, 'Chat_175_1748253221350.png')]"));
//	    	
//	    	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//	        Sequence longPress = new Sequence(finger, 1);
//
//	        // Get element center coordinates
//	        int centerX = fileElement.getLocation().getX() + (fileElement.getSize().getWidth() / 2);
//	        int centerY = fileElement.getLocation().getY() + (fileElement.getSize().getHeight() / 2);
//
//	        // Build the long press sequence
//	        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
//	        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//	        longPress.addAction(new Pause(finger, Duration.ofSeconds(2)));   // Hold for 2 seconds
//	        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//	        // Perform the action
//	        driver.perform(Arrays.asList(longPress));
//
//	
//	    }
	   
	  public void file() {
		    // Find all file elements and store in array
		    List<WebElement> fileElements = driver.findElements(By.xpath("//android.widget.ImageView[contains(@content-desc, '.')]"));
		    
		    // Check if any elements were found
		    if (fileElements.isEmpty()) {
		        System.out.println("No file elements found");
		        return;
		    }
		    
		    // Select the first element from the array
		    WebElement firstFileElement = fileElements.get(0);
		    
		    // Print information about found elements
		    System.out.println("Found " + fileElements.size() + " file elements");
		    System.out.println("Working with first element: " + firstFileElement.getAttribute("content-desc"));
		    
		    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		    Sequence longPress = new Sequence(finger, 1);

		    // Get element center coordinates
		    int centerX = firstFileElement.getLocation().getX() + (firstFileElement.getSize().getWidth() / 2);
		    int centerY = firstFileElement.getLocation().getY() + (firstFileElement.getSize().getHeight() / 2);

		    // Build the long press sequence
		    longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
		    longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		    longPress.addAction(new Pause(finger, Duration.ofSeconds(2))); // Hold for 2 seconds
		    longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    // Perform the action
		    driver.perform(Arrays.asList(longPress));
		}
	  
	  

	  @AndroidFindBy(xpath="//android.widget.ImageView[contains(@bounds,\"2204\") and contains(@bounds,\"2267\")]")
	private WebElement deleteButton;
	 
	  @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Delete\"]")
	  private WebElement confirmDelElement;


	 
	  public void delete() throws InterruptedException {
		    deleteButton.click();
		    Thread.sleep(5000);
		    
		}
	  public void confimDel() {
		  confirmDelElement.click();
	  }

	  @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Moved to trash successfully\"]")
	  private WebElement successMsg;
	
		
		public String successMsg() throws InterruptedException {
			   return successMsg.getAttribute("contentDescription");
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

