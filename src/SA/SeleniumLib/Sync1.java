package SA.SeleniumLib;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SA.DriverManager.DriverManager;
import SA.Properties.logApp;
import SA.Utilities.PropertyReader;


public class Sync1 extends DriverManager {

	final public static Logger logger = Logger.getLogger(Sync1.class);
	private static long waitSeconds;
	public static WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
	
	/**
	 * Default Constructor
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Sync1() throws FileNotFoundException, IOException {
		super();
		waitSeconds=Long.parseLong(PropertyReader.getPropValuesFromConfig("waitTime"));
	}


	/**
	 * it will wait to load the Page completely for a given time;
	 * @param waitSeconds
	 */	
	public static void waitPageLoad() throws Exception {	
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyReader.getPropValuesFromConfig("waitTime")),TimeUnit.SECONDS);			
		Sync1.logger.info("Sync waitPageLoad Completed successfully");
	}	

	/**
	 * waitAlert: it will Wait for alert
	 * @param waitSeconds
	 */
	public static void waitAlert(long waitSeconds) throws Exception{
		WebDriverWait syncWait = new WebDriverWait(driver, waitSeconds);
		syncWait.withTimeout(waitSeconds, TimeUnit.SECONDS);
		syncWait.pollingEvery(300, TimeUnit.MILLISECONDS);
		syncWait.until(ExpectedConditions.alertIsPresent());
		Sync1.logger.info("Sync waitAlert Completed successfully");
	}	


	/**
	 * it will wait for Text present in a element
	 * @param waitSeconds --- set set waiting Time
	 * @param webElement
	 * @param text --- set text
	 */
	public static void waitTextPresent(long waitSeconds,WebElement webElement,String text) throws Exception{

		WebDriverWait syncWait = new WebDriverWait(driver, waitSeconds);
		syncWait.withTimeout(waitSeconds, TimeUnit.SECONDS);
		syncWait.pollingEvery(300, TimeUnit.MILLISECONDS);
		
		syncWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
		Sync1.logger.info("Sync waitTextPresent completed successfully");
	}



	/**
	 * it will wait for Text present in a element	 
	 * @param webElement
	 * @param text --- set text
	 */
	public static void waitTextPresent(WebElement webElement,String text) throws Exception{

		WebDriverWait syncWait = new WebDriverWait(driver, waitSeconds);
		syncWait.withTimeout(Long.parseLong(PropertyReader.getPropValuesFromConfig("waitTime")), TimeUnit.SECONDS);
		syncWait.pollingEvery(300, TimeUnit.MILLISECONDS);
		
		syncWait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
		
		Sync1.logger.info("Sync waitTextPresent completed successfully");
	}


	/**
	 * it will wait for waitElementPresent
	 * @param waitSeconds---set waiting Time
	 * @param webElement
	 */
	public static void waitElementPresent(long waitSeconds,WebElement webElement) throws Exception{

		WebDriverWait syncWait = new WebDriverWait(driver, waitSeconds);
		syncWait.withTimeout(waitSeconds, TimeUnit.SECONDS);
		syncWait.pollingEvery(300, TimeUnit.MILLISECONDS);
		
		syncWait.until(ExpectedConditions.visibilityOf(webElement));
		syncWait.until(ExpectedConditions.elementToBeClickable(webElement));
		Sync1.logger.info("Sync waitElementPresent completed successfully");
	}
	
	/**
	 * it will wait for waitElementPresent
	 * @param webElement
	 * @throws Exception
	 */
	
	public static void waitElementPresent(WebElement webElement) throws Exception{

		WebDriverWait syncWait = new WebDriverWait(driver, waitSeconds);
		syncWait.withTimeout(waitSeconds, TimeUnit.SECONDS);
		syncWait.pollingEvery(300, TimeUnit.MILLISECONDS);
		
		syncWait.until(ExpectedConditions.visibilityOf(webElement));
		syncWait.until(ExpectedConditions.elementToBeClickable(webElement));
		Sync1.logger.info("Sync waitElementPresent completed successfully");
	}


	public static void processSync(long time){
		try{
			Thread.sleep(time);
			logApp.logger.info("processSync passed");
		}catch(Exception e){
			logApp.logger.error("processSync failed with below error: "+e);
		}
	}





}