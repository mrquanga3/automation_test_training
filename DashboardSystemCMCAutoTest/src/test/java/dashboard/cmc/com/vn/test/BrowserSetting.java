package dashboard.cmc.com.vn.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dashboard.cmc.com.settings.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetting {
	public WebDriver BrowserSettings() throws Exception {
		WebDriver driver;
		String browser = System.getenv("BROWSER_NAME");
		String HEADLESS_ENV = System.getenv("HEADLESS");
		boolean HEADLESS = true;
		if ("0".equalsIgnoreCase(HEADLESS_ENV)) {
			HEADLESS = false;
		}
		if (browser == null) {
			browser = "chrome";
		}
		System.out.println("BROWSER_NAME=" + browser + ";" + "HEADLESS=" + HEADLESS);
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
			if (HEADLESS) {
				throw new Exception("Your browser '" + browser + "' is NOT supported for headless mode. "
						+ "Browsers are supported including: chrome, firefox, ie and edge (only with selenium 4.x) !!!");
			}
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			if (HEADLESS) {
				// TODO only supported on nex selenium version 4.x not 3.x for now
				// edgeOptions.setHeadless(true);
				// edgeOptions.addArguments("--HEADLESS");
			}
			driver = new EdgeDriver(edgeOptions);

		} else {
			// If no browser passed throw exception
			throw new Exception("Your browser '" + browser
					+ "' is NOT supported. Browsers are supported including: chrome, firefox, ie and edge !!!");
		}
		Dimension d = new Dimension(1920, 1280);
		// Resize current window to the set dimension
		driver.manage().window().setSize(d);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Constant.BASE_URL);
		return driver;
	}
}