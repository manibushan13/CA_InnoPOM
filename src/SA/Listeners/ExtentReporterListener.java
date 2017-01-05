package SA.Listeners;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import SA.DriverManager.DriverManager;
import SA.Utilities.SendEmail;
import SA.Utilities.TestConfig;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving extentReporter events. The class that is
 * interested in processing a extentReporter event implements this interface,
 * and the object created with that class is registered with a component using
 * the component's <code>addExtentReporterListener<code> method. When the
 * extentReporter event occurs, that object's appropriate method is invoked.
 *
 * @author 
 */

public class ExtentReporterListener implements IReporter {

	/** The extent. */
	private ExtentReports extent;

	/** The driver manager. */
	public DriverManager driverManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List,
	 * java.lang.String)
	 */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		String filePath = System.getProperty("user.dir") + "\\Reports";
		System.out.println("filepath :"+filePath);
		extent = new ExtentReports(filePath + File.separator +"ICT_Web_Automation_Reports.html", false);
		
		if (TestConfig.Environment != null) {
			extent.addSystemInfo("Web Environment", TestConfig.Environment);
		} else {
			extent.addSystemInfo("Web Environment", "");
		}

		if (DriverManager.browsername != null) {
			extent.addSystemInfo("Browser", DriverManager.browsername);
		}
			extent.addSystemInfo("Application Portal Build Version", "");
			extent.addSystemInfo("Admin Portal Build Version", "");
		
			for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		try {
			extent.flush();
			extent.close();
		} catch (Exception e) {

		}

		SendEmail sendEmail = new SendEmail();
		try {
			sendEmail.sendEmailReport();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Builds the test nodes.
	 *
	 * @param tests
	 *            the tests
	 * @param status
	 *            the status
	 */
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}
		}
	}

	/**
	 * Gets the time.
	 *
	 * @param millis
	 *            the millis
	 * @return the time
	 */
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
