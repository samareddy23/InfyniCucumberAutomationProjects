Feature: This feature runs for login page
  
@validlogin @logintest
 Scenario: User should login successfully with valid data
    Given User is in login page
    When User enters email id "proqa2019@gmail.com"
    And User enters password "Test@123"
    And User clicks on SignIn Button
    Then User should see All projects page
    
@invalidlogin @logintest
Scenario Outline: User should not login with Invalid data
    Given User is in login page
    When User enters email id "<EmailId>"
    And User enters password "<Password>"
    And User clicks on SignIn Button
    Then User should not see All projects page
   
Examples:

|EmailId|Password|
|prashanthi@gmail.com|Test@123|
|test4562@gmail.com|Test123|
|test8765@gmail.com|Test@123|
      