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
   
2.1 To generate the xml file. Right click the project and convert it to Test NG   

3. Annotations
   a. @BeforeSuite & @AfterSuite -> Suite level method execution
   b. @BeforeTest & @AfterTest -> Test level method execution
   c. @BeforeMethod & @AfterMethod -> Class level method execution. For every method in a class, the pre/post calls can be made
   d. @BeforeClass & @AfterClass -> Class level method execution. a call at beginning and a call at end of a class

4. Groups
   a. App group tag to test method. 
      eg @Test(group="smoke") 
   b. Update the xml to run only methods marked with group tag
      eg: 
      <suite name="RegressionSuite">
        <test  name="AllTest">
            <groups>
    	         <run>
    		         <include name="smoke"/>
    	         </run>
            </groups>
            <classes>
               <class name="test.jdbasics"/>
               <class name="test.sizebasics"/>
            </classes>
        </test>
      </suite> 

5. Annotations Helper Attributes
   1. dependsOnMethod - To execute another methods before current method.
      eg: @Test(dependsOnMethods= {"Demo1"})  
   2. enbaled - This attrib can let TestNG know whether to run to skip a method
      eg: @Test(enabled=false)
   4. timeOut - To set explicitly some time before a method fails
      eg: timeOut=4000 - a method wont fail before 4 seconds
