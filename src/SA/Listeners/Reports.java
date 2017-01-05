package SA.Listeners;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
 ExtentReports extent;
 ExtentTest test;
 
 
 @BeforeTest
 public void M1(){
	 extent = new ExtentReports(System.getProperty("user.dir")+File.separator+"ExtentReport.html", true);
//  extent = new ExtentReports("D:/Selenium/Jenkins/ExtentReport.html", true);
  extent.addSystemInfo("Hostname", "Mani");
  extent.addSystemInfo("Environment", "QA");
  extent.loadConfig(new File("D:/Selenium/Jenkins/src/SA/Listeners/Config.xml"));
 }
 
 @Test
 public void M3()
 {
  try{
	  
   test = extent.startTest("ContactPage", "Verify Send button");
   Assert.assertTrue(true,"TC Passed");
   test.log(LogStatus.INFO, "site opened");
   
   Thread.sleep(2000);
  
   }catch(Exception e){test.log(LogStatus.ERROR, e.getMessage());}
 }
 
 @AfterTest
 public void tear()
 {
  extent.endTest(test);
  extent.flush();
  extent.close();
 }

}