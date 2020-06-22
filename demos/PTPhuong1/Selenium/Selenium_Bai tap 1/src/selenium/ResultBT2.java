package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResultBT2 {
    static WebDriver browser;

    @Before
    public void setup() {
//		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver_win32\\chromedriver.exe");
	browser = new ChromeDriver();
	browser.manage().window().maximize();
	browser.navigate().to("https://tuyendung.cmc.com.vn/");
	browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	browser.findElement(By.xpath("/html/body/div[4]/header/div/nav/div[2]/div/div/div/div[2]/ul/li[5]/a")).click();
	browser.findElement(By.xpath("//div[@id='login_popup_id']//a[2]")).click();
	browser.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("sauriengj6@gmail.com");
	browser.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
	browser.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("123456aA@");
	browser.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
    }

    @Test
    public void checklogin() {
	// kiem tra xem login duoc chua
	String name = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
	Assert.assertEquals("SAURIENGJ6", name);
	System.out.println("da dang nhap");

    }

    @Test
    public void checkback() {
	// Kiem tra trang thai dang nhap sau khi back
	browser.navigate().back();
	String name = browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
	Assert.assertEquals("SAURIENGJ6", name);
	System.out.print("Van dang nhap");
    }

    @Test
    public void checkLogout() {
	WebElement subMenu = browser.findElement(By.cssSelector("#btn-user-name-desktop"));
	Actions actions = new Actions(browser);
	actions.moveToElement(subMenu).perform();
	browser.findElement(By.xpath("//*[@id=\"logout_portal\"]")).click();
	String name = browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']"))
		.getText();
	Assert.assertEquals("ﾄ斉�NG NH蘯ｬP", name);
    }

    @Test
    public void reLogin() {
	checkLogout();
	browser.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']")).click();
	browser.findElement(By.xpath("//div[@id='login_popup_id']//a[2]")).click();
	Assert.assertEquals("SAURIENGJ6",
		browser.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText());
	System.out.println("OK");
    }

    @After
    public void close() {
	browser.close();
    }
}
