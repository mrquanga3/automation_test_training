package com.java.lession4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage extends Login{
	@Test
	public void testLogin() {
		login();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String txtlogin = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		assertEquals(txtlogin, "TUNGTHSE02891");

	}
	@Test
	public void testLogout() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logout();
		WebDriverWait  wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']//i[@class='fa fa-sign-in']")));
		WebElement txtlogout = driver.findElement(By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']//i[@class='fa fa-sign-in']"));
		assertTrue(txtlogout.isDisplayed());
	}
}
