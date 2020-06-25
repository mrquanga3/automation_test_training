package alert.popup.quickstart;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestWindowHandle extends WindowHandle {
	@Test
	public void VerifyMainWindow() {
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		 //String mainWindow = driver.getWindowHandle();
		 // driver.switchTo().window(mainWindow);
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String text = driver.findElement(By.xpath("//a[@target='_blank']")).getText();
		assertEquals(text, "Click Here");
	}
	
	@Test
	public void VerifyNewWindow() {
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		Set<String> windows = driver.getWindowHandles();
		String parent = driver.getWindowHandle();
		windows.remove(parent);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Iterator<String> it = windows.iterator();
		String child = null;
		while (it.hasNext()) {
			child = (String) it.next();
			driver.switchTo().window(child);

			String s1 = driver.findElement(By.xpath("//td[@align= 'right']")).getText();
			assertEquals(s1, "Email ID");
		}

	}

}