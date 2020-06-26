package selenium;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaiTap4_Popup {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Mo duong dan
		driver.get("http://demo.guru99.com/popup.php");

		driver.findElement(By.xpath("/html/body/p/a")).click();

		// get key cua popup cha
		String MainWindow = driver.getWindowHandle();

		// get list tat ca popup dc mo
		Set<String> listPopup = driver.getWindowHandles();
		// convert sang Iterator
		Iterator<String> iListPopup = listPopup.iterator();

		while (iListPopup.hasNext()) {
			// get key popup
			String ChildWindow = iListPopup.next();

			// kiem tra xem co phai la popup cha khong ?
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// neu khong phai popup cha thi swith sang popup con dua vao key
				// : ChildWindow
				driver.switchTo().window(ChildWindow);
				// khi da o man hinh popup con thi thuc hien action
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("sauriengj6@gmail.com");

				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();

				// dong popup
				driver.close();
			}
		}
		// Switching ve thang popup cha
		driver.switchTo().window(MainWindow);
	}
}
