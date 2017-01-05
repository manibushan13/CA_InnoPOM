package SA.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class Property.
 * 
 * @author
 */
public class PropertyReader {

	static Properties properties = new Properties();

	/**
	 * Gets the property.
	 * 
	 * @param key
	 *            the key
	 * @return the property
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getProperty(String key) throws FileNotFoundException,
			IOException {
		String configFilePath = Constants.ENVIRONMENTS_CONFIG_FILE_PATH;
		FileInputStream fileInput = new FileInputStream(configFilePath);
		properties.load(fileInput);
		String value;
		value = properties.getProperty(key);
		return value;
	}

	
	/**
	 * Gets the prop values from config.
	 *
	 * @param propertyKey
	 *            the property key
	 * @param environment
	 *            the environment
	 * @return the prop values from config
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unused")
	public static String getPropValuesFromConfig(String propertyKey)
			throws FileNotFoundException, IOException {
		String propFileName = "sa.properties";

		String configFilePath = Constants.ENVIRONMENT_PROPERTIES_PATH + propFileName;
		FileInputStream fileInput = new FileInputStream(configFilePath);

		if (configFilePath != null) {
			try {
				properties.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return (String) properties.get(propertyKey);
	}

	/**
	 * Gets the test data.
	 * 
	 * @param key
	 *            the key
	 * @return the test data
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getTestData(String key) throws FileNotFoundException,
			IOException {
		String configFilePath = Constants.TESTDATA_CONFIG_FILE_PATH
				+ "\\TestData.properties";
		FileInputStream fileInput = new FileInputStream(configFilePath);
		properties.load(fileInput);
		String value;
		value = properties.getProperty(key);
		return value;
	}

	/**
	 * Gets the runtime test data.
	 * 
	 * @param key
	 *            the key
	 * @return the runtime test data
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getRuntimeTestData(String key)
			throws FileNotFoundException, IOException {
		String configFilePath = Constants.TESTDATA_CONFIG_FILE_PATH
				+ "\\RuntimeTestData.properties";
		FileInputStream fileInput = new FileInputStream(configFilePath);
		properties.load(fileInput);
		String value;
		value = properties.getProperty(key);
		return value;
	}

}
