package SA.Utilities;

import SA.Properties.logApp;
import SA.SeleniumLib.Common;

public class MailNG {

	public static void main(String[] args) throws Exception {
		logApp.logIntilize();
//		MailTrigger.reportmail();
		Common.Regression_Run_Backup();
		logApp.logger.info("Regression Results Backup Taken Successfully.");
	}
}
