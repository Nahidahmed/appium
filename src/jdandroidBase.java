import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class jdandroidBase {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException, InterruptedException {
		File appDir = new File("src");
		
		File app = new File(appDir, "app-jdsports-release.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		if(device.equalsIgnoreCase("emulator")) {
		   caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nahids-Pixel2-Emulator");
		}else if(device.equalsIgnoreCase("real")) {
		   caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		
		return driver;
	}

}
