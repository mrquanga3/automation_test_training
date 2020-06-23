package file_handling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BeforeTestCase {
	public WebDriver driver;

	@BeforeClass
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement login = driver
				.findElement(By.xpath("(//a[@class='btn-log login-portal']//i[@class='fa fa-sign-in'])[2]"));
		login.click();
		WebElement google = driver.findElement(By.xpath("(//a[@href='/login-google'])[2]"));
		google.click();
	}

	@AfterClass
	public void AfterTest() {
		driver.close();
	}
}