package testpages;
import testpages.AccountServicespage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinition.Hooks;

public class BillPaypage 
{
	
	private WebDriver driver;
	Select Accounttype;
	static AccountServicespage pgAccountServicepage;
	public BillPaypage()
	{
		this.driver=Hooks.driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.name']")
	public WebElement txtPayeeName;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.address.street']")
	public WebElement txtAddressStreet;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.address.city']")
	public WebElement txtCity;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.address.state']")
	public WebElement txtState;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.address.zipCode']")
	public WebElement txtZipcode;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.phoneNumber']")
	public WebElement txtphoneNumber;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='payee.accountNumber']")
	public WebElement txtAccountNumber;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='verifyAccount']")
	public WebElement txtVerifyAccount;
	
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@name='amount']")
	public WebElement txtAmount;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//select[@name='fromAccountId']")
	public WebElement dropdownfromAccount;
	
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//input[@value='Send Payment']")
	public WebElement btnSendPayment;
	
	@FindBy(xpath="//*[@id=\"rightPanel\"]//h1[contains(text(),'Bill Payment Complete')]")
	public WebElement lblBillPayComplete;
	
	@FindBy(xpath="//*[@id='rightPanel']//p[contains(text(),'Bill Payment to')]")
	public WebElement lblBillPayAmount;
	
	@FindBy(xpath="//*[@id='rightPanel']//span[@class='error']")
	public List<WebElement> lblErrormessage;
	
	
			
	public void BillPayclick()
	{
		pgAccountServicepage=new AccountServicespage();
		pgAccountServicepage.lnkBillPay.click();
		String lblBillPayPage=pgAccountServicepage.getlblBillPayService().getText().trim();
		if(lblBillPayPage.equals("Bill Payment Service"))
		{
			
				System.out.println("Bill Payment Page Opened");
			}
			else
			{
				System.out.println("Bill Payment page not opened");
			}
	}
	
	
	public void PayBill(ArrayList<String> BillPaylist)
	{
		Accounttype=new Select(this.dropdownfromAccount);
		this.txtPayeeName.sendKeys(BillPaylist.get(0));
		this.txtAddressStreet.sendKeys(BillPaylist.get(1));
		this.txtCity.sendKeys(BillPaylist.get(2));
		this.txtState.sendKeys(BillPaylist.get(3));
		this.txtZipcode.sendKeys(BillPaylist.get(4));
		this.txtphoneNumber.sendKeys(BillPaylist.get(5));
		this.txtAccountNumber.sendKeys(BillPaylist.get(6));
		this.txtVerifyAccount.sendKeys(BillPaylist.get(7));
		this.txtAmount.sendKeys(BillPaylist.get(8));
		this.Accounttype.selectByIndex(Integer.parseInt(BillPaylist.get(9)));
		String strAmounttoPay=txtAmount.getText();
		this.btnSendPayment.click();
		
		
	}
	
	public void BillPaymentSuccessful(String strAmounttoPay)
	{

		String lblBillPay=this.lblBillPayComplete.getText().trim();
		if(lblBillPay.equals("Bill Payment Complete"))
		{
			String strBillPaid=this.lblBillPayAmount.getText();
			if(strBillPaid.contains(strAmounttoPay))
			{
				System.out.println("Bill Payment Successful");
			}
			else
			{
				System.out.println("Bill Payment failed");
			}
		}
	}
	
	public void error(String errormessage)
	{
		//List<WebElement> lblErrormessage;
		//lblErrormessage=driver.findElements(By.xpath("//*[@id='rightPanel']//span[@class='error']"));
		for(int i=0;i<lblErrormessage.size();i++)
		{
			if(lblErrormessage.get(i).getText().contains(errormessage))
              {
				System.out.println(lblErrormessage.get(i).getText()+ "is displayed&&&&&%%%");
	             break;
              }
			else
			{
				System.out.println(errormessage+" Error message not printed&&&&%%%");
			}

		}
	}
	

}
