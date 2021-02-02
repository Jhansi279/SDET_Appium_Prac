package day2;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class MultipleValuesInLogin {
	public AndroidDriver driver;
	
  @Test
  public void f() throws IOException {
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  driver.get("http://demowebshop.tricentis.com/login");
	  
	  File file = new File("C:\\SDET\\TestData.xlsx");
	  FileInputStream fis = new FileInputStream(file);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wb.getSheetAt(0);
	  
	  int rc= sheet.getLastRowNum();
      System.out.println("total number of rows having data= "+rc);
      for(int i=1;i<=rc;i++) {
          String username=sheet.getRow(i).getCell(0).getStringCellValue();
          String password=sheet.getRow(i).getCell(1).getStringCellValue();
          driver.get("http://demowebshop.tricentis.com/login");    
      }
	  
	  
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
  }

}
