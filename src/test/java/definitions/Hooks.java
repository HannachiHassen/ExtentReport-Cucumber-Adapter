package definitions;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.HelperClass;
import static utils.ScreenshotUtils.*;

public class Hooks {

	@Before
    public static void setUp() { 
       HelperClass.setUpDriver();
    }
     
    @After
    public static void tearDown(Scenario  scenario) { 
    	if (scenario.isFailed()) {
    		ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, 
    				MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
    	}
    	
        HelperClass.tearDown();
    }
}