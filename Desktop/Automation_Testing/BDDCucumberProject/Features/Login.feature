Feature: Login to SauceDemo website 
  Scenario: Testing login functionality 
    Given User is on login page of "https://www.saucedemo.com/"
    When User enters credentials as 
       | standard_user | secret_sauce |
    And User clicks on login button 
    Then User should navigate to Home page
    And User must validate the Home page title 
    And User logs out   
       