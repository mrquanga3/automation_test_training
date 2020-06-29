package JavaBasic.Activity4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends Login {
	@Test
	public void testLogin() {
//		login();
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement loged = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-user-name-desktop")));
//		Assert.assertTrue(loged.getText().equalsIgnoreCase("LETHANG098194@GMAIL.COM"));
		login();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String txtlogin = driver.findElement(By.xpath("//*[@id=\"btn-user-name-desktop\"]")).getText();
		assertEquals(txtlogin, "LETHANG098194");
	}

	@Test
	public void testLogout() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logout();
		WebElement lgu = driver.findElement(By.xpath("//a[@id='logout_portal']"));
		lgu.click();
	
	}
}
