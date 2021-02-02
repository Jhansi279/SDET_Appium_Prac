package day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RecentApplicationLaunching {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
        
        //There are pop-ups to access photos, location, (apps internal to the mobile). To accept them by default - AUTO_GRANT_PERMISSIONS
        capability.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        
        Thread.sleep(2000);
        //APP_SWITCH - to click on recent apps button/icon
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        
        Thread.sleep(2000);
        //Then swipe to the left
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        Thread.sleep(2000);
        
        //This swipes for second time
        //driver.pressKey(new KeyEvent(AndroidKey.DPAD_LEFT));
        
        //Press Enter to select the app
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        
        //Inearlier version of appium (1.7), there was an option to select an app by app name.
        driver.findElement(By.name(""));
        
        

	}

}
