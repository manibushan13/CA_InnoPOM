package SA.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * The Class ConfigTestFixtures.
 * 
 * @author
 */
public class TestConfig {
	
	//For Mobile
	public static String Environment;
	private static String gmailSendEmailHost;
	private static String sendEmailPort;
	private static String sendEmailFrom;
	private static String sendEmailPwd;
	private static String sendEmailTo;
	

	/**
	 * Gets the environment.
	 * 
	 * @return the environment
	 */
	public static String getEnvironment() {
		return Environment;
	}

	/**
	 * Sets the environment.
	 * 
	 * @param environment
	 *            the new environment
	 */
	public static void setEnvironment(String environment) {
		Environment = environment;
	}


	/**
	 * 
	 * @param env
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void generateConfigTestData()
			throws FileNotFoundException, IOException {
		Environment = PropertyReader.getPropValuesFromConfig("environment");
		gmailSendEmailHost = PropertyReader.getPropValuesFromConfig("gmailSendEmailHost");
		sendEmailPort = PropertyReader.getPropValuesFromConfig("sendEmailPort");
		sendEmailFrom = PropertyReader.getPropValuesFromConfig("SendEmailFrom");
		sendEmailPwd = PropertyReader.getPropValuesFromConfig("sendEmailPwd");
		sendEmailTo = PropertyReader.getPropValuesFromConfig("SendEmailTo");
	}
	
	public void generateConfigTestData(String webEnv, String mobileEnv) throws FileNotFoundException, IOException {
//		deviceName = PropertyReader.getPropValuesFromConfig("deviceName", "", mobileEnv);

	}

	public static String getGmailSendEmailHost() {
		return gmailSendEmailHost;
	}

	public static String getSendEmailPort() {
		return sendEmailPort;
	}

	public static String getSendEmailFrom() {
		return sendEmailFrom;
	}

	public static String getSendEmailPwd() {
		return sendEmailPwd;
	}

	public static String getSendEmailTo() {
		return sendEmailTo;
	}

}
