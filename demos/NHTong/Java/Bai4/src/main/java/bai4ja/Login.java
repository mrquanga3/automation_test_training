package bai4ja;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		login.click();
		WebElement gg = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		gg.click();
		WebElement account = driver.findElement(By.xpath("//input[@id='identifierId']"));
		account.sendKeys("tomtepkorea@gmail.com");
		WebElement nextAccount = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextAccount.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println(pass.getAttribute("value"));
		pass.sendKeys("tomtep123456");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'p theo')]")));
		WebElement nextpass = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextpass.click();
	}

	@Test
	public void testlogout() {
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lgo = driver.findElement(By.xpath("//a[@id='btn-user-name-desktop']"));
		actions.moveToElement(lgo).build().perform();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lgu = driver.findElement(By.xpath("//a[@id='logout_portal']"));
		lgu.click();
	}

	@AfterClass
	public static void Close() {
		driver.quit();
	}

}