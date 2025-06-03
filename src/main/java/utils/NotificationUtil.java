package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverManager;

import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class NotificationUtil {
	
	private AndroidDriver driver1;

	public NotificationUtil(AndroidDriver driver1) {
        this.driver1 = driver1;
        PageFactory.initElements(new AppiumFieldDecorator(driver1, Duration.ofSeconds(10)), this);
    }

    public static void openNotificationAndRead(AndroidDriver driver) {
        try {
        	AndroidDriver driver1 = DriverManager.getDriver();
            // Step 1: Open the notification panel
            driver1.openNotifications();

            // Step 2: Wait for the upload notification
            WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
//            WebElement notificationTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("(//android.widget.FrameLayout[@resource-id=\"com.android.systemui:id/expandableNotificationRow\"])[1]")
//            ));

//            WebElement notificationMessage = driver1.findElement(
//                By.xpath("//android.widget.TextView[contains(@text, "has been uploaded successfully")]")
//            );
            WebElement notificationMessage = driver1.findElement(By.xpath(
                    "//android.widget.TextView[contains(@text, 'has been uploaded successfully')]"));

            // Step 3: Print notification details
//            System.out.println("✅ Notification Title: " + notificationTitle.getText());
            System.out.println("📎 Notification Message: " + notificationMessage.getText());
            
            driver1.pressKey(new KeyEvent(AndroidKey.BACK));
            

        } catch (Exception e) {
            System.out.println("❌ Unable to fetch notification: " + e.getMessage());
        }
    }
}
