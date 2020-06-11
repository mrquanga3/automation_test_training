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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai2 {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement job = driver.findElement(
				By.xpath("//div[@class='content__banner__featured__box row position-absolute']//div[1]//a[1]"));
		job.click();

		WebElement login = driver.findElement(By.xpath("//header//div//div//div//div//div//li[5]//a[1]"));
		login.click();

		WebElement google = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		google.click();

		WebElement email = driver.findElement(By.xpath("//input[@id='identifierId']\r\n"));
		email.sendKeys("tungthse02891@gmail.com");

		WebElement next = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'p theo')]")));
		next.click();
		
		WebElement password = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		password.sendKeys("DarkLord.123");
		
		WebElement next1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'p theo')]")));
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
		assertTrue(lg.getText().equalsIgnoreCase("TUNGTHSE02891"));
	}

	@Test
	public void testBack() {
		driver.navigate().back();
		WebElement sLg = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(sLg.getText().equalsIgnoreCase("TUNGTHSE02891"));
	}

	@Test
	public void testLogout() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.id("btn-user-name-desktop"));
		action.moveToElement(btn).perform();
		WebElement logoutBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div//div//div//div//div//div//li//li[5]//a[1]")));
		logoutBtn.click();
	
		WebElement logOut = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//body//header//div//div//div//div//div//li[5]")));
		assertFalse(logOut.getText().equalsIgnoreCase("TUNGTHSE02891"));

	}

	@Test
	public void testLoginAgain() {

		WebElement login = driver.findElement(By.xpath("//header//div//div//div//div//div//li[5]//a[1]"));
		login.click();
		WebElement google = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		google.click();
		WebElement sLg = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(sLg.getText().equalsIgnoreCase("TUNGTHSE02891"));
	}

	@AfterClass
	public static void close() {
		driver.close();
	}

}