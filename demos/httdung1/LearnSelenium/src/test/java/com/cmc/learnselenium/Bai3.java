package com.cmc.learnselenium;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai3 {
	static WebDriver driver;	
	public By bySearch = By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']");

	public void waitForElementVisible(int seconds, By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

	public void waitElementToBeClick(int seconds, By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).click();
	}

	@BeforeClass
	public static void startTest() {
		//System.setProperty("webdriver.chrome.driver", "D:\\0TestAutomation\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn");
		driver.manage().window().maximize();
	}

	/**
	 * TestCase No1: Tích chọn ô Chọn tất cả và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn checkbox Chọn tất cả
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "Đã chọn tất cả (29)"
	 */
	@Test
	public void testCaseNo001() {
		
		waitElementToBeClick(15, bySearch);
		waitForElementVisible(15, By.xpath("//div[@class='btn-group open']"));
		    WebElement itemNganhngeAll = driver.findElement(By.xpath("//div[@class='btn-group open']/ul/li[2]"));
		itemNganhngeAll.click();
		String txtActual = driver.findElement(bySearch).getText();
		assertEquals("Đã chọn tất cả (29)", txtActual);		
	}

	/**
	 * TestCase No1: Tích chọn 1 ngành nghề và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn checkbox "Công nghệ cao"
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "Công nghệ cao"
	 */
	@Test
	public void testCaseNo002() {
		for (int i = 2; i <= 3; i++) {
			WebElement linkElement = driver.findElement(By.xpath("//div[@class='btn-group open']/ul/li[" + i + "]"));
			System.out.println(linkElement.getText());
			linkElement.click();
		}
		String txtActual = driver.findElement(bySearch).getText();		
		assertEquals("Công nghệ cao", txtActual);
	}
	
	/**
	 * TestCase No1: Tích chọn 3 ngành nghề và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn checkbox "Công nghệ cao", "Công nghệ thông tin", "Cung ứng, Giao nhận"
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "Công nghệ cao , Công nghệ thông tin , Cung ứng, Giao nhận"
	 */	 
	@Test
	public void testCaseNo003() {

		for (int i = 2; i <= 5; i++) {
			WebElement linkElement = driver.findElement(By.xpath("//div[@class='btn-group open']/ul/li[" + i + "]"));			
			linkElement.click();
			if (i==2) {
				linkElement.click();
			}
		}

		String txtActual = driver.findElement(bySearch).getText();
		assertEquals("Công nghệ cao , Công nghệ thông tin , Cung ứng, Giao nhận", txtActual);
	}

	/**
	 * TestCase No1: Tích chọn 4 ngành nghề và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn 4 ngành nghề
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "4 địa điểm được chọn"
	 */	 
	@Test
	public void testCaseNo004() {

		for (int i = 2; i <= 6; i++) {
			WebElement linkElement = driver.findElement(By.xpath("//div[@class='btn-group open']/ul/li[" + i + "]"));			
			linkElement.click();
			if (i==2) {
				linkElement.click();
			}			
		}

		String txtActual = driver.findElement(bySearch).getText();		
		assertEquals("4 địa điểm được chọn", txtActual);
		
	}

	@AfterClass
	public static void EndTest() {
		driver.quit();
	}
}
