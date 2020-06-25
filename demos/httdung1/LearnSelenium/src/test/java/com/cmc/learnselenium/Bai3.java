package com.cmc.learnselenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
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
	public By bySelectAll= By.xpath("//div[@class='btn-group open']//a[@class='multiselect-all']");

	public void waitForElementVisible(int seconds, By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

	public void waitElementToBeClick(int seconds, By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).click();
	}
	
	public ArrayList<Integer> UniqueRandomNumbers(int min, int max, int count) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int randomNum = 0;
		Boolean existNum = false;
		for (int i = 1; i <= count; i++) {
			while (true) {
				randomNum = min + (int) (Math.random() * (max - min));
				existNum = false;
				for (Integer j : list) {
					if (j == randomNum) {
						existNum = true;
					}
				}
				if (!existNum) {
					list.add(randomNum);
					break;
				}
			}
		}
		/*
		 * Collections.shuffle(list); for (Integer i : list) {
		 * System.out.println("Random Number= " + i); }
		 */
		return list;
	}
	
	@Before
	public void startTest() {
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
	 * Expected: Hiển thị thông báo "Đã chọn tất cả"
	 */
	@Test
	public void testCaseNo001() {

		waitElementToBeClick(15, bySearch);
		waitForElementVisible(15, By.xpath("//div[@class='btn-group open']"));
		WebElement itemNganhngeAll = driver.findElement(bySelectAll);
		itemNganhngeAll.click();
		String txtActual = driver.findElement(bySearch).getText();
		txtActual = txtActual.substring(0, txtActual.length()-5);
		System.out.println(txtActual);
		assertEquals("Đã chọn tất cả", txtActual);
	}

	/**
	 * TestCase No2: Tích chọn 1 ngành nghề và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn checkbox "Công nghệ cao"
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "Công nghệ cao"
	 */
	@Test
	public void testCaseNo002() {
		waitElementToBeClick(15, bySearch);
		waitForElementVisible(15, By.xpath("//div[@class='btn-group open']"));			
		WebElement linkElement = driver
				.findElement(By.xpath("//div[@class='btn-group open']//label[contains(text(),'Công nghệ cao')]"));
		linkElement.click();

		String txtActual = driver.findElement(bySearch).getText();
		assertEquals("Công nghệ cao", txtActual);
	}
	
	/**
	 * TestCase No3: Tích chọn 3 ngành nghề và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn checkbox "Công nghệ cao", "Công nghệ thông tin", "Cung ứng, Giao nhận"
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "Công nghệ cao , Công nghệ thông tin , Cung ứng, Giao nhận"
	 */	 
	@Test
	public void testCaseNo003() {
		waitElementToBeClick(15, bySearch);
		waitForElementVisible(15, By.xpath("//div[@class='btn-group open']"));
		WebElement linkElement = driver
				.findElement(By.xpath("//div[@class='btn-group open']//label[contains(text(),'Công nghệ cao')]"));
		linkElement.click();
		linkElement = driver
				.findElement(By.xpath("//div[@class='btn-group open']//label[contains(text(),'Công nghệ thông tin')]"));
		linkElement.click();
		linkElement = driver
				.findElement(By.xpath("//div[@class='btn-group open']//label[contains(text(),'Cung ứng, Giao nhận')]"));
		linkElement.click();
		String txtActual = driver.findElement(bySearch).getText();
		assertEquals("Công nghệ cao , Công nghệ thông tin , Cung ứng, Giao nhận", txtActual);
	}

	/**
	 * TestCase No4: Tích chọn 4 ngành nghề và kiểm tra hiển thị kết quả chọn
	 * 
	 * Step1: Mở hộp chọn multiselect dropdown 
	 * Step2: Tích chọn 4 ngành nghề
	 * Step3: Kiểm tra hiển thị kết quả chọn tại hộp dropdown
	 * 
	 * Expected: Hiển thị thông báo "4 địa điểm được chọn"
	 */	 
	@Test
	public void testCaseNo004() {
		waitElementToBeClick(15, bySearch);
		waitForElementVisible(15, By.xpath("//div[@class='btn-group open']"));
		ArrayList<Integer> listnum = UniqueRandomNumbers(3,29,4);
		for (int i = 0; i < 4; i++) {
			int indexRandom= listnum.get(i);			
			WebElement linkElement = driver.findElement(By.xpath("//div[@class='btn-group open']/ul/li[" + indexRandom + "]"));			
			linkElement.click();
		}
		
		String txtActual = driver.findElement(bySearch).getText();		
		assertEquals("4 địa điểm được chọn", txtActual);		
	}

	@After
	public void EndTest() {
		driver.quit();
	}
}
