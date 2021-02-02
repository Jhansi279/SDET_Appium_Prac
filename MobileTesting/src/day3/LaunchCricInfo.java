package day3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchCricInfo {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		//Capabilities required for an andriod native app - app package and app activity. Browser name is not required.
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		
		//This way, the app starts from the base state. All data that is saved will be lost.
		//Can we launch it directly? Yes. Add another cap - NO_RESET
		
		

	}

}
