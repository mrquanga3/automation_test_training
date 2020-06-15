//package TestNG;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.AfterSuite;
//
//public class TestNG {
//	static WebDriver browser;
//
//	@BeforeMethod
//	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
//		browser = new ChromeDriver();
//		browser.manage().window().maximize();
//		browser.navigate().to("https://tuyendung.cmc.com.vn/");
//
//	}
//
//	@Test 
//	public void checkLogIn() {
//		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		String login = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
//		Assert.assertEquals("ANHNEM0708", login);
//		System.out.println(login);
//
//	}
//	
//	@Test 
//	public void checklogOut() {
//		// logout
//		checkLogIn();
//		WebElement hover = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]"));
//		Actions action = new Actions(browser);
//		action.moveToElement(hover).perform();
//		browser.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();
//
//		// check logout?
//		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		boolean logout = browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).isDisplayed();
//		Assert.assertTrue(logout);
//		System.out.println("logout roi nha");
//
//	}
//
//}
