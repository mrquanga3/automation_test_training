package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Motrang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaration and instantiation of objects/variables
		// System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();
		driver.close();

	}

}
