package com.cmc.learnselenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai1 {
	static WebDriver driver;
	@Test
	public void test() {
		//System.setProperty("webdriver.chrome.driver", "D:\\0TestAutomation\\webdriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://tuyendung.cmc.com.vn");
				driver.manage().window().maximize();
	}

}
