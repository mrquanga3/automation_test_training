package com.cmc;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExerciseTwo {

	static WebDriver browser;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		browser.findElement(By.xpath("//*[@id=\"login_popup_id\"]/div/div/div[2]/div[2]/div[2]/div/a[2]/i")).click();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("anhnem0708@gmail.com");
		browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		browser.findElement(By.xpath("//input[@name='password']")).sendKeys("123456oC!");
		browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
	}

	@Test
	public void checkLogIn() {
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		Assert.assertEquals("ANHNEM0708", login);
		System.out.println(login);

	}

//	@Test
	public void checkBack() {
		checkLogIn();
		browser.navigate().back();
		String login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.println(login);
		browser.navigate().back();
		login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		System.out.println(login);

	}

	@Test
	public void checklogOut() {
		// logout
		checkLogIn();
		WebElement hover = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]"));
		Actions action = new Actions(browser);
		action.moveToElement(hover).perform();
		browser.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();

		// check xem logout chua
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean logout = browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).isDisplayed();
		Assert.assertTrue(logout);
		System.out.println("logout roi nha");

	}
	@Test
	public void loginAgain () {
		//login 2
		checkLogIn();
		checklogOut();
		browser.findElement(By.xpath("/html/body/div[4]/header/div/nav/div[2]/div/div/div/div[2]/ul/li[5]/a")).click();
		browser.findElement(By.xpath("//*[@id=\"login_popup_id\"]/div/div/div[2]/div[2]/div[2]/div/a[2]")).click();
//		String login2 = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
//		Assert.assertEquals("ANHNEM0708", login2);
		System.out.println("Login lai rui nha");
	}
	

	@After
	public void closeBrowser() {
		// close chrome
		browser.close();
	}


}
