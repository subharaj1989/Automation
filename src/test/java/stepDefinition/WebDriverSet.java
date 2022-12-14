package stepDefinition;

import org.hamcrest.core.IsNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSet {
static WebDriver driver;
	public static WebDriver DriverSet()
	{
		
		 
		 if (driver==null)
		 {
			System.setProperty("webdriver.chrome.driver","src/test/resources/resourcesfiles/chromedriver.exe");
			 driver=new ChromeDriver();
			 
		 }
		 return driver;
	}
	
	
}
