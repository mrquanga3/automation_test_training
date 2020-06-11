package bai2sele;

//thêm maven selenium, junit, chorme driver và thêm tiện ích ChroPath để xem button
import static org.junit.Assert.assertTrue;

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

public class baiTap2 {

	static WebDriver driver;

	@BeforeClass
	public static void pricondition() {
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		// click đăng nhập
		login.click();
		WebElement gg = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		gg.click();
		WebElement account = driver.findElement(By.xpath("//input[@id='identifierId']"));
		// input account gmail
		account.sendKeys("tomtepkorea@gmail.com");
		WebElement nextAccount = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextAccount.click();
		// chờ cho load hết trang
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
	public void testLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-user-name-desktop")));
		WebElement loged = driver.findElement(By.id("btn-user-name-desktop"));
		// System.out.println(loged.getText());
		// equalsIgnoreCase so sánh chuỗi k phân biệt hoa thường
		assertTrue(loged.getText().equalsIgnoreCase("TOMTEPKOREA"));
	}

	@Test
	public void testBack() {
		driver.navigate().back();
		WebElement loged = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(loged.getText().equalsIgnoreCase("TOMTEPKOREA"));
	}

	@Test
	public void logOut() {
		Actions actions = new Actions(driver);
		WebElement lgo = driver.findElement(By.xpath("//a[@id='btn-user-name-desktop']"));
		actions.moveToElement(lgo).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lgu = driver.findElement(By.xpath("//a[@id='logout_portal']"));
		lgu.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void relogin() {
		WebElement relogins = driver.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		relogins.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ggs = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]")); //
		ggs.click();
	}

	/*
	 * @AfterClass public static void close() { driver.close(); }
	 */

}
