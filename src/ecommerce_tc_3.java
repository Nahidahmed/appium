import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_3 extends base {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//Observe for next statement, index is again set to 0.
		//This is because in the first statement, after adding item, the text changed to 'Added to cart' and array too changed
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(2000);
		
		double totalVal = 0;
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		for(int i=0;i<count;i++) {
			String amt1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			double amt1Val = getAmount(amt1);
			totalVal += amt1Val;
		}
		
		//The below code is optimized with above for loop
//		String amt1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
//		double amt1Val = getAmount(amt1);
//		
//		String amt2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
//		double amt2Val = getAmount(amt2);
//		
//		double totalVal = amt1Val + amt2Val;
		
		String totalCartValStr = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalCartVal = getAmount(totalCartValStr);
		
		System.out.println("Calculated Value: "+ totalVal);
		System.out.println("Cart Toal Value: "+ totalVal);
		Assert.assertEquals(totalVal, totalCartVal);
	}

	public static double getAmount(String amt) {
		amt = amt.substring(1);
		double updatedAmtVal = Double.parseDouble(amt);
		return updatedAmtVal;
	}
}
