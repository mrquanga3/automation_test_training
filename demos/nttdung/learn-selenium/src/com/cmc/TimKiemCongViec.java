package com.cmc;

import java.util.List;
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

	public static void main(String[] args) {
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
	     * Filter by job
	     * Click check all button
	     *Expected: Check all the checkbox
	   	  */
//		
//		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
//		browser.findElement(By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input")).click();
//		
//		List<WebElement> dropdownList = browser.findElements(By.xpath("//div[@class='search-list']//li"));
//		boolean kiemtra = true;
//		for (WebElement dropdown: dropdownList) {
//			if (dropdown.getAttribute("class") == null || !dropdown.getAttribute("class").contains("active")) {
//				kiemtra = false;
//				break;	
//			}
//		}
//		Assert.assertTrue(kiemtra);
//		System.out.println("chon ca rui nha");
		 /**
	     * Filter by job
	     * Click check all button
	     * Un-check ant value of the dropdown list
	     *Expected: the check all icon is not selected.
	   	  */
		
		browser.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']")).click();
		WebElement checkAll = browser.findElement(By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all']//input"));
		for (int i = 0; i<2; i++) {
			checkAll.click();
			System.out.println(checkAll.isSelected());
		}
		
		
//		Boolean numberselect = browser.findElement(By.xpath("//div[@class='btn-group open']//li[@class='multiselect-item multiselect-all active']//input")).isSelected();
//		Assert.assertTrue(numberselect);
//		System.out.println("chon ca rui nha");
		
		
//		browser.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//		System.out.println("ok");
//		Assert.assertEquals("Không tìm thấy nội dung phù hợp", message);
//		System.out.println(message);

	}

}
