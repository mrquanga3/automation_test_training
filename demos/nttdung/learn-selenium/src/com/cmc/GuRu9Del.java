package com.cmc;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuRu9Del {
	static WebDriver browser;
	
	@Before
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("http://demo.guru99.com/test/delete_customer.php");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");
		browser.findElement(By.xpath("//input[@name='submit']")).click();
	
	}
	/**
	 * Delete customer
	 * Input invalid CusID
	 * Click Submit button
	 * Click OK button
	 * Expected: Display successfully message
	 */
	@Test
	public void Del1() {

		Alert alert = browser.switchTo().alert();
		alert.accept();
		String message = browser.switchTo().alert().getText();
		System.out.println(message);
		alert.accept();
	}
	/**
	 * Delete customer
	 * Input invalid CusID
	 * Click Submit button
	 * Click Cancel button
	 * Expected: Display successfully message
	 */
	@Test
	public void Del2() {

		Alert alert = browser.switchTo().alert();
		alert.dismiss();
		System.out.println("Ko xoa");

	}
}
