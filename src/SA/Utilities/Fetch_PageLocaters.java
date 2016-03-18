package SA.Utilities;

import SA.Component.*;

public class Fetch_PageLocaters {

	public Fetch_PageLocaters() {
		
		try{
			LoginPage.getAllLocaters();
			HomePage.getAllLocaters();
			GooglePage.getAllLocaters();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


}
