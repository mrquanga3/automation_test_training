package com.cmc.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
	static WebDriver driver;

	@BeforeClass
	public static void BeforeTest() {
		// System.setProperty("webdriver.chrome.driver","E:\\SeleniumWebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void UserLogin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("junghoangthanh@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Huong2003");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String txtlogin = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		assertEquals("JUNGHOANGTHANH", txtlogin); 		
	}
	
	@Test
	public void BackAndCheck() {	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
		String txtlogin = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		assertEquals("JUNGHOANGTHANH", txtlogin);		
	}
	
	@Test
	public void UserLogout() {	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]"));
		action.moveToElement(we).build().perform();		
		driver.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']"));
		assertTrue(login.isDisplayed());
	}
	
	//@Test
	public void UserLoginAgain() {
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();
		String txtlogin = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		assertEquals("JUNGHOANGTHANH", txtlogin); 
	}

	@AfterClass
	public static void AfterTest() {
		driver.quit();
	}

}
