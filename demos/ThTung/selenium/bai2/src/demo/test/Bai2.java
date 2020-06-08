package demo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Bai2 {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();

		// Get the WebElement corresponding to the Email Address(TextField)
		WebElement job = driver.findElement(
				By.xpath("//div[@class='content__banner__featured__box row position-absolute']//div[1]//a[1]"));
		job.click();

		WebElement login = driver.findElement(By.xpath("//header//div//div//div//div//div//li[5]//a[1]"));
		login.click();

		WebElement google = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		google.click();

		WebElement email = driver.findElement(By.xpath("//input[@id='identifierId']\r\n"));
		email.sendKeys("tungthse02891@gmail.com");

		WebElement next = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		next.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("DarkLord");

		WebElement next1 = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		next1.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void verifyLogin() {
		WebElement lg = driver.findElement(By.id("btn-user-name-desktop"));
		String acc = lg.getText();
		String acc1 = "TUNGTHSE02891";
		assertTrue(acc.equalsIgnoreCase(acc1));
	}

	@Test
	public void testBack() {
		driver.navigate().back();
		WebElement sLg = driver.findElement(By.id("btn-user-name-desktop"));
		String acc = sLg.getText();
		String acc1 = "TUNGTHSE02891";
		assertTrue(acc.equalsIgnoreCase(acc1));
	}

	@Test
	public void testLogout() {

		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.id("btn-user-name-desktop"));
		action.moveToElement(btn).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement logoutBtn = driver.findElement(By.xpath("//div//div//div//div//div//div//li//li[5]//a[1]"));
		logoutBtn.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement logOut = driver.findElement(By.xpath("//body//header//div//div//div//div//div//li[5]"));
		String acc = logOut.getText();
		String acc1 = "TUNGTHSE02891";
		assertFalse(acc.equalsIgnoreCase(acc1));

		logOut.click();
		WebElement google = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		google.click();
	}

	
	  @AfterClass public static void close() { driver.close(); }
	 
}