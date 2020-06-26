package selenium;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.joran.action.Action;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaiTap4_Alert {
	@Test
	public void Alert() {
		System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		Mo duong dan
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.findElement(By.name("cusid")).sendKeys("123456");					
        driver.findElement(By.name("submit")).submit();	
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // di chuyen toi alert va get text   
        String alertMessage= alert.getText();		
        Assert.assertEquals(alertMessage, "Do you really want to delete this Customer?");		
        // in alert message	
        System.out.println(alertMessage);
        
        // Accepting alert		
//        alert.accept();
//        driver.close();
	}
}
