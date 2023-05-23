package actions;

import org.openqa.selenium.support.PageFactory;

import locators.LoginPageLocators;
import utils.HelperClass;

public class LoginPageActions {
	LoginPageLocators loginPageLocators = null; 
    
    public LoginPageActions() { 
        this.loginPageLocators = new LoginPageLocators(); 
        PageFactory.initElements(HelperClass.getDriver(),loginPageLocators);
    }
 
    // Set user name in textbox
    public void setUserName(String strUserName) {
        loginPageLocators.userName.sendKeys(strUserName);
    }
  
    // Set password in password textbox
    public void setPassword(String strPassword) {
        loginPageLocators.password.sendKeys(strPassword);
    }
  
    // Click on login button
    public void clickLogin() {
        loginPageLocators.login.click();
    }
  
    // Get the title of Home Page
    public String getLoginTitle() {
        return loginPageLocators.titleText.getText();
    }    
    
    // Get the title of Login Page
    public String getLoginPageTitle() {
		return HelperClass.getDriver().getTitle();
	}
     
    // Get the login error message
    public String getErrorMessage() {
        return loginPageLocators.errorMessage.getText();
        
    }
    
    // Get the credentials error message 
    public String getErrorCredentials() {
    	return loginPageLocators.invalidCredentials.getText();
    }
     
    // LinkedIn Icon is displayed
    public Boolean getLinkedInIcon() {    
        return loginPageLocators.linkedInIcon.isDisplayed();
    }
     
    // FaceBook Icon is displayed
    public Boolean getFaceBookIcon() {    
        return loginPageLocators.faceBookIcon.isDisplayed();
    }
    
    // Twitter Icon is displayed
    public Boolean getTwitterIcon() {    
        return loginPageLocators.twitterIcon.isDisplayed();
    }
     
    // FaceBook Icon is displayed
    public Boolean getYoutubeIcon() {    
        return loginPageLocators.youtubeIcon.isDisplayed();
    }
  
    public void login(String strUserName, String strPassword) {
  
        // Fill user name
        this.setUserName(strUserName);
  
        // Fill password
        this.setPassword(strPassword);
  
        // Click Login button
        this.clickLogin();  
    }
}
