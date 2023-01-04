package webApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;



public class Nativeapp {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test(enabled=false)
	public void test() throws InterruptedException
	{
//		System.out.println("native app");
		
		//Click on Preference
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(3000);
		
		//Click on 3. Preference dependencies
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		Thread.sleep(6000);
		
		//Clik on wifi CheckBox 
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		Thread.sleep(3000);
		
		//Click on wifi setting
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		Thread.sleep(3000);
		
		//Type
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("wifi");
		Thread.sleep(3000);
		
		//keyboard down
		driver.navigate().back();
		Thread.sleep(3000);
		
		//Click on cancel
		driver.findElement(MobileBy.id("android:id/button2")).click();
	}
	@Test(enabled=true)
	public void test1() throws InterruptedException
	{
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		
		AndroidElement ball1 = driver.findElements(MobileBy.className("android.view.View")).get(0);
		
		AndroidElement ball2 = driver.findElements(MobileBy.className("android.view.View")).get(1);
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ball1)).withDuration(ofSeconds(3))).moveTo(element(ball2)).release().perform();
		
		//(555) 521-5554
	}
}

























