package file_handling;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestLoginPass extends BeforeTestCase {
	@Test
	public void Verify() throws IOException {
		XSSFSheet sh1 = ExcelOperationUsingPOI.getSheet();
		String getacc = sh1.getRow(1).getCell(0).getStringCellValue();
		WebElement acc = driver.findElement(By.xpath("//input[@type='email']"));
		acc.sendKeys(getacc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement next = driver
				.findElement(By.xpath("//div[@class='U26fgb O0WRkf zZhnYe e3Duub C0oVfc qIypjc TrZEUc']"));
		next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String getpass = sh1.getRow(1).getCell(1).getStringCellValue();
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.sendKeys(getpass);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement next2 = driver
				.findElement(By.xpath("//div[@class='U26fgb O0WRkf zZhnYe e3Duub C0oVfc qIypjc TrZEUc']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		next2.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement lg = driver.findElement(By.id("btn-user-name-desktop"));
		assertTrue(lg.getText().equalsIgnoreCase("TUNGTHSE02891"));
	}
}
