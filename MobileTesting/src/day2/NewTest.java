package day2;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class NewTest {
	public AndroidDriver driver;

	@Test
	public void f() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demowebshop.tricentis.com");
		driver.findElement(By.xpath("//span[text()='Categories']")).click();
		driver.findElement(By.xpath("//span[@class='expand']"));
		driver.findElement(By.xpath("//*[contains(text(),'Desktops')]"));
		
		
		//driver.findElement(By.xpath("//span[@class='icon']")).click();
         //driver.findElement(By.xpath("//a[contains(text(),'Computers')]//following-sibling::span")).click();
         //driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//li//a[contains(text(),'Desktops')]")).click();
		
		
	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		// server name and port number required are on appium server homepage
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

}
