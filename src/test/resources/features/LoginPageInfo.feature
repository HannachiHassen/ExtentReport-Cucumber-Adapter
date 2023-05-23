
@SmokeTest
Feature: HRM Application Login Inof 

   @PageTitle
   Scenario: Verify Login Page Title
   
	 Given User is on the HRMLogin page "https://opensource-demo.orangehrmlive.com/"
	 When user gets the title of the page
   Then page title should be "OrangeHRM"
    
   @TwitterLink
   Scenario: Verify Twitter Icon on Login Page
      
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
    Then User should be able to see Twitter Icon
     
   @YoutubeLink
   Scenario: Verify Youtube Icon on Login Page
      
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
    Then User should be able to see Youtube Icon    
