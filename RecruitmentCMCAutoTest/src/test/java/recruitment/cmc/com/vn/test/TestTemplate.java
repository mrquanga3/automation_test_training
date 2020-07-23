package recruitment.cmc.com.vn.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestTemplate {
	BrowserSetting bs;
	WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		bs = new BrowserSetting();
		driver = bs.BrowserSettings();
	}

	@AfterMethod
	public void tearnDown() {
		driver.quit();
	}
}
