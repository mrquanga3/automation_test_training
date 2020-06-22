package bai2;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demobai2 {
	static WebDriver driver;

	@BeforeClass
	public static void dangNhap() {
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		login.click();
		WebElement gg = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		gg.click();
		WebElement account = driver.findElement(By.xpath("//input[@id='identifierId']"));
		account.sendKeys("khuongthoa16@gmail.com");
		WebElement nextAccount = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextAccount.click();
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys("Ngongio@2104");
		WebElement nextpass = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextpass.click();
	}

	@Test
	public void testLogin() {
		WebElement loged = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(loged.getText().equalsIgnoreCase("khuongthoa16"));
	}

	@Test
	public void testBack() {
		driver.navigate().back();
		WebElement loged = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(loged.getText().equalsIgnoreCase("khuongthoa16"));
	}

	@Test
	public void logOut() {

	}

	@AfterClass
	public static void close() {
		driver.close();
	}
}
