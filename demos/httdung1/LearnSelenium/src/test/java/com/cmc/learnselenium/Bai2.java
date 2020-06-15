package com.cmc.learnselenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai2 {

	static WebDriver driver;

	public void waitForElementToSendKey(int seconds, By elementLocator, String sendValue) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator)).sendKeys(sendValue);
	}

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

	@Test
	public void testCaseNo001() {
		// User Login for the 1st time
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();
		waitForElementToSendKey(10, By.id("identifierId"), "sauriengj6@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		waitForElementToSendKey(10, By.name("password"), "123456aA@");
		driver.findElement(By.id("passwordNext")).click();
		waitForElementVisible(15, By.id("btn-user-name-desktop"));
		String txtlogin = driver.findElement(By.id("btn-user-name-desktop")).getText();
		assertEquals("SAURIENGJ6",txtlogin);
	}

	@Test
	public void testCaseNo002() {
		// Return back
		driver.navigate().back();
		waitForElementVisible(25, By.id("btn-user-name-desktop"));
		String txtlogin = driver.findElement(By.id("btn-user-name-desktop")).getText();
		assertEquals("SAURIENGJ6", txtlogin);
	}

	@Test
	public void testCaseNo003() {
		// User logout
		waitForElementVisible(25, By.id("btn-user-name-desktop"));
		Actions action = new Actions(driver);
		WebElement btnUsername = driver.findElement(By.id("btn-user-name-desktop"));
		action.moveToElement(btnUsername).build().perform();
		waitElementToBeClick(25, By.id("logout_portal"));
		waitForElementVisible(25, By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']"));
		WebElement login = driver
				.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']"));
		assertTrue(login.isDisplayed());
	}

	@Test
	public void testCaseNo004() {
		// User Login for the 2nd time
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();
		waitForElementVisible(15, By.id("btn-user-name-desktop"));
		String txtlogin = driver.findElement(By.id("btn-user-name-desktop")).getText();
		assertEquals("SAURIENGJ6", txtlogin);
	}

	@AfterClass
	public static void EndTest() {
		driver.quit();
	}
}
