package com.cmc.learnjava;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai3 {
	private static final String[] Null = null;
	static WebDriver driver; 	
	static ArrayList<String> listAcct;;

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

	
	@Before
	public void startTest() {
		//System.setProperty("webdriver.chrome.driver", "D:\\0TestAutomation\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tuyendung.cmc.com.vn");
		driver.manage().window().maximize();
	}
	
	@After
	public void EndTest() {
		driver.quit();
	}
	
	@BeforeClass
	public static void writeRead() {
		// write to file
		writeAccountToFile();

		// read from file
		listAcct = getAccountFromFile();

	}

	//Write data to file login.txt
	public static void writeAccountToFile() {
		try {
			PrintWriter writer = new PrintWriter("login.txt", "UTF-8");
			writer.println("sauriengj6@gmail.com-123456aA@-SAURIENGJ6");
			writer.println("sauriengj6@gmail.com-123456aA@-SAURIENGJ6");			
			writer.close();
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}	
	
	public static ArrayList<String> getAccountFromFile() {
		ArrayList<String> arrAccts = new ArrayList<String>();
		File inFile = new File("login.txt");
		Scanner sc;
		try {
			sc = new Scanner(inFile);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				arrAccts.add(line);
				//System.out.println(line);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrAccts;
	}
	
	//Launch the site and login	 
	public void launchSiteAndLogin (String email, String pass, String title) {		
		driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		driver.findElement(By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']")).click();
		waitForElementToSendKey(10, By.id("identifierId"), email);
		driver.findElement(By.id("identifierNext")).click();
		waitForElementToSendKey(10, By.name("password"), pass);
		driver.findElement(By.id("passwordNext")).click();
		waitForElementVisible(15, By.id("btn-user-name-desktop"));
		String txtlogin = driver.findElement(By.id("btn-user-name-desktop")).getText();
		assertEquals(title, txtlogin);
	}

	@Test
	public void testCaseNo001() {
		
		// Launch the site and login
		String[] result = Null;
		System.out.println("Line 1: " + listAcct.get(0));
		result = listAcct.get(0).split("-");
		System.out.println("email=" + result[0]);
		System.out.println("pass=" + result[1]);
		System.out.println("title=" + result[2]);
		launchSiteAndLogin(result[0], result[1], result[2]);

	}
	
	@Test
	public void testCaseNo002() {
		// Launch the site and login
		String[] result = Null;
		System.out.println("Line 2: " + listAcct.get(1));
		result = listAcct.get(1).split("-");
		System.out.println("email=" + result[0]);
		System.out.println("pass=" + result[1]);
		System.out.println("title=" + result[2]);
		launchSiteAndLogin(result[0], result[1], result[2]);

	}
}
