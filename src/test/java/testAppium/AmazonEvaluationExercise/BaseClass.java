package testAppium.AmazonEvaluationExercise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public static AndroidDriver driver = null;
	public static WebDriverWait wait = null;
	private DesiredCapabilities caps;

	@BeforeMethod
	@Parameters({"Mobile_OS_Type"})
	public void beforeMethod(@Optional("-1") String mobile_type) throws MalformedURLException {
		switch (mobile_type) {
		case "Android":
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "Android Emulator");
			capabilities.setCapability("udid", "emulator-5554");
			//capabilities.setCapability("deviceName", "Android Device");
			//capabilities.setCapability("udid", "ce05171508dd082f01");
			capabilities.setCapability("platformName", "Android");
			// capabilities.setCapability("platformVersion", "9.0");
			// String path =
			// System.getProperty("user.dir")+"/app/com.amazon.mShop.android.shopping_2019-01-29.apk";
			// capabilities.setCapability("app", path);
			capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			capabilities.setCapability("newCommandTimeout", "100");
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("noReset", "false");
			// capabilities.setCapability("unicodeKeyboard","false");
			// capabilities.setCapability("resetKeyboard","false");

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 10);
			break;

		default:
			break;
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
		driver.quit();
	}

}
