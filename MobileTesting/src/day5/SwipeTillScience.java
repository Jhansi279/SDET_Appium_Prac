package day5;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeTillScience {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);

		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Accessibility id - u can use it directly
		driver.findElementByAccessibilityId("Search tab").click();
		Thread.sleep(9000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Science\")")).click();;
		Thread.sleep(5000);

		//driver.hideKeyboard();
		TouchAction act = new TouchAction<>(driver);
		Dimension d = driver.manage().window().getSize();
		int width = d.width;
		int height = d.height;

		int x1 = width / 2;
		int y1 = 4 * height / 5;

		int x2 = width / 2;
		int y2 = height / 5;

		while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Organic chemistry\")")).size()==0) {
			Thread.sleep(5000);
            act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2, y2)).release().perform();
       
		}
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Organic chemistry\")")).click();

	}

}
