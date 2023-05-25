package runner;

import org.testng.annotations.AfterSuite;

import utils.ReportingUtils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = ("@ValidCredentials or @FaceBookLink and not LinkedInLink"),
		features = {"src/test/resources/features/LoginPage.feature"}, 
			dryRun=false,
			monochrome = true,
	glue = {"definitions"},
	plugin = {"pretty",
			"json:target/cucumber.json",
			"html:target/cucumber-report.html",
			"junit:target/cucumber-report.xml",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread/"
			}	
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	 @AfterSuite
     public void generateReport(){
             ReportingUtils.generateJVMReport();
     }
}