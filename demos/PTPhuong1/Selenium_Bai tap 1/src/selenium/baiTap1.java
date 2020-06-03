package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class baiTap1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tms.cmcglobal.com.vn");
		driver.close();
		
		
	}




}
