import java.awt.List;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomatorTest extends base {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElementByAndroidUIAutomator("attribute(\"value\")");
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//AndroidElement elements = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		//System.out.println(elements.getSize());
		
	}


}
