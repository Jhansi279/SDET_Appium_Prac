package day4;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginIntoKhanAcademy {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		/*
		 * capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
		 * "org.khanacademy.andriod");
		 * capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
		 * "org.khanacademy.android.ui.library.MainActivity"); AndroidDriver driver =
		 * new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		 */

		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Wait and then click on dismiss button
		Thread.sleep(5000);
		// driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		
		//Click on Sign In option
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Facebook\")")).click();
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("jhansitest9@gmail.com");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Facebook password\")")).sendKeys("Sai");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
		
	}

}
