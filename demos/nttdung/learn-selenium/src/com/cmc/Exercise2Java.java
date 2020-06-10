package com.cmc;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Exercise2Java {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		// login
		browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		browser.findElement(By.xpath("//*[@id=\"login_popup_id\"]/div/div/div[2]/div[2]/div[2]/div/a[2]/i")).click();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("anhnem0708@gmail.com");
		browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		browser.findElement(By.xpath("//input[@name='password']")).sendKeys("123456oC!");
		browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		String login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		Assert.assertEquals("anhnem0708".toUpperCase(), login);
		System.out.println(login + "Da Login");
		// back
		browser.navigate().back();
		login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.print(login);
		browser.navigate().back();
		login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.print(login);
		// logout
		WebElement hover = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]"));
		Actions action = new Actions(browser);
		action.moveToElement(hover).perform();
		browser.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();
		boolean logout = browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).isDisplayed();
		Assert.assertTrue(logout);
		System.out.println("logout roi nha");
		// login again
		browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		browser.findElement(By.xpath("//div[@id='login_popup_id']//a[2]")).click();
		System.out.println("Da login lai");

	}
}
