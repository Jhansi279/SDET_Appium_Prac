package day7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SendingMessage {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability= new DesiredCapabilities();
        capability.setCapability("deviceName", "Manzoor");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability(MobileCapabilityType.NO_RESET, true);
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("OS").click();
        driver.findElementByAccessibilityId("SMS Messaging").click();
        driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("7865");
        driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Demo OTP:4567");
        driver.hideKeyboard();
        driver.findElementByAccessibilityId("Send").click();
        
        Thread.sleep(3000);
        //To open another app. Here, it is Messaging app
        driver.activateApp("com.google.android.apps.messaging");
        String otpValue = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
        System.out.println("OTP :" + otpValue);
        driver.closeApp();
        
        

	}

}
