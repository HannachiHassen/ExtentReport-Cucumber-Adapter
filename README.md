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

# Step 3: Create extent.properties file in src/test/resources

- We need to create the extent.properties file at the src/test/resources folder for the grasshopper extent report adapter to recognize it. Using a property file for reporting is quite helpful if you want to define several different properties.

# Step 4: Create a Helper class in src/main/java

- Use Page Object Model with Cucumber and TestNG.

    - Create a Helper class where we are initializing the web driver, initializing the web driver wait, defining the timeouts, and creating a private constructor of the class, within it will declare the web driver, so whenever we create an object of this class, a new web browser is invoked. We are using a setter and getter method to get the object of Chromedriver with the help of a private constructor itself within the same class.
    
# Step 5: Create Locator classes in src/main/java

- Create a locator class for each page that contains the detail of the locators of all the web elements. Here, I’m creating 2 locator classes – LoginPageLocators and HomePageLocators.    

# Step 6: Create Action classes in src/main/java

- Create the action classes for each web page. These action classes contain all the methods needed by the step definitions. In this case, I have created 2 action classes – LoginPageActions and HomePageActions

    - LoginPageActions:

        - In this class, the very first thing will do is to create the object of LoginPageLocators class so that we should be able to access all the PageFactory elements. Secondly, create a public constructor of LoginPageActions class
    
