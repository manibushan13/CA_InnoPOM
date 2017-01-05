//package SA.TestExecute;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterTest;
//import SA.Component.*;
//import SA.SeleniumLib.*;
//
//public class NewTest extends SetupStart{
//
//	protected GooglePage googlepage;
//	protected LoginPage loginPage;
//	protected HomePage homepage;
//	String datafile="TestData";
//
//	@Test
//	public void f() throws Exception {
//
//		googlepage = PageFactory.initElements(SA.SeleniumLib.Common.dr, GooglePage.class);
//		System.out.println("@Test.......");
//		loginPage=googlepage.loginClick();
//		loginPage.appLogin(datafile, "InputData");
//		googlepage=loginPage.inbox();
//		homepage=googlepage.more();
//		homepage.appLogout();
//	}
//	@BeforeTest
//	public void beforeTest() throws Exception {
////		Login.signIn("GC");
//	}
//
//	@AfterTest
//	public void afterTest() throws Exception {
//		Common.quitProcess();
//	}
//
//}
//
//
