package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static Properties defaultproperties=new Properties();
	private static final String FILE_NAME="Test.properties";
	
	public Config()
	{
		InputStream input=Config.class.getClassLoader().getResourceAsStream(FILE_NAME);
		try {
			defaultproperties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setProperties()
	{
		InputStream input=Config.class.getClassLoader().getResourceAsStream(FILE_NAME);
		try {
			defaultproperties.load(input);
			SessionVariables.ScreenshotOnlyOnFailure=defaultproperties.getProperty("sceenshotOnlyOnFailure");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperty(String PropertyName) {
		// TODO Auto-generated method stub
		String sPropetyvalue=null;
		sPropetyvalue=defaultproperties.getProperty(PropertyName);
		
		return sPropetyvalue;
	}
	

	public static String getAppURL(String sAppName)
	{
		String sURLvalue=null;
		if(sAppName.equals("ParaBank"))
		{
			sURLvalue=getProperty("ParaBankAppURL");
			
		}

		if(sAppName.equals("Panda"))
		{
			sURLvalue=getProperty("PandaAppURL");
		}
		return sURLvalue;
		
	}
}
