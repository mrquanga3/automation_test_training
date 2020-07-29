package recruitment.cmc.com.vn.test;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class TestTemplate {
	BrowserSetting bs;
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		bs = new BrowserSetting();
		driver = bs.BrowserSettings();
	}

	@AfterMethod(alwaysRun = true)
	public void tearnDown() {
		//if (driver != null)
		//	driver.quit();
		//driver = null;
		// Set<String> handles = driver.getWindowHandles();
		// for (String handle : handles) {
		// driver.switchTo().window(handle);
		// driver.close();
		// }
		// driver.close();
	}

	@AfterSuite
	public void tearnDownSuite() {
		driver.quit();
	}
}
