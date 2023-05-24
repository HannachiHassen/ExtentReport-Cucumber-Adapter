package factories;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertyUtlis;

public final class DriverFactory {
	
	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver = null;
		if (browser.equalsIgnoreCase(PropertyUtlis.get(ConfigProperties.BROWSER))) {			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(PropertyUtlis.get(ConfigProperties.BROWSER))) {			
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase(PropertyUtlis.get(ConfigProperties.BROWSER))) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
		}
		return driver;
	}
}
