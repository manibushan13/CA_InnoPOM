package SA.Component;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import SA.SeleniumLib.*;
import SA.Utilities.*;

public class GooglePage {
	
	private WebDriver dr;
	Map<String, Map<String, String>> webGoogleOR_Map;
	ObjectRepoReader googlePage;
	UIElement pageAction;

	public GooglePage(WebDriver driver) throws IOException {
		
		this.dr = driver;
		googlePage = new ObjectRepoReader("pom");
		pageAction = new UIElement(dr);
		webGoogleOR_Map = googlePage.generateOR("googlepage");
	}
	
	public void loginClick() throws Exception {

		WebElement loginLink = pageAction.webGetWebElement(webGoogleOR_Map, "loginLink");
		Sync1.waitElementPresent(5000, loginLink);
		UIActions.clickElement(loginLink);
	}
	

}
