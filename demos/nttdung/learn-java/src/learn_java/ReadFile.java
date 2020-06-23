package learn_java;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ReadFile {
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://tuyendung.cmc.com.vn/");
		List<String> data = Files.readLines(new File("Login.txt"), Charset.defaultCharset());
//		String username = data.get(0);
//		String password = data.get(1);
		String[] userpass = data.get(0).split("\\#\\#\\#");
		System.out.println(userpass[0]);
		System.out.println(userpass[1]);
		// login
		browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
		browser.findElement(By.xpath("//div[@id='login_popup_id']//i[@class='fa fa-google-plus-square']")).click();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(userpass[0]);
		browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/span/span")).click();
		browser.findElement(By.xpath("//input[@name='password']")).sendKeys(userpass[1]);
		browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/span/span")).click();
		String login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		Assert.assertEquals("anhnem0708".toUpperCase(), login);
		System.out.println(login + " Da Login");
		
	}


}

