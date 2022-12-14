package stepDefinition;
import testpages.Loginpage;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import testpages.Loginpage;

public class Loginsteps {
	 static WebDriverSet wds;
	//static WebDriver driver;
    static Loginpage pgLogin;
	
	@Given("User is on the login page")
	public void LaunchApplicaton()
	{
		boolean bretval;
		//setwebdriver();
		//wds=new WebDriverSet();
		//driver=wds.DriverSet();
		pgLogin= new Loginpage();
		pgLogin.LaunchApplication();
		Assert.assertTrue("Unable to Launch Application",pgLogin.LaunchApplication());
		
		
		//pgLogin= new Loginpage(driver);
		
	}
	
	@Given("User enters valid username and password {string}  in User and password textbox")
	public void EnterUSername_Password(String TCID)
	{
		pgLogin.EnteringValues(TCID);
	}
	
	@When("User clicks on Signin button")
	public void Sigin()
	{
		//pgLogin.btnLogIn.click();
		pgLogin.ClickSignIN();
	}
	
	@Then("User successfully logged in to the application")
	public void LoginSuccessful()
	{
		pgLogin.checkLoginSuccessful();
	}
	
	@Then("User logs out")
	public void Logout()
	{
		pgLogin.lnkLogout.click();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
