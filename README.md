# ExtentReports Version 5 for Cucumber 6 and TestNG

## ## Background

Cucumber is a test automation tool following the principles of Behavioural Driven Design and living documentation. Specifications are written in a concise human readable form and executed in continuous integration.

## What is ExtentReport:

   - ExtentReport is a logger-style reporting library for automated tests. ExtentReports uses the logging style to add information about test sessions, such as the creation of tests, adding screenshots, assigning tags, and adding events or series of steps to sequentially indicate the flow of test steps.  ExtentReports 5 is built on an open-Core. That means, both community and professional editions use the same, full-featured API with the exception of a few reporters.

   - Extent Report 4 onwards, there are 2 editions of Extent Report – Core and Professional.

# Generation of ExtentReport 5 in Cucumber6 with TestNG

- Pre-Requisite:
    - [Java](https://www.oracle.com/java/) 8 * or higher is needed for ExtentReport5
    - [Maven](https://maven.apache.org/) or Gradle - Dependency Management 
    - JAVA IDE - (like [Eclipse](https://www.eclipse.org/), IntelliJ, or soon)
    - [TestNG](https://testng.org/) installed - Testing Framework
    - Cucumber Eclipse plugin (in case using Eclipse)

## Step 1 – Add Maven dependencies to the POM
 Add ExtentReport maven dependency
 
 ```xml
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.0.9</version>
</dependency>
```

 - Add tech grasshopper maven dependency for Cucumber
 
 ```xml
 <dependency>
    <groupId>tech.grasshopper</groupId>
    <artifactId>extentreports-cucumber6-adapter</artifactId>
    <version>2.13.0</version>
</dependency>
```

- Check The complete POM.xml for other Selenium and TestNG dependencies 

## Step 2: Create a feature file in src/test/resources/

 - I have also added a failed scenario in @FaceBookLink.

## Step 3: Create extent.properties file in src/test/resources

- We need to create the extent.properties file at the src/test/resources folder for the grasshopper extent report adapter to recognize it. Using a property file for reporting is quite helpful if you want to define several different properties.

## Step 4: Create a Helper class in src/main/java

- Use Page Object Model with Cucumber and TestNG.

    - Create a Helper class where we are initializing the web driver, initializing the web driver wait, defining the timeouts, and creating a private constructor of the class, within it will declare the web driver, so whenever we create an object of this class, a new web browser is invoked. We are using a setter and getter method to get the object of Chromedriver with the help of a private constructor itself within the same class.
    
## Step 5: Create Locator classes in src/main/java

- Create a locator class for each page that contains the detail of the locators of all the web elements. Here, I’m creating 2 locator classes – LoginPageLocators and HomePageLocators.    

## Step 6: Create Action classes in src/main/java

- Create the action classes for each web page. These action classes contain all the methods needed by the step definitions. In this case, I have created 2 action classes – LoginPageActions and HomePageActions

    - LoginPageActions:

        - In this class, the very first thing will do is to create the object of LoginPageLocators class so that we should be able to access all the PageFactory elements. Secondly, create a public constructor of LoginPageActions class
    
## Step 7: Create a Step Definition file in src/test/java

- Create the corresponding Step Definition file of the feature file.

## Step 8: Create Hook class in src/test/java

- Create the hook class that contains the Before and After hook. @Before hook contains the method to call the setup driver which will initialize the chrome driver. This will be run before any test.

     - After Hook – Here will call the tearDown method.
   
## Step 9: Create a Cucumber Test Runner class in src/test/java

- Add the extent report cucumber adapter to the runner class’s CucumberOption annotation. It is an important component of the configuration. It also ensures that the cucumber runner class recognizes and launches the extent report adapter for cucumber. Please add the following text as a plugin to the CucumberOptions as described below:
	
    - plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
  
## Step 10: Create the testng.xml for the project

- Right-click on the project and select TestNG -> convert to TestNG.
    
## Step 11: Execute the code
- Right-Click on the Runner class and select Run As -> TestNG Test.

## Step 12: View ExtentReport

- Refresh the project and will see a new folder – test-reports. 
- The Spark ExtentReport will be present in test-reports/SparkReport folder with the name Spark.html
- The PDF ExtentReport will be present in test-reports/PDFReport folder with the name ExtentPdf.pdf

   - Right-click and open with Web Browser.

    - The report also has a summary section that displays the summary of the execution. The summary includes the overview of the pass/fail using a pictogram, start time, end time, and pass/fail details of features. 
    
     - Click on the first icon present on the left side of the report. To view the details about the steps, click on the scenarios. Clicking on the scenario will expand, showing off the details of the steps of each scenario.
     
## Step 13: How to customize the report folder name
 - We learned how to generate an ExtentReport in Cucumber Junit in the previous section. The problem with the previous approach is that it will continue to override the previous report once the new report is created. Typically, we must keep a backup of all the reports generated by previous tests. To accomplish this, we must save each report with a unique report name or folder name.

- It’s simple to create reports with different folder names using the Extent reporter plugin adapter. Two settings must be added to our extent. basefolder.name and basefolder.datetimepattern are properties files. The values assigned to these will be combined to form a folder name. As a result, a report will be generated within that. The basefolder.datetimepattern value must be in a valid date-time format.

Let us update the extent.properties file.


```properties
extent.reporter.spark.start=true
extent.reporter.spark.out=SparkReport/Spark.html
 
#FolderName
basefolder.name=test-reports/reports
basefolder.datetimepattern=d-MMM-YY HH-mm-ss
```

- The value for basefolder.name in the preceding snippet is “Report/SparkReport.” It means that the folder will be named SparkReport, and that it will create a Report folder within the project directory. 
- You can specify the location of your folder. In the following setting, we’ve used a date and time stamp to create unique folder names by concatenating them with the report name.

- Check extent.properties for more setting for PDF reports, and how to display systeminof in the spark extent report.

Congratulation!! We are able to create an Extent Report for Cucumber. Happy Learning!!!

# Update 5/25/2023
This update allows you to publish the results of a cucumber run as pretty html reports. In order for this to work you must generate a cucumber json report. The project converts the json report into an overview html linking to separate feature files with stats and results.

## Publish pretty [cucumber](https://cucumber.io/) reports

This is a Java report publisher primarily created to publish cucumber reports on the Jenkins build server.
It publishes pretty html reports with charts showing the results of cucumber runs. It has been split out into a standalone package so it can be used for Jenkins and maven command line as well as any other packaging that might be useful. Generated report has no dependency so can be viewed offline.

## Install

Add a maven dependency to your pom.xml
```xml
<dependency>
    <groupId>net.masterthought</groupId>
    <artifactId>cucumber-reporting</artifactId>
    <version>(check version above)</version>
</dependency>
```
Read this if you need further [detailed configuration](https://github.com/jenkinsci/cucumber-reports-plugin/wiki/Detailed-Configuration) instructions for using the Jenkins version of this project

## Usage
```Java
File reportOutputDirectory = new File("target");
List<String> jsonFiles = new ArrayList<>();
jsonFiles.add("cucumber-report-1.json");
jsonFiles.add("cucumber-report-2.json");

String buildNumber = "1";
String projectName = "cucumberProject";

Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration - check javadoc for details
configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
// do not make scenario failed when step has status SKIPPED
configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
configuration.addClassifications("Platform", "Windows");
configuration.addClassifications("Browser", "Firefox");
configuration.addClassifications("Branch", "release/1.0");

// optionally add metadata presented on main page via properties file
List<String> classificationFiles = new ArrayList<>();
classificationFiles.add("properties-1.properties");
classificationFiles.add("properties-2.properties");
configuration.addClassificationFiles(classificationFiles);

// optionally specify qualifiers for each of the report json files
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
        configuration.setQualifier("cucumber-report-1","First report");
        configuration.setQualifier("cucumber-report-2","Second report");

        ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
        Reportable result=reportBuilder.generateReports();
// and here validate 'result' to decide what to do if report has failed
```
There is a feature overview page:

![feature overview page](./.README/feature-overview.png)

And there are also feature specific results pages:

![feature specific page passing](./.README/feature-passed.png)

And useful information for failures:

![feature specific page passing](./.README/feature-failed.png)

If you have tags in your cucumber features you can see a tag overview:

![Tag overview](./.README/tag-overview.png)

And you can drill down into tag specific reports:

![Tag report](./.README/tag-report.png)

![Trends report](./.README/trends.png)

## Versioning

For the versions available, see the [tags on this repository](https://github.com/HannachiHassen/project/tags). 

## Authors

* **Hassen Hannachi** - *Initial work* - [HassenHannachi](https://github.com/HannachiHassen)

## License

This project is not under any License - Open source 
