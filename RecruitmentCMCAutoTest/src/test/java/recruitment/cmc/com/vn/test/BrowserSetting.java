package recruitment.cmc.com.vn.test;

import static recruitment.cmc.com.settings.URL.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetting {
	public WebDriver BrowserSettings() {
		WebDriver driver;

		/**
		 * This function will execute before each Test tag in testng.xml
		 * @param browser
		 * @throws Exception
		 */
		@BeforeTest
		@Parameters("browser")
		public void setup(String browser) throws Exception{
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.gecko.driver", System.getenv("webdriver.firefox.driver"));
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver",System.getenv("webdriver.chrome.driver"));
				//create chrome instance
				driver = new ChromeDriver();
			}
//			//Check if parameter passed as 'Edge'
//					else if(browser.equalsIgnoreCase("Edge")){
//						//set path to Edge.exe
//						System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
//						//create Edge instance
//						driver = new EdgeDriver();
//					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void testBrowser() throws InterruptedException{
			browser.navigate().to("https://tuyendung.cmc.com.vn/");
			browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
			browser.findElement(By.xpath("//*[@id=\"login_popup_id\"]/div/div/div[2]/div[2]/div[2]/div/a[2]/i")).click();
			browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//Fill user name
			browser.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("anhnem0708@gmail.com");
			browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
			//Fill pass
			browser.findElement(By.xpath("//input[@name='password']")).sendKeys("123456oC!");
			browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		}
		return driver;
	}
}
