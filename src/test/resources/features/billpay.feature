
 @BillPay     
 Feature: Validate BillPay functionality
   Background:
      Given User is on the login page
      And User enters valid username and password "TC_005_BillPay" in User and password textbox
      And User clicks on Signin button
      And User successfully logged in to the application
   Scenario Outline: Enter all valid data in the textboxes and click submit
      Given the user clicks the Bill Pay link under Account Services
      And User enters Payee Name "<TCID>"
      And User enters Street Name 
      And User enters City 
      And User enters State 
      And User enters Zip Code
      And User enters Phone Number
      And User enters Account Number
      And User enters Verify Account Number
      And User enters Amount
      And User enters Account type
      When User clicks Submit button
      Then Bill pay successful label appears
      And User logs out
  
   Examples:
    |TCID|
    |TC_005_BillPay|
     
   Scenario Outline: Enter invalid data in the textboxes and click submit
      Given the user clicks the Bill Pay link under Account Services
      And User enters Payee Name "<TCID>"
      And User enters Street Name 
      And User enters City
      And User enters State 
      And User enters Zip Code 
      And User enters Phone Number 
      And User enters Account Number
      And User enters Verify Account Number
      And User enters Amount 
       And User enters Account type
      When User clicks Submit button
      Then Error message appears
      And User logs out
      
  
   Examples:
      |TCID|
      |TC_006_InValidBillPay|
  