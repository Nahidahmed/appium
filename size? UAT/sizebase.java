import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class sizebase {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		File appDir = new File("src");
		File app = new File(appDir, "app-size-debug.apk");
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nahids-Pixel2-Emulator");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		return driver;
		
		
	}

}
