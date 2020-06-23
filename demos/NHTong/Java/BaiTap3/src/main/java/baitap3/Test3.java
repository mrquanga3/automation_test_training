package baitap3;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Test3 {
	static WebDriver driver;
	
	@BeforeClass
	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		List<String> dulieu = Files.readLines(new File("Tong.txt"), Charset.defaultCharset());
		String[] taikhoan = dulieu.get(0).split("\\ ");
		System.out.print(taikhoan[0]);System.out.print(taikhoan[1]);
		WebElement login = driver.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		login.click();
		WebElement gg = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		gg.click();
		WebElement account = driver.findElement(By.xpath("//input[@id='identifierId']"));
		account.sendKeys(taikhoan[0]);
		WebElement nextAccount = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextAccount.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println(pass.getAttribute("value"));
		pass.sendKeys(taikhoan[1]);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'p theo')]")));
		WebElement nextpass = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextpass.click();
	}
	@Test
	public void testLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-user-name-desktop")));
		WebElement loged = driver.findElement(By.xpath("//a[@id='btn-user-name-desktop']")); //
		System.out.println(loged.getText());
		assertTrue(loged.getText().equalsIgnoreCase("TOMTEPKOREA"));
	}

	@AfterClass
	public static void close() {
		driver.close();
	}
}
