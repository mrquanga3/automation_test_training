package bai4ja;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends Login {
	
	@Test
	public void testLogin() {
		setup();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement home = driver.findElement(By.xpath("//ul[@class='nav navbar-nav pull-right']//a[@class='nav-link'][contains(text(),'Trang ch')]"));
		home.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(login.getText().equalsIgnoreCase("TOMTEPKOREA"));
	}
}
