package com.cmc.learnjava.bai4;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	static String user = "sauriengj6@gmail.com";
	static String pass = "123456aA@";
	static WebDriver browser;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		login 
		browser.findElement(By.xpath("/html/body/div[4]/header/div/nav/div[2]/div/div/div/div[2]/ul/li[5]/a")).click();
		browser.findElement(By.xpath("//div[@id='login_popup_id']//a[2]")).click();
		browser.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(user);
		browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/span/span")).click();
		browser.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pass);
		browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/span/span")).click();
		System.out.println("thuc hien action login thanh cong");
	}

	public void login() {
		setup();
		// kiem tra xem login duoc chua
		String name = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		Assert.assertEquals("SAURIENGJ6", name);
	}

	public void logout() {
		setup();
		WebElement subMenu = browser.findElement(By.cssSelector("#btn-user-name-desktop"));
		Actions actions = new Actions(browser);
		actions.moveToElement(subMenu).perform();
		browser.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();
	}

	public void close() {
		browser.close();
	}
}
