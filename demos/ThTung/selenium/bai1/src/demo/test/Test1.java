package demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1 {
	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// String baseUrl = "http://demo.guru99.com/test/login.html";
		driver.get("https://www.cmc.com.vn/");
		driver.manage().window().maximize();

		// Get the WebElement corresponding to the Email Address(TextField)
		WebElement NgheNghiep = driver.findElement(
				By.xpath("//div[@class='content__banner__featured__box row position-absolute']//div[1]//a[1]"));
		NgheNghiep.click();

		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * //WebElement DangNhap = driver.findElement(By.cssSelector(".btn-log"));
		 * //Actions action =new Actions(driver); //action.moveToElement(DangNhap);
		 */
		WebElement DangNhap = driver.findElement(By.xpath("//header//div//div//div//div//div//li[5]//a[1]"));
		DangNhap.click();

		WebElement Google = driver.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		Google.click();

		WebElement Email = driver.findElement(By.xpath("//input[@id='identifierId']\r\n"));
		Email.sendKeys("tungthse02891@gmail.com");

		WebElement Next = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		Next.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("DarkLord");

		WebElement Next1 = driver.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		Next1.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Confirm = driver.findElement(By.xpath("//a[@id='btn-user-name-desktop']"));
		String Tung1 = Confirm.getText();
		String Tung = "TUNGTHSE02891";
		if (Tung1.equals(Tung))
			System.out.println("Test Pass!");
		else
			System.out.println("Test Fail!");

		driver.close();
	}
}
