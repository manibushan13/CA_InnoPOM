package SA.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class logApp {
	final public static Logger logger = Logger.getLogger(logApp.class);	

	public static void main(String[] args) throws Exception {
		DOMConfigurator.configure(System.getProperty("user.dir")+"/src/log4j.xml");
		logger.info("log4j Intialised11 Successfully.");
	}
	
	
	public static void logIntilize() throws Exception {
		DOMConfigurator.configure(System.getProperty("user.dir")+"/src/log4j.xml");
		logger.info("log4j Intialised Successfully.");

	}

}
