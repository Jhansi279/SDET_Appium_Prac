package day2;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginDemoWebShop {
	public AndroidDriver driver;
	
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.get("http://demowebshop.tricentis.com/login");
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("manzoorrocks191@gmail.com");
      driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("manipal");
      driver.hideKeyboard();
      driver.findElement(By.xpath("//input[@value='Log in']")).click();
      String expectedEmail="manzoorrocks191@gmail.com";
      String actualEmail=driver.findElement(By.linkText("manzoorrocks191@gmail.com")).getText();
      Assert.assertEquals(actualEmail, expectedEmail);
	
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		//server name and port number required are on appium server homepage
		 driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		 
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
