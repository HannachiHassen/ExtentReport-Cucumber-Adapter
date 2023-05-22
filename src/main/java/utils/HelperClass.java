package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	private static HelperClass helperClass;

	private static WebDriver driver;
	private static WebDriverWait wait;
	public final static int TIMEOUT = 20;

	private HelperClass() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();
	}

	public static void openPage(String url) {
		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		if (helperClass == null) {
			helperClass = new HelperClass();
		}
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			//driver.quit();
		}
		
		helperClass = null;
	}

}
