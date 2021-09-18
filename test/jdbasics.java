package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//TestNG will execute method in alphabetical order
public class jdbasics {

	@Parameters({"Username","Password"})
	@Test
	public void PassParamMethod(String usr, String pwd) {
		System.out.println(usr);
		System.out.println(pwd);
	}
	
	@Test(groups="smoke",timeOut=4000)//dont fail the method till 4 seconds
	public void Demo1() {
		System.out.println("Demo1(): Hello JD");
	}

	@Test
	public void DependentMethod() {
		System.out.println("DependentMethod():  Is called first before ADemo3()");
	}
	
	@Test(enabled=false)
	public void ADemo2() {
		System.out.println("ADemo2(): Hello JD, Again");
	}

	@Test(dependsOnMethods= {"DependentMethod"})
	public void ADemo3() {
		System.out.println("ADemo3(): Is executed after dependent methods");
	}
	
	@BeforeTest(enabled=false)
	public void AnyprerequisiteTasks() {
		System.out.println("This will execute first because it has BeforeTest annotation.");
	}

	@AfterTest(enabled=false)
	public void AnyCleanupTasks() {
		System.out.println("This will execute at the end because it has AfterTest annotation.");
	}
	
	@BeforeSuite(enabled=false)
	public void AnyprerequisiteTasks_SuiteLevel() {
		System.out.println("Suite level - first test.");
	}

	@AfterSuite(enabled=false)
	public void AnyCleanupTasks_SuiteLevel() {
		System.out.println("Suite level - last test.");
	}
	
	@BeforeMethod(enabled=false)
	public void PreMethodCall() {
		System.out.println("JD Pre Method call");
	}
	@AfterMethod(enabled=false)
	public void PostMethodCall() {
		System.out.println("JD Post Method call");
	}

	@BeforeClass(enabled=false)
	public void FirstClassCall() {
		System.out.println("First call in JD Test Class");
	}
	@AfterClass(enabled=false)
	public void LastClassCall() {
		System.out.println("Last call in JD Test Class");
	}

	@DataProvider
	public Object[][] getData() {
		//1st combo -> username & pwd -> good credit history
		//2nd combo -> username & pwd -> no credit history
		//3rd combo -> username & pwd -> fradulent past
		Object[][] data = new Object[3][2];
		
		data[0][0] = "nahid@jdplc.com";
		data[0][1] = "123456qw";
				
		data[1][0] = "nahid@size.com";
		data[1][1] = "123456er";

		data[2][0] = "nahid@hip.com";
		data[2][1] = "123456ty";
		
		return data;
	}
	
	@Test(dataProvider="getData")
	public void ConsumeData(String usr, String pwd)
	{
		System.out.println(usr);
		System.out.println(pwd);
		
	
	}

}
