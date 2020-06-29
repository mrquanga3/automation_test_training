package cmc.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebBrowser {
	public WebDriver driver;
	public String url = "https://tuyendung.cmc.com.vn";	
	
	@BeforeClass
	public void startTest() {
		// System.setProperty("webdriver.chrome.driver","D:\\0TestAutomation\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}
}

