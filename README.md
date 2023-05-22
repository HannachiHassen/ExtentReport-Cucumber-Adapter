# ExtentReports Version 5 for Cucumber 6 and TestNG

- What is ExtentReport:

     - ExtentReport is a logger-style reporting library for automated tests. ExtentReports uses the logging style to add information about test sessions, such as the creation of tests, adding screenshots, assigning tags, and adding events or series of steps to sequentially indicate the flow of test steps.  ExtentReports 5 is built on an open-Core. That means, both community and professional editions use the same, full-featured API with the exception of a few reporters.

    - Extent Report 4 onwards, there are 2 editions of Extent Report – Core and Professional.

# Generation of ExtentReport 5 in Cucumber6 with TestNG

- Pre-Requisite:
    - Java 8 or higher is needed for ExtentReport5
    - Maven or Gradle
    - JAVA IDE (like Eclipse, IntelliJ, or soon)
    - TestNG installed
    - Cucumber Eclipse plugin (in case using Eclipse)

# Step 1 – Add Maven dependencies to the POM
 - Add ExtentReport dependency
 - Add tech grasshopper maven dependency for Cucumber
 
# Step 2: Create a feature file in src/test/resources/

 - I have also added a failed scenario in @FaceBookLink.

#Step 3: Create extent.properties file in src/test/resources

- We need to create the extent.properties file at the src/test/resources folder for the grasshopper extent report adapter to recognize it. Using a property file for reporting is quite helpful if you want to define several different properties.

# Step 4: Create a Helper class in src/main/java


