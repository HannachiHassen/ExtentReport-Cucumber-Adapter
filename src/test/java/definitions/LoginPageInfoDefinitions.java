package definitions;

import org.testng.Assert;

import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HelperClass;

public class LoginPageInfoDefinitions {	
     private static String title;
	
	LoginPageActions objLogin = new LoginPageActions();
    
    @Given("User is on the HRMLogin page {string}")
    public void User_is_on_the_hrm_Login_page(String url) {         
        HelperClass.openPage(url);  
    }
  
    @When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = objLogin.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}
    
    @Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}
    
    @Then("User should be able to see Twitter Icon")
    public void verifyTwitterIcon( ) {         
        Assert.assertTrue(objLogin.getTwitterIcon());
    }
    
    @Then("User should be able to see Youtube Icon")
    public void verifyYoutubeIcon( ) {         
        Assert.assertTrue(objLogin.getYoutubeIcon());
    }   
}
