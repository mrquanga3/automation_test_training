package demo.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openPage {
	public static void main(String[] args) {

		// khai báo và khởi tạo đối tượng biến
		System.setProperty("webdriver.chrome.driver", "D:\\Eclip\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();
		driver.close();
	}
}
