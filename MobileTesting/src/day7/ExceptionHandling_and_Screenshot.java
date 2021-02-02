package day7;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ExceptionHandling_and_Screenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName ", "Jhansi");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.NO_RESET, true);
		
		capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
		capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.espn.framework.ui.FrameworkLaunchActivity");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		Thread.sleep(30000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"LOG IN\")")).click();
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("jhansitest9@gmail.com");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Password (case sensitive)\")")).sendKeys("Sai");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"\")"))
		
		try {
	        String error =driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"The Credentials\")")).getText();
	        System.out.println("error message on the screen "+error);
	        }catch(NoSuchElementException e) {
	        String succes=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Tap your favourite teams\")")).getText();
	        System.out.println("successful login "+succes);
	        }

		//Take screenshot
		/*https://mvnrepository.com/artifact/commons-io/commons-io/2.8.0
		 * <dependency> <groupId>commons-io</groupId>
		 * <artifactId>commons-io</artifactId> <version>2.8.0</version> </dependency>
		 */
		File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("E:\\Appium Training\\SDETLPB4\\ScreenShot\\Screenshot.jpg"));
		
	}
	

}
