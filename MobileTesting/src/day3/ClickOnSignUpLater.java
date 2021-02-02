package day3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ClickOnSignUpLater {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//Capabilities required for an andriod native app - app package and app activity. Browser name is not required.
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign Up Later\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"India\")")).click();
		 Thread.sleep(5000); //Alerts are thrown. They disappear after sometime. So, give this wait time
	     driver.findElement(By.id("com.july.cricinfo:id/nextText")).click();

	}

}
