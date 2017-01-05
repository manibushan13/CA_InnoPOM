package SA.Utilities;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadXMLData {
	

	public static String getXmlData(String datafile,String datasetName,String value1) throws Exception 
	{

		File file = new File(Constants.TestData_FILE_PATH+datafile+".xml");
		String values = null;		 

		if(file.getName().endsWith(".xml")){

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			String DataSetName = "DataSet";
			String DataAttributeName="Add";
			String keyvalue="key";
			String Value="value";

			NodeList nList = doc.getElementsByTagName(DataSetName);

			for (int temp = 0; temp < nList.getLength(); temp++) 
			{
				Node tableNode = nList.item(temp);
				Element tableElement = (Element) tableNode;	

				if(datasetName.equals(tableElement.getAttribute("name")))		     
				{		    	  
					NodeList columnList = tableElement.getElementsByTagName(DataAttributeName);
					for (int j = 0; j < columnList.getLength(); j++) 
					{
						Node columnNode = columnList.item(j);
						Element columnElement = (Element) columnNode;				         

						if(value1.equals(columnElement.getAttribute(keyvalue)))
							values=columnElement.getAttribute(Value);

					}
				}
			}
		}

		return values;
	}
	
	static String fname = "";
	static PrintWriter out1 = null;
	static File file = null;

	public static void filecreation()
	{
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		file = new File(Constants.Listener_Text_FILE_PATH+dateFormat.format(date) + ".txt") ;

	}

	public static void filereadyforwritingdata()
	{
		try {
			fname = file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out1 = new PrintWriter(new BufferedWriter(new FileWriter(fname, true)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void filewrite(String s)
	{
		out1.println(s);
	}

	public static void fileclose()
	{
		out1.close();
	}


}//eoc
