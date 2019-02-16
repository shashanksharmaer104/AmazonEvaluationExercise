package testAppium.AmazonEvaluationExercise;

import org.testng.annotations.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class TestClass extends BaseClass {

	@Test
	public void testScenario() {
		try {
			// Login Application
			WebElement signin = driver.findElement(By.id("in.amazon.mShop.android.shopping:id/sign_in_button")); 
			wait.until(ExpectedConditions.visibilityOf(signin)).click();

			WebElement signInTxtBxElemnt = driver.findElement(By.id("ap_email_login"));
			signInTxtBxElemnt.sendKeys("shashanksharma.er104@gmail.com"); 
			WebElement continueBtnElemnt = driver.findElementById("continue");
			continueBtnElemnt.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth-signin-show-password-checkbox"))).click();

			WebElement passwordTxtBxElmnt = driver.findElement(By.id("ap_password"));
			passwordTxtBxElmnt.sendKeys("sput@6HU"); 
			WebElement loginBtnElmnt = driver.findElement(By.id("signInSubmit")); loginBtnElmnt.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwm-FeatureShortcutCard-grid-top-3"))); 
			WebElement actionBarIcn = driver.findElement(By.id("in.amazon.mShop.android.shopping:id/action_bar_burger_icon"));
			actionBarIcn.click(); 
			Thread.sleep(1500); 
			actionBarIcn.click();

			// Search product i.e. iphone
			WebElement searchTxtBxElmnt1 = driver.findElement(By.id("in.amazon.mShop.android.shopping:id/search_edit_text"));
			searchTxtBxElmnt1.click();
			WebElement searchTxtBxElmnt2 = driver.findElementById("in.amazon.mShop.android.shopping:id/search_auto_text");
			MobileElement elem = (MobileElement) searchTxtBxElmnt2;
			elem.click();
			//elem.clear();
			//elem.sendKeys("iphone"); // send keys not working in emulator
			//	Thread.sleep(3000);
			//	elem.sendKeys("asdhjv");
			//	elem.setValue("bhsvd");
			// driver.executeScript("mobile:shell", "adb shell input text \"test\"");
			// JavascriptExecutor executor = (JavascriptExecutor) driver;
			// executor.executeScript("document.getElementById('in.amazon.mShop.android.shopping:id/search_auto_text').value=‘iphone’;");

			//WebElement conatinor = driver.findElement(By.id("resultItems"));

			List<WebElement> listElmnts = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout"
					+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout"
					+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]"
					+ "/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout"
					+ "/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout"
					+ "/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[1]"
					+ "/android.view.View[2]/android.view.View[1]/android.widget.ListView/android.view.View/android.view.View[1]"));
			
			System.out.println("Searched products list size: " + listElmnts.size());

			for (WebElement el : listElmnts) {
				System.out.println(el.getText().trim());
			}

			//Click filter button
			WebElement filterBtnElment = driver.findElement(By.id("sx-top-filter-button"));
			filterBtnElment.click();

			//Click sort button
			WebElement sortBtnElmnt = driver.findElement(By.id("sort-btn"));
			sortBtnElmnt.click();

			//Select low to high sorting
			WebElement lowToHighElmnt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/"
					+ "android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/"
					+ "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/"
					+ "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/"
					+ "android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/"
					+ "android.view.View[1]/android.view.View[1]/android.view.View[3]/android.widget.ListView/"
					+ "android.view.View[2]/android.view.View"));
			lowToHighElmnt.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sx-top-filter-button")));

			List<WebElement> sortedListElmnts = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout"
					+ "/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout"
					+ "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]"
					+ "/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout"
					+ "/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout"
					+ "/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[1]"
					+ "/android.view.View[2]/android.view.View[1]/android.widget.ListView/android.view.View/android.view.View[1]"));

			System.out.println("Sorted products list size: " + sortedListElmnts.size());

			for (WebElement el : listElmnts) {
				System.out.println(el.getText().trim());
			}
			
			//Select first sorted product
			sortedListElmnts.get(0).click();
			
			//Get product name
			HashMap<String, String> productInfo = new HashMap<String, String>();
			String name = driver.findElement(By.id("title")).getText().trim();
			String price = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[13]/android.view.View[11]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText")).getText().trim();
			productInfo.put(name, price.replace("rupees ", ""));
			System.out.println(productInfo);
			
			swipeUp(0.5, 0.7, 0.5);
			swipeUp(0.5, 0.7, 0.5);
			swipeUp(0.5, 0.7, 0.5);
			swipeUp(0.5, 0.7, 0.5);
			swipeUp(0.5, 0.7, 0.5);
			
			//Increase Count
			Thread.sleep(1000);
			WebElement countDropDownElemnt = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View[13]/android.view.View[43]/android.view.View/android.view.View/android.view.View[1]/android.view.View[7]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View"));
			countDropDownElemnt.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileQuantityDropDown_1"))).click();
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView(true);", countDropDownElemnt);
			
			//Add to cart
			WebElement addToCartElmnt = driver.findElement(By.id("add-to-cart-button"));
			addToCartElmnt.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void swipeUp(double an, double st, double en) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * an);
		int startPoint = (int) (size.height * st);
		int endPoint = (int) (size.height * en);

		new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(anchor, endPoint)).release().perform();
	}
}
