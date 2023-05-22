package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

	public LoginPageLocators() {
		
	}
	
	@FindBy(name = "txtUsername")
    public WebElement userName;
  
    @FindBy(name = "txtPassword")
    public WebElement password;
  
    @FindBy(id = "logInPanelHeading")
    public WebElement titleText;
  
    @FindBy(id = "btnLogin")
    public WebElement login;
  
    @FindBy(id = "spanMessage")
    public  WebElement errorMessage;
     
    @FindBy(xpath = "//*[@id='social-icons']/a[1]/img")
    public  WebElement linkedInIcon;
     
    @FindBy(xpath = "//*[@id='social-icons']/a[6]/img")  //Invalid Xpath
    public  WebElement faceBookIcon;
}
