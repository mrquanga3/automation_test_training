package JavaBasic.Activity4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	static WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lgthang\\Desktop\\chromedriver_win32_V83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
	}

	@Test
	public void login() {
		driver.findElement(By.xpath("//a[contains(text(),'ng Nh')]")).click();
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
