package testpages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

import utils.Config;
import utils.ExcelConnection;
import utils.SessionVariables;

import stepDefinition.Hooks;

public class Loginpage  {
    private WebDriver driver;
   // private HashMap<String,String> hm;
    static AccountServicespage pgAccountServicepage;
    public static HashMap<String,String> hm;
    static Connection connection;
	
    public Loginpage()
	{
		this.driver=Hooks.driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]//input[@name='username']")
	public WebElement txtUsername;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]//input[@name='password']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"loginPanel\"]//input[@value='Log In']")
	public WebElement btnLogIn;
	
	@FindBy(xpath="//*[@id='loginPanel']//a[contains(text(),'Forgot login')]")
	public WebElement linkForgotLogin;
	
	@FindBy(xpath="//*[@id='loginPanel']//a[contains(text(),'Register')]")
	public WebElement linkRegister;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/h1")
	public WebElement strCustomerLookup;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]/h1")
	public WebElement lblSignIn;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//h1[contains(text(),'Accounts Overview')]")
	public WebElement lblAccountsOverview;
	
	@FindBy(xpath="//*[@id=\"leftPanel\"]//a[contains(text(),\"Log Out\")]")
	public WebElement lnkLogout;
	
	@FindBy(xpath="//*[@id=\"topPanel\"]//img[@Title=\"ParaBank\"]")
	public WebElement lblParaBank;
	
	public WebElement getPassword()
	{
		return this.txtPassword;
	}
	
	
	
	public boolean LaunchApplication()
	{
		//driver.get(Config.getProperty("ParaBankAppURL"));
		
		SessionVariables.AppURL=Config.getAppURL(SessionVariables.AppName);
		driver.get(SessionVariables.AppURL);
		return false; 
		//lblParaBank.isDisplayed();;
	}
	
	public void EnteringValues(String TCID)
	{
		SessionVariables.TestCaseID=TCID;
		ExcelConnection.queryData(TCID);
		String username=SessionVariables.hm.get("UserName");
		String password=SessionVariables.hm.get("Password");
		this.txtUsername.sendKeys(username);
		this.txtPassword.sendKeys(password);
	}
	
	public void EnteringValuesinternal(String username,String password)
	{
		this.txtUsername.sendKeys("ross123");
		this.txtPassword.sendKeys("rossgeller");
	}
	public void ClickSignIN()
	{
		this.btnLogIn.click();
	}
	
	public void checkLoginSuccessful()
	{
		pgAccountServicepage=new AccountServicespage();
		String lblAccoutOverview=this.lblAccountsOverview.getText().trim();
		//Assert.assertEquals("Accounts Overview", lblAccoutOverview);
		if(lblAccoutOverview.equals("Accounts Overview"))
		{
			System.out.println("AccountsOverview page loaded successfully");
		}
		else
		{
			System.out.println("AccountsOverview page not loaded ");
		}
		
		
	}
	
	
	
	/*public void LoginToApplication(String username,String password)
	{
		this.txtUsername.sendKeys(username);
		this.txtPassword.sendKeys(password);
		this.btnLogIn.click();
		String lblAccoutOverview=this.lblAccountsOverview.getText().trim();
		if(lblAccoutOverview.equals("Accounts Overview"))
		{
			System.out.println("AccountsOverview page loaded successfully");
		}
		else
		{
			System.out.println("AccountsOverview page not loaded ");
		}
		
	}
	*/
	
	public void ForgotPassword()
	{
		this.linkForgotLogin.click();
		String lblCustomerLookup=this.strCustomerLookup.getText().trim();
		if (lblCustomerLookup.equals("Customer Lookup"))
		{
			
			System.out.println("Customer Lookup page loaded successfully");
		}
		else
		{
			System.out.println("Customer Lookup page not loaded ");
		}
		
	}
	
	public void Register()
	{
		this.linkRegister.click();
		String lblSignin=this.lblSignIn.getText().trim();
		if(lblSignin.equals("Signing up is easy!"))
		{
			System.out.println("SigIn loaded successfully");
		}
		else
		{
			System.out.println("SignIn page not loaded ");
		}
	}
	
}
