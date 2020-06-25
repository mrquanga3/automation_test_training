package JavaBasic;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUsing {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32_v83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
		String account = null;
		try {
			account = readUsernamePassword();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = account.split(";")[0];
		String password = account.split(";")[1];
		WebElement login = driver.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		login.click();
		WebElement lg = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		lg.click();
		WebElement user = driver.findElement(By.xpath("//input[@id='identifierId']"));
		user.sendKeys(username);
		WebElement nextUser = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextUser.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println(pass.getAttribute("value"));
		pass.sendKeys(password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'p theo')]")));
		WebElement nextpass = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextpass.click();
	}

	@Test
	public void login() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-user-name-desktop")));
		WebElement loged = driver.findElement(By.xpath("//a[@id='btn-user-name-desktop']")); //
		System.out.println(loged.getText());
		assertTrue(loged.getText().equalsIgnoreCase("lethang098194@gmail.com"));

	}

	String readUsernamePassword() throws IOException {
		File file = new File("D:/Test.txt");
		FileInputStream IP = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(IP);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String account = "";
		while ((account = reader.readLine()) != null) {
			System.out.println(account);
			break;
		}
		reader.close();
		return account;
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
