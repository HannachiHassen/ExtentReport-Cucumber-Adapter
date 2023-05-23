package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
	features = "src/test/resources/features", 
			dryRun=false,
			monochrome = true,
	glue = "definitions",
	plugin = {"pretty",
			"json:test-reports/cucumber-reports/Cucumber.json",
			"html:test-reports/cucumber-reports/Cucumber-report.html",
			"junit:test-reports/cucumber-reports/cucumber-report.xml",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread/"
			}
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}