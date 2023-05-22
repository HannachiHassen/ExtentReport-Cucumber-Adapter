package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	@FindBy(name = "username")
    public WebElement userName;
  
    @FindBy(name = "password")
    public WebElement password;  
  
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement login;
    
    @FindBy(id = "logInPanelHeading")
    public WebElement titleText;
  
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']") 
    public  WebElement errorMessage;  
    
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']") 
    public WebElement invalidCredentials;
     
    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']//*[name()='svg']")
    public  WebElement linkedInIcon;
     
    @FindBy(xpath = "//*[@id='social-icons']/a[6]/img")  //Invalid Xpath
    public  WebElement faceBookIcon;
}
