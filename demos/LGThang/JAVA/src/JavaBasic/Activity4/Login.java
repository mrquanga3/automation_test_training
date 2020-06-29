package JavaBasic.Activity4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	static WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32_v83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
	}

	@Test
	public void login() {
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("lethang098194@gmail.com");
		WebElement next = driver.findElement(By.xpath("//*[contains(text(),'Tiếp theo')]"));
		next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Legiathang");
		WebDriverWait  wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Tiếp theo')]")));
		WebElement next1 =driver.findElement(By.xpath("//*[contains(text(),'Tiếp theo')]"));
		next1.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void logout() {
		Actions action = new Actions(driver);
		WebElement lgo = driver.findElement(By.xpath("//a[@id='btn-user-name-desktop']"));
		action.moveToElement(lgo).build().perform();		
		driver.findElement(By.xpath("//a[@id='logout_portal']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
