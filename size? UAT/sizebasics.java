import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class sizebasics extends sizebase {
	
	public static String phoneNumber = "9395555111";
	public static String password = "123456qw";
	public static String add1 = "one";
	public static String add2 = "two";
	public static String town = "Manchester";
	public static String county = "Bury";
	public static String postcode = "BL98RR";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		driver.findElementsByClassName("android.widget.RelativeLayout").get(0).click();
		driver.findElementById("com.size.debug:id/continue_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		                       
		Thread.sleep(10000);
		
		//**** UNCOMMENT ANY ONE TEST CASE THAT YOU WANT TO VERIFY ****

		//--Test Case 1
		//--Login as size access member via Bottom navigation
		//acces_loging_via_bottom_nav(driver);
		//---End of Test Case 1

		//--Test Case 2
		//--Login via My Account
		//login_via_my_account(driver);
		//--End of Test Case 2

		//--Test Case 3
		//--Create a new user via My Account
		//	Provide unique firstName and LastName
		//create_new_user_via_my_account(driver,"firstName","LastName");
		//--End of Test Case 3
		
		//--Test Case 4
		//--After a member logs in, Access size?access membership via 
		//	a. My Account banner
		//	b. More -> size?access menu item
		//  c. Size?Access Bottom Navigation item
		//check_size_access_membership(driver);
		//--End of Test Case 4
		
		//--Test Case 5
		//--Registration for size?access membership
		//  Provide unique firstName and LastName
		//register_size_access_membership(driver,"firstName","LastName");
		//--End of Test Case 5
	}

	private static void acces_loging_via_bottom_nav(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		driver.findElementById("com.size.debug:id/menu_loyalty").click();
		Thread.sleep(5000);
		driver.findElementsByClassName("android.widget.ImageView").get(2).click();
		driver.findElementById("com.size.debug:id/jdx_unlimited_sign_in").click();
		
		driver.findElementById("com.size.debug:id/customer_login_email_address_value").sendKeys("userone@size.com");
		driver.findElementById("com.size.debug:id/customer_login_password_value").sendKeys(password);
		driver.findElementById("com.size.debug:id/customer_login_login_button").click();
	}

	private static void login_via_my_account(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		driver.findElementById("com.size.debug:id/menu_more").click();
		driver.findElements(By.id("com.size.debug:id/more_menu_item_container")).get(0).click();
                                        
		driver.findElementByXPath("//android.widget.EditText[@text='Email address']").sendKeys("userone@size.com");
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys("123456qw");
		
		
		driver.findElementById("com.size.debug:id/customer_login_login_button").click();
		
	}

	private static void create_new_user_via_my_account(AndroidDriver<AndroidElement> driver,String firstName,String lastName) throws InterruptedException {
		driver.findElementById("com.size.debug:id/menu_more").click();
		//driver.findElementsByClassName("android.widget.RelativeLayout").get(0).click();
		driver.findElements(By.id("com.size.debug:id/more_menu_item_container")).get(0).click();
                                        
		driver.findElement(By.id("com.size.debug:id/customer_create_account_button")).click();
		
		String email = firstName + lastName + "@size.com";
	    
	    driver.findElement(By.id("com.size.debug:id/customer_new_first_name")).sendKeys(firstName);
		driver.findElement(By.id("com.size.debug:id/customer_new_last_name")).sendKeys(lastName);
		driver.findElement(By.id("com.size.debug:id/customer_new_email_address")).sendKeys(email);
		driver.findElement(By.id("com.size.debug:id/customer_new_password")).sendKeys(password);
		driver.findElement(By.id("com.size.debug:id/customer_new_password_verify")).sendKeys(password);
		driver.findElement(By.id("com.size.debug:id/customer_new_phone_number")).sendKeys(phoneNumber);
		
		
		//
		//WebElement  delAdd = driver.findElement(By.id("com.size.debug:id/create_account_delivery_address_container"));
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(delAdd);");
		
		driver.findElement(By.id("com.size.debug:id/delivery_address_predictive_input_manual_button")).click();
		driver.findElement(By.id("com.size.debug:id/address_input_first_name")).sendKeys(firstName);
		driver.findElement(By.id("com.size.debug:id/address_input_last_name")).sendKeys(LastName);
		driver.findElement(By.id("com.size.debug:id/address_input_address_1")).sendKeys(add1);
		driver.findElement(By.id("com.size.debug:id/address_input_address_2")).sendKeys(add2);
		driver.findElement(By.id("com.size.debug:id/address_input_town")).sendKeys(town);
		driver.findElement(By.id("com.size.debug:id/address_input_county")).sendKeys(county);
		driver.findElement(By.id("com.size.debug:id/address_input_postcode")).sendKeys(postcode);
		driver.findElement(By.id("com.size.debug:id/address_continue_button")).click();
		driver.findElement(By.id("com.size.debug:id/large_address_continue_button")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Create Account\"));");
		driver.findElement(By.id("com.size.debug:id/customer_login_no_account_continue_button")).click();
	}
	
	private static void check_size_access_membership(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		login_via_my_account(driver);
//		a. My Account banner
		Thread.sleep(5000);
		driver.findElement(By.id("com.size.debug:id/jdx_unlimited_card_image")).click();
//		End of a. My Account banner
		
		
		
		Thread.sleep(5000);
		//Go back till More and click size?access menu item from the more list
		  
		driver.findElementByClassName("android.widget.ImageButton").click();
		Thread.sleep(1000);
		driver.findElementByClassName("android.widget.ImageButton").click();
		Thread.sleep(3000);

//		b. More -> size?access menu item		
		driver.findElementByXPath("//android.widget.TextView[@text='size?access']").click();
//		End of b. More -> size?access menu item
		
		Thread.sleep(3000);
		//Go back till More and click size?access menu item from the more list
		driver.findElementByClassName("android.widget.ImageButton").click();
		
		Thread.sleep(3000);
//      c. Size?Access Bottom Navigation item		
		driver.findElementById("com.size.debug:id/menu_loyalty").click();
//		End of c. Size?Access Bottom Navigation item
	}

	private static void register_size_access_membership(AndroidDriver<AndroidElement> driver,String firstName,String lastName) throws InterruptedException {
		driver.findElementById("com.size.debug:id/menu_loyalty").click();
		Thread.sleep(3000);
		driver.findElementsByClassName("android.widget.ImageView").get(2).click();
		Thread.sleep(3000);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"REGISTER\"));");
		scrollTo(driver,"REGISTER");
		driver.findElement(By.id("com.size.debug:id/jdx_unlimited_create_account")).click();
		scrollTo(driver,"Create An Account");
		
		String email = firstName + lastName + "@size.com";
		
		driver.findElement(By.id("com.size.debug:id/jdx_first_name_edit_text")).sendKeys(firstName);
		driver.findElement(By.id("com.size.debug:id/jdx_last_name_edit_text")).sendKeys(lastName);
		driver.findElement(By.id("com.size.debug:id/jdx_email_edit_text")).sendKeys(email);
		driver.findElement(By.id("com.size.debug:id/jdx_phone_number_edit_text")).sendKeys(phoneNumber);
		driver.findElement(By.id("com.size.debug:id/jdx_date_of_birth_button")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.size.debug:id/jdx_unlimited_male")).click();
		driver.findElementById("com.size.debug:id/jdx_new_password").sendKeys(password);
		driver.findElementById("com.size.debug:id/jdx_new_password_verify").sendKeys(password);
		
		scrollTo(driver,"ENTER ADDRESS MANUALLY");
		driver.findElement(By.id("com.size.debug:id/jdx_manual_button")).click();
		
		driver.findElement(By.id("com.size.debug:id/jdx_address_1")).sendKeys(add1);
		driver.findElement(By.id("com.size.debug:id/jdx_address_2")).sendKeys(add2);
		driver.findElement(By.id("com.size.debug:id/jdx_town")).sendKeys(town);
		scrollTo(driver,"REGISTER");
		driver.findElement(By.id("com.size.debug:id/jdx_county")).sendKeys(county);
		driver.findElement(By.id("com.size.debug:id/jdx_postcode")).sendKeys(postcode);
		driver.findElement(By.id("com.size.debug:id/jdx_create_account")).click();
		
		
		
	}
	
	public static void scrollTo(AndroidDriver<AndroidElement> driver,String text){                
	      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
	   }

}
