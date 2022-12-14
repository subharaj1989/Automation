package stepDefinition;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testpages.AccountServicespage;
import testpages.BillPaypage;
import testpages.Loginpage;
import stepDefinition.WebDriverSet;
import utils.SessionVariables;

public class BillPaysteps {

	static WebDriver driver;
	static Loginpage pgLogin;
	static BillPaypage pgbillpay;
	static AccountServicespage pgAccountServicepage;
	static WebDriverSet wds;

	ArrayList<String> BillPaylist = new ArrayList<String>();
	String strEmptyValue;

	
	

	@Given("the user clicks the Bill Pay link under Account Services")
	public void ClickBillPay() {
		
		pgbillpay = new BillPaypage();
		pgbillpay.BillPayclick();
	}

	@Given("User enters Payee Name {string}")
	public void payeename(String TCID) {
		String name=SessionVariables.hm.get("Payee_Name");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "Payee";
		}
	}

	@Given("User enters Street Name")
	public void StreetName() {
		 String name=SessionVariables.hm.get("Address_Street");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "Address";
		}
	}

	@Given("User enters City")
	public void City() {
		String name=SessionVariables.hm.get("City");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "City";
		}
	}

	@Given("User enters State")
	public void State() {
		String name=SessionVariables.hm.get("State");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "State";
		}
	}

	@Given("User enters Zip Code")
	public void ZipCode() {
		String name=SessionVariables.hm.get("ZipCode");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "Zip Code";
		}
	}

	@Given("User enters Phone Number")
	public void PhoneNumber() {
		String name=SessionVariables.hm.get("Phone_number");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "Phone number";
		}
	}

	@Given("User enters Account Number")
	public void AccountNumber() {
		String name=SessionVariables.hm.get("Account_Number");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "Account number";
		}
	}

	@Given("User enters Verify Account Number")
	public void VerifyAccountNumber() {
		String name=SessionVariables.hm.get("Verify_Account");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "Account number";
		}
	}

	@Given("User enters Amount")
	public void Amount() {
		String name=SessionVariables.hm.get("Amount");
		BillPaylist.add(name);
		if (name.isEmpty()) {
			strEmptyValue = "amount";
		}
	}

	@Given("User enters Account type")
	public void Accounttype() {
		String name=SessionVariables.hm.get("Account_type");
		BillPaylist.add(name);
	}

	@When("User clicks Submit button")
	public void clickpaybill() {
		pgbillpay.PayBill(BillPaylist);
	}

	@Then("Bill pay successful label appears")
	public void successfulBillPay() {
		pgbillpay.BillPaymentSuccessful(BillPaylist.get(8));
		
	}

	@Then("Error message appears")
	public void errormessge() {
		pgbillpay.error(strEmptyValue);
		//driver.quit();
	}
}
