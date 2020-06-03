package com.cmc.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	@Test
	public void openBrower() {
		// System.setProperty("webdriver.chrome.driver","E:\\SeleniumWebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cmc.com.vn/");
		driver.close();
	}
}
