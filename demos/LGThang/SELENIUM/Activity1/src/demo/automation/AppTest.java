package demo.automation;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
static WebDriver driver;
static WebElement searchButton;
@Before
public void setup() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://tuyendung.cmc.com.vn/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	searchButton = driver.findElement(By.xpath("//div[@class='search-list']//span[@class='multiselect-native-select']"));
}
@Test
public void test() {
	
}
}
