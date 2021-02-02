package day4;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClickComputers {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Accessibility id - u can use it directly
		driver.findElementByAccessibilityId("Search tab").click();
		Thread.sleep(9000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Computing\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Computer science\")")).click();
		
		

	}

}
