package bai3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dembai3 {
	static WebDriver driver;

	@BeforeClass
	public static void dangNhap() {
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		WebElement luachon = driver.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
		luachon.click();
	}

	@Test
	public void TC_1_chon_tatcajob() {
		WebElement chontatca = driver.findElement(By.xpath("//div[@class='btn-group open']//label[@class='checkbox'][contains(text(),'t c')]"));
		for (int i = 0; i < 30; i++) {
			chontatca.click();
			System.out.print(chontatca.isSelected());
		}
	}

	@Test
	public void TC_2_chon_1job() {
		WebElement chon1 = driver.findElement(By.xpath("//div[@class='search-list']//li[3]//a[1]//label[1]"));
		for (int i = 0; i < 2; i++) {
			chon1.click();
			System.out.print(chon1.isSelected());
		}
	}

	@Test
	public void TC_3_chon_nhieu() {
		

	}

	@Test
	public void TC_4_khongchon() {

	}

	@AfterClass
	public static void close() {
		driver.close();
	}
}
