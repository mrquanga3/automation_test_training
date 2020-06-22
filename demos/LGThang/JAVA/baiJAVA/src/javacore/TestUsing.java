package javacore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

public class TestUsing {
	WebDriver driver;

	@Before
	void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
	}

	@After
	void close() {
		driver.close();
	}

	@Test
	void login() {
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
	}

	void readTxt(){
		  File file = new File("Test.txt");
	        FileInputStream IP = new FileInputStream(file);
	        InputStreamReader inputStreamReader = new InputStreamReader(IP);
	        BufferedReader reader = new BufferedReader(inputStreamReader);
	        String line = "";
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	}
	}

