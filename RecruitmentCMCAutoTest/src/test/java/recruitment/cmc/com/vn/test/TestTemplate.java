package recruitment.cmc.com.vn.test;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestTemplate {
	static BrowserSetting bs;
	public HashMap<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	public WebDriver createTempDriver() throws Exception {
		bs = new BrowserSetting();
		return bs.BrowserSettings();
	}

	public static String buildKeyForMappingDriverToTestMethod(Method method, Object[] paramters) {
		String keyMappping = "";
		for (Object param : paramters) {
			keyMappping += param;
		}
		return keyMappping;
	}

	@BeforeMethod(alwaysRun = true)
	public void setup(Method method, Object[] paramters) throws Exception {
		bs = new BrowserSetting();
		WebDriver driver_temp = bs.BrowserSettings();
		drivers.put(TestTemplate.buildKeyForMappingDriverToTestMethod(method, paramters), driver_temp);
	}

	@AfterMethod(alwaysRun = true)
	public void tearnDown(Method method, Object[] paramters) {
		WebDriver driver = drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, paramters));
		driver.close();
		drivers.remove(TestTemplate.buildKeyForMappingDriverToTestMethod(method, paramters));
	}
}
