package recruitment.cmc.com.vn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

public class TestTemplate {
	static BrowserSetting bs;
	// static ArrayList<WebDriver> drivers = new ArrayList<WebDriver>();
	public HashMap<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	@BeforeMethod(alwaysRun = true)
	public void setup(Method method) throws Exception {
		bs = new BrowserSetting();
		WebDriver driver_temp = bs.BrowserSettings();
		drivers.put(method.getName(), driver_temp);
	}

	@AfterMethod(alwaysRun = true)
	public void tearnDown(Method result) {
		WebDriver driver = drivers.get(result.getName());
		driver.close();
	}
}
