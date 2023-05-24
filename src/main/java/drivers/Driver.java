package drivers;

import java.util.Objects;

import enums.ConfigProperties;
import exceptions.BrowserInvocationFailedException;
import factories.DriverFactory;
import utils.PropertyUtlis;

public final class Driver {

	private Driver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (Exception e) {
				throw new BrowserInvocationFailedException("Please check the capabilities of browser");
			}
			DriverManager.getDriver().get(PropertyUtlis.get(ConfigProperties.URL));
		}
	}
	
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
