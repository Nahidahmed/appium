TesntNG

1. Setting up TestNG
   Go to https://testng.org/doc/download.html and section “Eclipse plug-in”.
   Follow the instruction to add the TestNG library to Eclipse

2. Creating TestNG project
   Create a normal JAVA project
   Add a package
   Add a new class to the package
   Remove the default main method
   Create a new public method which returns void
   Add “@Test” above the class
   Hover over “@Test” to add the TestNG library
   Hover over “@Test” to import import org.testng.annotations.Test;
   Now you get option to run the class as a testng 

3. Annotations
   a. @BeforeSuite & @AfterSuite -> Suite level method execution
   b. @BeforeTest & @AfterTest -> Test level method execution
   c. @BeforeMethod & @AfterMethod
