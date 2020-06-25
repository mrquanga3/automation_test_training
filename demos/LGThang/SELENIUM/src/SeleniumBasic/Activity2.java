package SeleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity2 {
	static WebDriver driver;

	@BeforeClass
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
		WebElement dautu = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[4]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/div[1]/ul[1]/li[6]/a[1]/label[1]"));
		dautu.click();
		String resuth = search.getText();
		Assert.assertEquals(resuth, "Đầu tư");
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
