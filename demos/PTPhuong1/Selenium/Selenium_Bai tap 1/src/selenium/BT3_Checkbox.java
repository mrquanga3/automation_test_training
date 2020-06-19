package selenium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("unused")
public class BT3_Checkbox {
	static WebDriver browser;
	@Before
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}		

		/* TC1: Check gia tri default
		 */
		@Test
		public void TestCase1() {
			WebElement nganhnghe = browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
			String macdinh = nganhnghe.getText();
			Assert.assertEquals("Lựa chọn", macdinh);
			System.out.println("Case1 dung ui. hihi");			
		}

		/* TC2: Kiem tra hoat dong cua checkbox
		 * 1. Click chọn combobox nganhnghe
		 * 2. Click vao 1 checkbox
		 * 3. Click lan 2 vao checkbox do
		 * Expected: lan 1 check = true, lan 2 check = false
		 */
		
		@Test
		public void TestCase2() {
			WebElement nganhnghe = browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
			nganhnghe.click();
			WebElement tatca = browser.findElement(By.xpath("//div[@class='btn-groupopen']//label[@class='checkbox'][contains(text(),'t c')]"));
			tatca.click();
			System.out.println(tatca.isSelected());
			Assert.assertEquals(tatca.isSelected(), "True");
			tatca.click();
			System.out.println(tatca.isSelected());
			Assert.assertEquals(tatca.isSelected(), "False");		
		}
		 	 
		/* TC3: Kiem tra khi chon 1 gia tri
		 * 1. Click chọn combobox nganhnghe
		 * 2. Click vao 1 checkbox
		 * 3. Check hien thi combobox nganhnghe
		 * Expected: Hien thi gia tri cua checkbox duoc click
		 */
		@Test
		public void TestCase3() {
			WebElement nganhnghe = browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
			nganhnghe.click();
			WebElement chon = browser.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div/div/div[2]/div/span/div/ul/li[3]/a/label/input"));
			chon.click();
			String ketqua = nganhnghe.getText();
			Assert.assertEquals(ketqua, "Công nghệ cao");
			System.out.println("Chon 1 gai tri thanh cong");
		}
		
		/* TC4: Kiem tra khi chon nhieu gia tri
		 * 1. Click chọn combobox nganhnghe
		 * 2. Click vao 1 checkbox
		 * 3. Check hien thi combobox nganhnghe
		 * Expected: Hien thi gia tri cua nhung checkbox duoc click
		 */
		@Test
		public void TestCase4() {
			WebElement nganhnghe = browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
			nganhnghe.click();
			WebElement chon1 = browser.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div/div/div[2]/div/span/div/ul/li[3]/a/label/input"));
			chon1.click();
			WebElement chon2 = browser.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div/div/div[2]/div/span/div/ul/li[4]/a/label/input"));
			chon2.click();
			String ketqua = nganhnghe.getText();
			Assert.assertEquals(ketqua, "Công nghệ cao, Công nghệ thông tin");
			System.out.println("Chọn nhieu gai tri thanh cong");
		}
		/* TC5: Kiem tra khi chon tat ca
		 * 1. Click chọn combobox nganhnghe
		 * 2. Click vao checkbox "Chon tat ca"
		 * 3. Check hien thi combobox nganhnghe
		 * Expected: Hien thi "Đã chọn tất cả (29)"
		 */
		@Test
		public void TestCase5() {
			WebElement nganhnghe = browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
			nganhnghe.click();
			WebElement tatca = browser.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div/div/div[2]/div/span/div/ul/li[2]/a/label/input"));
			tatca.click();
			String ketqua = nganhnghe.getText();
			Assert.assertEquals(ketqua, "Đã chọn tất cả (29)");
			System.out.println("Da chon tat ca");
		}
		
	    @After
	    public void close() {
		browser.close();
	    }

	}

//}
