package recruitment.cmc.com.vn.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestTemplate {
	BrowserSetting bs;
	WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		bs = new BrowserSetting();
		driver = bs.BrowserSettings();
	}

	@AfterClass
	public void tearnDown() {
		driver.quit();
	}
}
