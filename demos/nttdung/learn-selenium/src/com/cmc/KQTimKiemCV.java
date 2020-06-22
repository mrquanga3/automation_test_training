package com.cmc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KQTimKiemCV {
	static WebDriver browser;
	static WebElement searchButton;
	Random ran = new Random();

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchButton = browser.findElement(By.xpath("//button[@class='btn btn-primary']"));
	}

	/**
	 * Filter by job 
	 * In case: Click select all button 
	 * Expected: Check all the checkbox
	 */
	@Test
	public void SelectAll() {
		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		browser.findElement(
				By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"))
				.click();

		List<WebElement> dropdownList = browser.findElements(By.xpath("//div[@class='search-list']//li"));
		boolean kiemtra = true;
		for (WebElement dropdown : dropdownList) {
			if (dropdown.getAttribute("class") == null || !dropdown.getAttribute("class").contains("active")) {
				kiemtra = false;
				break;
			}
		}
		Assert.assertTrue(kiemtra);
		System.out.println("chon ca rui nha");
		searchButton.click();
		System.out.println("Bam roi");
		try {
			WebElement message = browser.findElement(By.xpath("//div[@class='content-main']//h5"));
			if (message != null) {
				String message1 = message.getText();
				Assert.assertEquals("Không tìm thấy nội dung phù hợp", message1);
				System.out.println(message1);
			}
		} catch (Exception e) {
			System.out.println("Tim thay");
		}

	}
	/**
	 * Filter by job 
	 * In case: Click check all button, after that un-check any value of the dropdown list 
	 * Expected: the check all icon is not selected.
	 * @throws InterruptedException 
	 */
	@Test
	public void UnSelectAll() throws InterruptedException {
		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		browser.findElement(
				By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"))
				.click();
		int i = ran.nextInt(29);
		Thread.sleep(2000);
		browser.findElement(By.xpath("//div[@class='btn-group open']//li[" + i + "]//input")).click();
		Boolean numberselect = !browser
				.findElement(By.xpath(
						"//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"))
				.isSelected();
		Assert.assertTrue(numberselect);
		System.out.println("ko chon tat ca nua rui");
		searchButton.click();
		System.out.println("Bam roi");
		try {
			WebElement message = browser.findElement(By.xpath("//div[@class='content-main']//h5"));
			if (message != null) {
				String message1 = message.getText();
				Assert.assertEquals("Không tìm thấy nội dung phù hợp", message1);
				System.out.println(message1);
			}
		} catch (Exception e) {
			System.out.println("Tim thay");
		}
		
	}
	
	/**
	 * Filter by job 
	 * In case: Click to any value of the dropdown list 
	 * Expected: the selected value is selected.
	 * @throws InterruptedException
	 */
	@Test
	public void SelectOne() throws InterruptedException {

		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		int i = ran.nextInt(29);
		Thread.sleep(2000);
		browser.findElement(By.xpath("//div[@class='btn-group open']//li[" + i + "]//input")).click();
		WebElement select1Value = browser.findElement(By.xpath("//div[@class='search-list']//li[" + i + "]"));
		boolean check = true;
		if (select1Value.getAttribute("class") == null || !select1Value.getAttribute("class").contains("active")) {
			check = false;
		}
		Assert.assertTrue(check);
		String value = browser.findElement(By.xpath("//div[@class='search-list']//li[" + i + "]//a//label")).getText();
		System.out.println("da chon gia tri tai vi tri " + i + ": " + value);
		searchButton.click();
		System.out.println("Bam roi");
		try {
			WebElement message = browser.findElement(By.xpath("//div[@class='content-main']//h5"));
			if (message != null) {
				String message1 = message.getText();
				Assert.assertEquals("Không tìm thấy nội dung phù hợp", message1);
				System.out.println(message1);
			}
		} catch (Exception e) {
			System.out.println("Tim thay");
		}

	}
	
	/**
	 * Filter by job 
	 * Select multiple values of the dropdown list
	 * Expected: there are multiple values that are selected.
	 * @throws InterruptedException 
	 */
	@Test
	public void MultiSelect() throws InterruptedException {
		
		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		List<Integer> indexRandom = new ArrayList<Integer>();
		for (int i = 0; i <3; i++) {
			indexRandom.add(ran.nextInt(29));
			System.out.println(indexRandom);
		}
		for (Integer i: indexRandom) {
			Thread.sleep(2000);
			browser.findElement(By.xpath("//div[@class='btn-group open']//li[" + i + "]//input")).click();
			WebElement selectValue = browser.findElement(By.xpath("//div[@class='search-list']//li[" +  i  + "]"));
			boolean check = true;
			if (selectValue.getAttribute("class") == null || !selectValue.getAttribute("class").contains("active")) {
			check = false;
			}
			Thread.sleep(5000);
			Assert.assertTrue(check);
			String value = browser.findElement(By.xpath("//div[@class='search-list']//li[" + i + "]//a//label")).getText();
			System.out.println("da chon gia tri tai vi tri " + i + ": " + value);
		}
		searchButton.click();
		System.out.println("Bam roi");
		try {
			WebElement message = browser.findElement(By.xpath("//div[@class='content-main']//h5"));
			if (message != null) {
				String message1 = message.getText();
				Assert.assertEquals("Không tìm thấy nội dung phù hợp", message1);
				System.out.println(message1);
			}
		} catch (Exception e) {
			System.out.println("Tim thay");
		}
	}

//	@After
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(10000);
		browser.close();
	}

}
