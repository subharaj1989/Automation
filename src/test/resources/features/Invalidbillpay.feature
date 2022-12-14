
   
 Feature: Validate BillPay functionality
   #Background:
      #Given User is on the login page
      #And User enters valid username "<username>" and password "<password>" in User and password textbox
      #And User clicks on Signin button
      #And User successfully logged in to the application
      
   @BillPay1 
   Scenario Outline: Enter invalid data in the textboxes and click submit
      Given User is on the login page
      And User enters valid username "<username>" and password "<password>" in User and password textbox
      And User clicks on Signin button
      And User successfully logged in to the application
      And the user clicks the Bill Pay link under Account Services
      And User enters Payee Name "<Payee_Name>"
      And User enters Street Name "<Street>"
      And User enters City "<City>"
      And User enters State "<State>"
      And User enters Zip Code "<Zipcode>"
      And User enters Phone Number "<Phonenumber>"
      And User enters Account Number"<AccountNumber>"
      And User enters Verify Account Number"<VerifyAccountNumber>"
      And User enters Amount "<Amount>"
       And User enters Account type"<Accounttype>"
      When User clicks Submit button
      Then Error message appears
      And User logs out
  
   Examples:
      |username|password|Payee_Name|Street|City|State|ZipCode|Phonenumber|AccountNumber|VerifyAccountNumber|Amount|Accounttype|
      |ross123|rossgeller| |AAA|NewYork|New York|123|1234567|33333|33333|100|0|
      
  
  
  