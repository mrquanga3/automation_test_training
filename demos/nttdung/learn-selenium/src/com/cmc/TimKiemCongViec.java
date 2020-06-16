package com.cmc;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JList.DropLocation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimKiemCongViec {
	static WebDriver browser;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// filter by keywords
//		WebElement inputfield = browser.findElement(By.xpath("//*[@id=\"id_search_job\"]"));
//		inputfield.click();
//		inputfield.sendKeys("Project Manager ahihi");
//		browser.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		/**
		 * Filter by job Click check all button Expected: Check all the checkbox
		 */
//		
//		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
//		browser.findElement(
//				By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"))
//				.click();
//
//		List<WebElement> dropdownList = browser.findElements(By.xpath("//div[@class='search-list']//li"));
//		boolean kiemtra = true;
//		for (WebElement dropdown : dropdownList) {
//			if (dropdown.getAttribute("class") == null || !dropdown.getAttribute("class").contains("active")) {
//				kiemtra = false;
//				break;
//			}
//		}
//		Assert.assertTrue(kiemtra);
//		System.out.println("chon ca rui nha");

		/**
		 * Filter by job 
		 * Click check all button. Un-check the check all button 
		 * Expected: the check all icon is not selected.
		 */

//		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
//		WebElement checkAll = browser.findElement(By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"));
//		for (int i = 0; i<2; i++) {
//			checkAll.click();
//			System.out.println(checkAll.isSelected());
//			browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		}

		/**
		 * Filter by job 
		 * Click check all button, after that un-check any value of the dropdown list 
		 * Expected: the check all icon is not selected.
		 */
//		
//		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
//		browser.findElement(
//				By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"))
//				.click();
//		Random ran = new Random();
//		int i = ran.nextInt(29);
//		Thread.sleep(2000);
//		browser.findElement(By.xpath("//div[@class='btn-group open']//li[" + 5 + "]//input")).click();
//		Boolean numberselect = !browser
//				.findElement(By.xpath(
//						"//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"))
//				.isSelected();
//		Assert.assertTrue(numberselect);
//		System.out.println("bo chon ca rui nha");
//		
		/**
		 * Filter by job 
		 * Click to any value of the dropdown list
		 * Expected: the selected value is selected.
		 */
		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		Random ran1 = new Random();
		int i1 = ran1.nextInt(29);
		Thread.sleep(2000);
		browser.findElement(By.xpath("//div[@class='btn-group open']//li[" + i1 + "]//input")).click();
		WebElement select1Value = browser.findElement(By.xpath("//div[@class='search-list']//li[" +  i1  + "]"));
		boolean check = true;
		if (select1Value.getAttribute("class") == null || !select1Value.getAttribute("class").contains("active")) {
		check = false;
		}
		Assert.assertTrue(check);
		System.out.println("Chon 1");
		
		
		/**
		 * Filter by job 
		 * Select 2 values of the dropdown list
		 * Expected: there are 2 values that is selected.
		 */
		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		Random ran2 = new Random();
		int i2 = ran2.nextInt(29);
		int i3 = ran2.nextInt(29);
		Thread.sleep(2000);
		browser.findElement(By.xpath("//div[@class='btn-group open']//li[" + i2 + "]//input")).click();
		WebElement select2Value = browser.findElement(By.xpath("//div[@class='search-list']//li[" +  i2  + "]"));
		boolean check1 = true;
		if (select1Value.getAttribute("class") == null || !select1Value.getAttribute("class").contains("active")) {
		check = false;
		}
		Assert.assertTrue(check1);
		System.out.println("Chon 1");
		

//		browser.findElement(By.className("multiselect-container dropdown-menu")).findElement(By.className("checkbox"));

//		browser.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//		System.out.println("ok");
//		WebElement message = browser.findElement(By.xpath("//div[@class='content-main']//h5"));
//		if (message != null) {
//			String noimia = message.getText();
//			Assert.assertEquals("Không tìm thấy nội dung phù hợp", noimia);
//			System.out.println(noimia);
//		}

	}

}
