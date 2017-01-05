package SA.DriverManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import SA.Properties.logApp;
import SA.Utilities.PropertyReader;


/**
 * The Class Driver Manager.
 * 
 */
public class DriverManager {

	protected static String browser;
	protected static String os;
	public static WebDriver driver;
	public static String browsername;
	

	/**
	 * Instantiates a new selenium browser.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public DriverManager() throws FileNotFoundException, IOException {

		File file = new File("");
		if (file.exists()) {
			file.delete();
			file.mkdir();
		} else {
			file.mkdir();
		}
	}

	/**
	 * Gets the driver.
	 * 
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Gets the OS version.
	 * 
	 * @return the OS version
	 */
	private static String getOSVersion() {
		System.out.println("Operating System=" + System.getProperty("os.name"));
		return System.getProperty("os.name");
	}

	/**
	 * Sets the up selenium environment.
	 * 
	 * @param browser
	 *            the new up selenium environment
	 */
	public void setupSeleniumEnvironment(String browser) {
		DriverManager.os = getOSVersion();
		System.out.println("OS Version = " + DriverManager.os + ", os.arch = "
				+ System.getProperty("os.arch"));
		String passedBrowser = browser;
		// String passedBrowser = Property.getProperty("browser");
		System.out.println("browser to run = " + passedBrowser);
		if (passedBrowser != null) {
			DriverManager.browser = passedBrowser;
		} else {
			DriverManager.browser = "chrome";
		}
		printEnvInfo();
	}

	/*public void launchBrowser(String browser) throws FileNotFoundException,
			IOException {
		browsername = browser;
		setupSeleniumEnvironment(browser);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		if (browser.toLowerCase().equals("iexplore")
				|| browser.toLowerCase().equals("ie")
				|| browser.toLowerCase().equals("internet explorer")) {
			browser = "iexplore";

			if (os.contains("Windows")) {
				if (System.getProperty("os.arch").contains("86")) {
					System.setProperty("webdriver.ie.driver",
							"src\\test\\resources\\Drivers\\iexplore\\IEDriverServer_win_32_X86.exe");
				} else if (System.getProperty("os.arch").contains("64")) {
					System.setProperty("webdriver.ie.driver",
							"src\\test\\resources\\Drivers\\iexplore\\IEDriverServer_win_X64.exe");
				}
			} else {
				System.out.println("Unexpected Operating System");

			}

			driver = new InternetExplorerDriver();
		} else if (browser.toLowerCase().equals("firefox")
				|| browser.toLowerCase().equals("ff")) {
			browser = "firefox";
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().equals("chrome")
				|| browser.toLowerCase().equals("google")
				|| browser.toLowerCase().equals("google chrome")
				|| browser.toLowerCase().equals("googlechrome")) {

			browser = "googlechrome";
			if (os.contains("Windows")) {

				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_win32\\chromedriver.exe");

				System.out.println(System
						.getProperty("webdriver.chrome.driver"));
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory",
						"");
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("chrome.switches", "--disable-extensions");
				cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				// cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);

			} else if (os.equals("Linux")
					&& System.getProperty("os.arch").contains("64")) {
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_linux64\\chromedriver");
			} else if (os.equals("Linux")
					&& !System.getProperty("os.arch").contains("86")) {
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_linux32\\chromedriver");
			} else if (os.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_mac\\chromedriver");
			} else {
				System.out.println("Unexpected Operating System");

			}

			driver = new ChromeDriver(cap);
		}

		else {
			System.out.println(browser.toLowerCase());
			browser = "iexplore";
			driver = new InternetExplorerDriver();
		}

	}*/

	/**
	 * Gets the current browser type.
	 * 
	 * @return the current browser type
	 */
	public static String getCurrentBrowserType() {
		return DriverManager.browser;
	}

	/**
	 * Prints the env info.
	 */
	public static void printEnvInfo() {
		System.out.println("You have selected " + browser
				+ " as your browser. " + browser + " is being used.");
	}


	/**
	 * Load url.
	 * 
	 * @param url
	 *            the url
	 * @throws Exception
	 *             the exception
	 */
	public void loadURL(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Quit browser.
	 * 
	 * @return the string
	 * @throws Exception
	 * 
	 */
	public String quitBrowser() throws Exception {
		logApp.logger.info("Closing the All Open Browser Windows.");
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			return "FAIL "+"Unable to close browser. Check if its open :"
					+ e.getMessage();
		}
		return "PASS";
	}

	/**
	 * Close browser.
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser");
		driver.close();
	}
	
	public void launchBrowserAndLoadURL(String browser) throws Exception
	{
		logApp.logger.info("Browser :"+browser);
		if(browser!=""){
			logApp.logger.info("URL :"+PropertyReader.getPropValuesFromConfig("BASEURL"));
			DriverManager.browser = browser;
			launchBrowser(browser);
		}
		else{
			DriverManager.browser = PropertyReader.getPropValuesFromConfig("BROWSER");
			launchBrowser(PropertyReader.getPropValuesFromConfig("BROWSER"));
		}
		loadURL(PropertyReader.getPropValuesFromConfig("BASEURL"));
	}
	
	public static void launchBrowser(String browser) throws Exception{		

		switch (browser){	

		case "IE":

			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +"/Lib/IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			cap.setCapability("enablePersistentHover", false);
			cap.setCapability("ensureCleanSession", true);
			cap.setCapability("unexpectedAlertBehaviour", "accept");
			DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);			
			driver = new InternetExplorerDriver(cap);	
			logApp.logger.info("Invoked IE Driver Success");
			break;

		case "GC":

			//Get Chrome Driver
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/Lib/chromedriver.exe");
			
			String downloadFilepath = System.getProperty("user.dir")+"/src/SA/TestData/Reporting/Downloads";

			//Save Chrome Preferences in Hash Map
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			HashMap<String, Object> contentsetting = new HashMap<String, Object>();
			//chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);

			chromePrefs.put("download.default_directory", downloadFilepath);
			contentsetting.put("multiple-automatic-downloads",1);
			chromePrefs.put("download.prompt_for_download", "false");
			chromePrefs.put("profile.default_content_settings", contentsetting);

			//Save Chrome Opions
			ChromeOptions options = new ChromeOptions();
//			options.addExtensions(new File(System.getProperty("user.dir")+"/Lib/okata.crx"));
			HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();			
			options.setExperimentalOption("prefs", chromePrefs);

			options.addArguments("--test-type");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-popup-blocking");

			//Set desired capability
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--disable-local-storage"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			//Start Chrome Driver
			driver = new ChromeDriver(capabilities);
			logApp.logger.info("Invoked Chrome Driver Successfully.");
			break;

		case "FF":

			driver = new FirefoxDriver();
			logApp.logger.info("Invoked Firefox Driver Successfully.");
			break;
		}
	}

}