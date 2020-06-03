package com.cmc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseOne {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\work\\chromedriver_win32\\chromedriver.exe");
		WebDriver anhNem = new ChromeDriver();
		anhNem.manage().window().maximize();
		anhNem.get("https://www.cmc.com.vn/");
		Thread.sleep(3000);
		anhNem.close();
	}
}
