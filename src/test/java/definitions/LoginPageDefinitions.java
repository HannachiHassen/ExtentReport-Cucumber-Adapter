package definitions;

import org.testng.Assert;

import actions.HomePageActions;
import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HelperClass;

public class LoginPageDefinitions {

	LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();
    
    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
        HelperClass.openPage(url);
    }
    
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String useName, String passWord) {
    	// login to application
    	objLogin.login(useName, passWord);        
    }
    
    @Then("User should be able to login sucessfully and new page open")
    public void verifyLogin() {
        Assert.assertTrue(objHomePage.getHomePageText().contains("Welcome"));
    }
    
    @Then("User should be able to see error message {string}")
    public void VerifyyErrormessage(String expectedErrorMessage) {
        Assert.assertEquals(objLogin.getErrorMessage(), expectedErrorMessage);
    }
    
    @Then("User should be able to see FaceBook Icon")
    public void verifyFacebookIcon() {
    	Assert.assertTrue(objLogin.getFaceBookIcon());
    }
    
    @Then("User should be able to see LinkedIn Icon")
    public void verifyLinkedInIcon() {
        Assert.assertTrue(objLogin.getLinkedInIcon());
    }    
}
