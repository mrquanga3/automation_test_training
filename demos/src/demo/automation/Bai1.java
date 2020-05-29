package demo.automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Bai1 {
		public static void main(String[] args) {

//			 khai báo và khởi tạo đối tượng biến
			//System.setProperty("webdriver.chrome.driver","D:\\Eclip\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			// String baseUrl = "http://demo.guru99.com/test/login.html";
			driver.get("https://www.cmc.com.vn/");
			driver.manage().window();
			driver.close();
			//quit() or close()
		}
}
	
