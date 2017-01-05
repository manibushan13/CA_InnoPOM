package SA.Component;

import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import SA.Utilities.*;
import SA.SeleniumLib.*;

public class HomePage {

	private WebDriver dr;
	Map<String, Map<String, String>> homePageOR_Map;
	ObjectRepoReader homePage;
	UIElement pageAction;

	public HomePage(WebDriver driver) throws IOException {

		this.dr = driver;
		homePage = new ObjectRepoReader("pom");
		pageAction = new UIElement(dr);
		homePageOR_Map = homePage.generateOR("login");
	}

	public void more() throws Exception {

		WebElement moreLink = pageAction.webGetWebElement(homePageOR_Map, "more");
		Sync1.waitElementPresent(5000, moreLink);
		UIActions.clickElement(moreLink);
	}

	public void appLogout() throws Exception {
		ClickLogoutLink();
		ClickLogoutButton();
		Thread.sleep(5000);

	}

	public void ClickLogoutLink() throws Exception {
		WebElement logoutLink = pageAction.webGetWebElement(homePageOR_Map, "logoutLink");
		UIActions.clickElement(logoutLink);
	}

	public void ClickLogoutButton() throws Exception {
		WebElement logout = pageAction.webGetWebElement(homePageOR_Map, "logout");
		UIActions.clickElement(logout);
	}

}
