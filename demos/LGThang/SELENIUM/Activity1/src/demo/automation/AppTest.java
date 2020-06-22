package demo.automation;

import java.util.concurrent.TimeUnit;

<<<<<<< HEAD
import org.junit.After;
import org.junit.Assert;
=======
>>>>>>> 9a5f4f3ed1685aca4926af1f63ec4458e8ae3152
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
<<<<<<< HEAD
	static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32_v83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/*
	 * TC1: Mở trang và check text Lựa chọn ở ngành nghề
	 */
	@Test
	public void TC1() {
		WebElement search = driver.findElement(By.className("multiselect-selected-text"));
		String defaul = search.getText();
		Assert.assertEquals("Lựa chọn", defaul);
		System.out.println("True");
	}

	/*
	 * TC2: Click và ngành nghề và chọn check all
	 */
	@Test
	public void TC2() {
		WebElement search = driver.findElement(By.className("multiselect-selected-text"));
		search.click();
		WebElement all = driver.findElement(By.className("checkbox"));
		all.click();
	}

	/*
	 * TC2: Click và ngành nghề và chọn 1 ngành
	 */
	@Test
	public void TC3() {
		WebElement search = driver.findElement(By.xpath(
				"//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
		search.click();
		WebElement dautu = driver
				.findElement(By.xpath("/html[1]/body[1]/div[4]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/div[1]/ul[1]/li[6]/a[1]/label[1]"));
		dautu.click();
		String resuth = search.getText();
		Assert.assertEquals(resuth, "Đầu tư");
	}

	@After
	public void close() {
		driver.close();
	}
=======
static WebDriver driver;
static WebElement searchButton;
@Before
public void setup() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://tuyendung.cmc.com.vn/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	searchButton = driver.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-native-select']"));
}
@Test
public void test() {
	
}
>>>>>>> 9a5f4f3ed1685aca4926af1f63ec4458e8ae3152
}
