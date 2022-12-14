package testpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinition.Hooks;
import stepDefinition.WebDriverSet;


public class AccountServicespage {

	private WebDriver driver;
	static WebDriverSet wds;
	static Loginpage pgLogin;
	public AccountServicespage()
	{
		this.driver=Hooks.driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id=\"leftPanel\"]//a[contains(text(),'Open New Account')]")
	public WebElement lnkNewAccount;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Accounts Overview')]")
	public WebElement lnkAccountOverview;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Transfer Funds')]")
	public WebElement lnkTransferFunds;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Bill Pay')]")
	public WebElement lnkBillPay;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Find Transactions')]")
	public WebElement lnkFindTransactions;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Update Contact Info')]")
	public WebElement lnkContact;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Request Loan')]")
	public WebElement lnkLoan;
	
	@FindBy(xpath="//*[@id='leftPanel']//a[contains(text(),'Log Out')]")
	public WebElement lnkLogout;
	
	@FindBy(xpath="//*[@id='rightPanel']//h1[contains(text(),'Bill Payment Service')]")
	public WebElement lblBillPayService;
	
	
	public WebElement getlnkBillPay()
	{
		return this.lnkBillPay;
	}
	
	public WebElement getlblBillPayService()
	{
		return this.lblBillPayService;
	}
	public void BillPayclick()
	{
		//wds=new WebDriverSet();
		//driver=pgLogin.driver;
		this.lnkBillPay.click();
		String lblBillPayPage=this.lblBillPayService.getText().trim();
		if(lblBillPayPage.equals("Bill Payment Service"))
		{
			
				System.out.println("Bill Payment Page Opened");
			}
			else
			{
				System.out.println("Bill Payment page not opened");
			}
		}
}
