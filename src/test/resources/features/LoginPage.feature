#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios

#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
	
Feature: Login to HRM Application 
  
   @ValidCredentials
   Scenario: Login with valid credentials
      
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login sucessfully and new page open
     
   @InvalidCredentials
   Scenario Outline: Login with invalid credentials
      
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"
     
  Examples:
  | username   | password    | errorMessage                           |
  |                   | abc              | Required     |
  | admin        |                    | Required          |
  |                   |                    | Required          |
  | Admin       | admin12$$ | Invalid credentials               |
  | admin$$    | admin123   | Invalid credentials               |
     
  @FaceBookLink
  Scenario: Verify FaceBook Icon on Login Page
      
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
    Then User should be able to see FaceBook Icon
     
  @LinkedInLink
  Scenario: Verify LinkedIn Icon on Login Page
      
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
    Then User should be able to see LinkedIn Icon  