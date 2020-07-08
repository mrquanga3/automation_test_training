package recruitment.cmc.com.vn.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static recruitment.cmc.com.settings.URL.*;

public class BrowserSetting {
	public WebDriver BrowserSettings() throws Exception {
		WebDriver driver;
		String browser = System.getenv("BROWSER_NAME");
		if (browser == null){
			browser = "chrome";
		}
		System.out.print("BROWSER_NAME=" + browser);
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
//		//Check if parameter passed as 'Edge'
//				else if(browser.equalsIgnoreCase("Edge")){
//					//set path to Edge.exe
//					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
//					//create Edge instance
//					driver = new EdgeDriver();
//				}
		else {
			// If no browser passed throw exception
			throw new Exception("BROWSER IS INCORRECT: " + browser + "IS NOT SUPPORTED. " + "BROWSERS ARE SUPPORTED INCLUDING: CHROME AND FIREFOX ");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		return driver;
	}
}