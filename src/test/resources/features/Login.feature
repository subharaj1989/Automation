
Feature: Validate Login Functionality
@E2E
  Scenario Outline: Validate user login credentials
    Given User is on the login page
    And User enters valid username and password "<TCID>" in User and password textbox "<password>"
    When User clicks on Signin button
    Then User successfully logged in to the application
    #And User logs out
    
    
    Examples:
    |TCID|
    |TC_003_Login|
    
    
  
   