package A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Bai1 {
		public static void main(String[] args) {

//			 declaration and instantiation of objects/variables
			System.setProperty("webdriver.chrome.driver","D:\\Eclip\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			// String baseUrl = "http://demo.guru99.com/test/login.html";
			driver.get("https://www.cmc.com.vn/");
			driver.manage().window();
			driver.close();
		}
}
	
