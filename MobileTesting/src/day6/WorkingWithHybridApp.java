package day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WorkingWithHybridApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //To deal with dropdowns - no Select class. We scroll into view the contents of the dropdown and then click
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"India\")")).click();
        
        
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Enter name here\")")).sendKeys("Jhansi");
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Female\")")).click();
        driver.hideKeyboard();
        
        //driver.findElement(By.className("android.widget.Button")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
        Thread.sleep(2000);
        //Usually for native apps, we use 'MobileBy'. For web apps, we use 'By'
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        System.out.println("Current context of the app: "+driver.getContext());
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);
        System.out.println("List of contexts on app: "+ driver.getContextHandles());
        
        Thread.sleep(2000);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        System.out.println("Current context of the app: "+driver.getContext());
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Test");
        

	}

}
