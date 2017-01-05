package SA.SeleniumLib;

import org.openqa.selenium.WebElement;
import SA.Properties.logApp;


public class UIActions {


	public static void textBoxEntry(WebElement webElement, String entryData) throws Exception {

		webElement.clear();
		webElement.sendKeys(entryData);
		logApp.logger.info(entryData+" filled in expected textbox.");
	}
	
	public static void clickElement(WebElement webElement) throws Exception {

		webElement.click();
		logApp.logger.info(webElement+" button click success.");

	}

}

