package demo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai1 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();
		driver.close();

	}

}
