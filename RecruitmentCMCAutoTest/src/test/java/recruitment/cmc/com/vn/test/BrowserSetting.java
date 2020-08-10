package recruitment.cmc.com.vn.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static recruitment.cmc.com.settings.URL.*;

public class BrowserSetting {
	public WebDriver BrowserSettings() throws Exception {
		WebDriver driver;
		String browser = System.getenv("BROWSER_NAME");
		final boolean HEADLESS = true;

		if (browser == null) {
			browser = "chrome";
		}
		System.out.print("BROWSER_NAME=" + browser);
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (HEADLESS) {
				firefoxOptions.setHeadless(true);
			}
			driver = new FirefoxDriver(firefoxOptions);
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			if (HEADLESS) {
				chromeOptions.setHeadless(true);
			}
			driver = new ChromeDriver(chromeOptions);
		}
		// Check if parameter passed as 'IE'
		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			if (HEADLESS) {
				// edgeOptions.setHeadless(true);
				// edgeOptions.addArguments("--HEADLESS");
			}
			driver = new EdgeDriver(edgeOptions);

		} else {
			// If no browser passed throw exception
			throw new Exception("BROWSER IS INCORRECT: " + browser + " IS NOT SUPPORTED. "
					+ "BROWSERS ARE SUPPORTED INCLUDING: CHROME AND FIREFOX AND IE AND EDGE ");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		return driver;
	}
}