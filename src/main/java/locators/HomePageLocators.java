package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
    public  WebElement homePageName;
}
