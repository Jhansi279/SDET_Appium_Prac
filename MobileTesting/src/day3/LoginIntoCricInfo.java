package day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginIntoCricInfo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		Thread.sleep(30000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"LOG IN\")")).click();
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("jhansitest9@gmail.com");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password (case sensitive)\")")).sendKeys("Sai");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
		System.out.println();
		
		/*
		 * driver.findElement(MobileBy.id(""));
		 * driver.findElement(MobileBy.AndroidUIAutomator(
		 * "UiSelector().resourceId(\"test\")"));
		 */
		
		
		/*
		 * 
		 * 
		 * driver.findElement(MobileBy.
		 * AndroidUIAutomator("UiSelector().text(\"LOG IN\")")).click();
		 * driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys(
		 * "manzoor@gmail.com"); driver.findElement(MobileBy.
		 * AndroidUIAutomator("UiSelector().text(\"Password (case sensitive)\")")).
		 * sendKeys("manzoor"); driver.findElement(MobileBy.
		 * AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
		 */
	}

}
