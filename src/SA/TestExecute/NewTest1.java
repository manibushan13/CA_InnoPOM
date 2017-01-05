package SA.TestExecute;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import SA.Component.*;
import SA.DriverManager.DriverManager;

public class NewTest1{

	protected GooglePage googlepage;
	protected LoginPage loginPage;
	protected HomePage homepage;
	protected DriverManager driverManager;
	String datafile="TestData";
	WebDriver driver;

	@BeforeMethod
	public void beforeTest() throws Exception {
		driverManager = new DriverManager();
		driverManager.launchBrowserAndLoadURL("GC");
	}
	
	
	@Test
	public void f() throws Exception {
		this.driver = SA.DriverManager.DriverManager.driver;
		googlepage = new GooglePage(driver);
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		
		googlepage.loginClick();
		loginPage.appLogin(datafile, "InputData");
		homepage.more();
		homepage.appLogout();
	}
	

	@AfterMethod
	public void afterTest() throws Exception {
		driverManager.quitBrowser();
	}
}


