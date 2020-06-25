
package alert.popup.quickstart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlert extends Alert {

	@Test(priority = 1)
	public void VerifyAlertText() {

		driver.findElement(By.name("cusid")).sendKeys("123456789");
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String alert = driver.switchTo().alert().getText();
		Assert.assertEquals(alert, "Do you really want to delete this Customer?");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*
	 * @Test(priority = 2) public void VerifyAlerAccept() {
	 * driver.switchTo().alert().accept();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); String alert
	 * = driver.switchTo().alert().getText(); Assert.assertEquals(alert,
	 * "Customer Successfully Delete!"); }
	 */
	
	@Test(priority = 2)
	public void VerifyAlerDismiss() {
		driver.switchTo().alert().dismiss();
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().window(mainWindow);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String msg = driver.findElement(By.xpath("//td[@class='heading3']")).getText();
		Assert.assertEquals(msg, "Delete Customer Form");
	}
}
