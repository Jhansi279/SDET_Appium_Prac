package day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AutoGrantPermission {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
        
        //There are pop-ups to access photos, location, (apps internal to the mobile). To accept them by default - AUTO_GRANT_PERMISSIONS
        capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign Up Later\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"India\")")).click();

	}

}
