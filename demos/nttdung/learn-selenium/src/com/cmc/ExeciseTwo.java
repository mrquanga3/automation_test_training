package com.cmc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExeciseTwo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\work\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		browser.findElement(By.xpath("//*[@id=\"login_popup_id\"]/div/div/div[2]/div[2]/div[2]/div/a[2]/i")).click();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("anhnem0708@gmail.com");
		browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
//		Thread.sleep(5000);
		browser.findElement(By.xpath("//input[@name='password']")).sendKeys("123456oC!");
		browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
//		Thread.sleep(5000);
		String Login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.print(Login);
		browser.navigate().back();
		Login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.print(Login);
		browser.navigate().back();
		Login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.print(Login);
	}
}
