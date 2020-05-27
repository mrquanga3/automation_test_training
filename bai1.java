package demo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai1 {
	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// String baseUrl = "http://demo.guru99.com/test/login.html";
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
