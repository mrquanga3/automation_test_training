package alert;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
	static WebDriver driver;

	@BeforeClass
	public static void setup() {
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("22793");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	@Test
	public void Xoa() {		
		driver.switchTo().alert().accept();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String alert = driver.switchTo().alert().getText();
		Assert.assertEquals(alert, "Customer Successfully Delete!");
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void Reset() {
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("22793");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.switchTo().alert().dismiss();
		//driver.findElement(By.xpath("//input[@name='res']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String message = driver.findElement(By.xpath("//td[@class='heading3']")).getText();
		Assert.assertEquals(message, "Delete Customer Form");
	}
	
	@AfterClass
	public static void Close() {
		driver.close();
	}
}
