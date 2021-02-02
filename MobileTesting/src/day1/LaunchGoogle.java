package day1;

import java.beans.DesignMode;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchGoogle {

	public static void main(String[] args) throws MalformedURLException {
		// Before executing the code, connect to the device (mobile)
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		
		//If u dont remember the capability name
		//capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		//server name and port number required are on appium server homepage
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		
		//For the script to execute, 
		//1.start appium server ->Start inspector session
		//2. Virtual device (emulator) should be running
		
		driver.get("http://www.google.com");
		driver.get("http://demowebshop.tricentis.com");
		
	}

}
