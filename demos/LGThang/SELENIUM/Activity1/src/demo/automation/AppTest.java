package demo.automation;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
static WebDriver driver;
@Before
public void setup() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://tuyendung.cmc.com.vn/");
}
@Test
public void test() {
	WebElement radio = driver.findElement(By.id("checkbox"));
}
}
