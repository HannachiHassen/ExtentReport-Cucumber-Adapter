package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	public HomePageLocators() {	}
	
	@FindBy(id = "welcome")
    public  WebElement homePageUserName;
}
