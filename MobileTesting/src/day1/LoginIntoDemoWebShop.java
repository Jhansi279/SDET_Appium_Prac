package day1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginIntoDemoWebShop {

	public static void main(String[] args) throws MalformedURLException {
		// Before executing the code, connect to the device (mobile)
				DesiredCapabilities capability = new DesiredCapabilities();
				capability.setCapability("deviceName ", "Jhansi");
				capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				
				//server name and port number required are on appium server homepage
				AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
				driver.get("http://demowebshop.tricentis.com/login");
				driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys("radontha@in.ibm.com");
				driver.findElement(By.id("Email")).sendKeys("radontha@in.ibm.com");
				driver.findElement(By.id("Password")).sendKeys("Sais@279");
				
				//To hide keyboard
				driver.hideKeyboard();
				

	}

}
