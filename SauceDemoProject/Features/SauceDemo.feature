Feature: Sauce Demo Login Page 
 Scenario Outline: Validating user credentials
  Given User is on login page of sauce demo page "https://www.saucedemo.com/"
  When User enters UserName "<username>" and Password "<password>"
  And User clicks on log in button 
  Then User should be navigated to Home page 
  And Verify the title of page as "Swag Labs"
  When User clicks on log out button 
  Then User should be logged out and navigated to log in page
  And Verify the title of page as "Swag Labs"
  
 Examples:
 | username | password |
 | standard_user   | secret_sauce |
 | visual_user | secret_sauce |