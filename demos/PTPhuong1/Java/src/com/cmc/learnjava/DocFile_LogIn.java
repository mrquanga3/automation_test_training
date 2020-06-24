package com.cmc.learnjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("unused")
public class DocFile_LogIn {
	static ChromeDriver browser;
	File_user readfile = new File_user();
	List<String> input = readfile.Readfile();
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// login
		browser.findElement(By.xpath(
				"/html/body/div[4]/header/div/nav/div[2]/div/div/div/div[2]/ul/li[5]/a"))
				.click();
		browser.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"))
				.click();
		browser.findElement(By.xpath("//*[@id=\"identifierId\"]"))
				.sendKeys(input.get(0));
		browser.findElement(
				By.xpath("//*[@id=\"identifierNext\"]/div/span/span")).click();
		browser.findElement(
				By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))
				.sendKeys(input.get(1));
		browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/span/span"))
				.click();
	}

	@Test
	public void Check_LogIn() {
		String name = browser
				.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]"))
				.getText();
		Assert.assertEquals("SAURIENGJ6", name);
		System.out.println("da dang nhap");
	}

	@After
	public void Close() {
		browser.close();
	}
}
