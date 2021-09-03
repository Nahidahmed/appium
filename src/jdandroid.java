import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class jdandroid extends jdandroidBase {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElementsByClassName("android.widget.RelativeLayout").get(0).click();
		driver.findElementById("com.jd.jdsports:id/continue_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		
		Thread.sleep(10000);
		
		
		driver.findElementById("com.jd.jdsports:id/menu_more").click();
		
		//android.widget.RelativeLayout
		driver.findElementsByClassName("android.widget.RelativeLayout").get(2).click();
		
		driver.findElementByXPath("//android.widget.EditText[@text='Email address']").sendKeys("jdandroid@jdplc.com");
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys("123456qw");
		
		
		driver.findElementById("com.jd.jdsports:id/customer_login_login_button").click();
		
		
	}

}
