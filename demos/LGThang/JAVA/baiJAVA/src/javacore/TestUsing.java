package javacore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestUsing {
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
	}

	@After
	public void close() {
		driver.close();
	}

	@Test
	public void login() throws IOException {
		String account = readUsernamePassword();
		String username = account.split(";")[0];
		String password = account.split(";")[1];
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(username);
	}

	String readUsernamePassword() throws IOException {
		File file = new File("src\\javacore\\Test.txt");
		FileInputStream IP = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(IP);
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String account = "";
		while ((account = reader.readLine()) != null) {
			System.out.println(account);
			break;
		}
		reader.close();
		return account;
	}
}
