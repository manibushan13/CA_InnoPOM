package SA.Component;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import SA.SeleniumLib.*;
import SA.Utilities.*;

public class LoginPage {

	private WebDriver dr;
	Map<String, Map<String, String>> webLoginOR_Map;
	ObjectRepoReader loginPage;
	UIElement pageAction;
	
	public LoginPage(WebDriver driver) throws IOException {
		
		this.dr = driver;
		loginPage = new ObjectRepoReader("pom");
		pageAction = new UIElement(dr);
		webLoginOR_Map = loginPage.generateOR("login");
	}
	
	public void appLogin(String datafile, String dataset) throws Exception
	{
		enterUserName(datafile, dataset);
		clickNextButton();
		enterPassword(datafile, dataset);
		clickSignIn();
		
	}
	
	public void enterUserName(String datafile, String dataset) throws Exception
	{ 
		WebElement userName = pageAction.webGetWebElement(webLoginOR_Map, "username");
		UIActions.textBoxEntry(userName, ReadXMLData.getXmlData(datafile, dataset,"username"));
	}
	
	public void enterPassword(String datafile, String dataset) throws Exception
	{ 
		WebElement passWord = pageAction.webGetWebElement(webLoginOR_Map, "password");
		UIActions.textBoxEntry(passWord, ReadXMLData.getXmlData(datafile, dataset,"password"));
	}
	
	public void clickNextButton() throws Exception
	{ 
		WebElement nxtbtn = pageAction.webGetWebElement(webLoginOR_Map, "nextButton");
		UIActions.clickElement(nxtbtn);
	}
	
	public void clickSignIn() throws Exception
	{ 
		WebElement signIn = pageAction.webGetWebElement(webLoginOR_Map, "signIn");
		UIActions.clickElement(signIn);
	}

}
