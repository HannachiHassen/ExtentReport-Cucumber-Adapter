package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
	features = "src/test/resources/features/LoginPage.feature", 
			dryRun=false,
			monochrome = true,
	glue = "definitions",
	plugin = {"pretty",
			"json:target/cucumber-reports/Cucumber.json",
			"html:target/cucumber-reports/Cucumber-report.html",
			"junit:target/cucumber-reports/cucumber-report.xml",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    publish = true
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}