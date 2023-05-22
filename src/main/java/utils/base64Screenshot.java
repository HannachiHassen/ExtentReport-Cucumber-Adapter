package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base64Screenshot {

	public static String getBase64Screenshot() {
		return ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
