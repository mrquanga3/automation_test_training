package com.cmc.automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bai1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumWebDriver\\chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
	    driver.get("https://cmc.com.vn/");
	    //driver.manage().window().maximize();
	    driver.close();	    

	}

}
