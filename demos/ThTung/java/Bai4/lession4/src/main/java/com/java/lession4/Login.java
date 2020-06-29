package com.java.lession4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Login {
	public WebDriver driver;

	public void login() {
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("tungthse02891@gmail.com");
		WebElement next1 = driver.findElement(By.xpath("//*[contains(text(),'Tiếp theo')]"));
		next1.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("DarkLord.123");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait  wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Tiếp theo')]")));
		WebElement next2 =driver.findElement(By.xpath("//*[contains(text(),'Tiếp theo')]"));
		next2.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void logout() {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]"));
		action.moveToElement(we).build().perform();		
		driver.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
