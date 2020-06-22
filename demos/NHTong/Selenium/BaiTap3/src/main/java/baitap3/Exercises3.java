package baitap3;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercises3 {
	public static class Exercises {
		static WebDriver driver;
		public By selectnn = By.xpath("//div[@class='search-list']//span[@class='multiselect-selected-text']");

		@BeforeClass
		public static void openWeb() {
			driver = new ChromeDriver();
			driver.get("https://tuyendung.cmc.com.vn/");
			driver.manage().window().maximize();
			WebElement nn = driver.findElement(By.xpath(
					"//div[@class='search-list']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]"));
			nn.click();
		}

		// Chọn 1 ngành nghề
		@Test
		public void select1() {
			WebElement selAll = driver.findElement(By.xpath("//div[@class='btn-group open']//label[@class='checkbox'][contains(text(),'t c')]"));
			selAll.click();
			WebElement se1 = driver.findElement(By.xpath("//label[@class='checkbox'][contains(text(),'thông tin')]"));
			se1.click();
			WebElement sel1 = driver.findElement(By.xpath("//span[contains(text(),'thông tin')]"));
			assertTrue(sel1.getText().equalsIgnoreCase("Công nghệ thông tin"));
		}

		// Chọn 2 or 3 ngành nghề
		@Test
		public void select2() {
			WebElement se2 = driver.findElement(By.xpath("//div[@class='search-list']//li[3]//a[1]//label[1]"));
			se2.click();
			WebElement sel1 = driver.findElement(By.xpath("//span[contains(text(),'Công ngh')]"));
			assertTrue(sel1.getText().equalsIgnoreCase("Công nghệ cao , công nghệ thông tin"));
		}

		// Chọn 4 ngành nghề
		@Test
		public void select3() {
			WebElement se3 = driver.findElement(By.xpath("//label[@class='checkbox'][contains(text(),'ng, Giao nh')]"));
			se3.click();
			WebElement se4 = driver.findElement(By.xpath("//div[@class='search-list']//li[6]//a[1]//label[1]"));
			se4.click();
			WebElement sel4 = driver
					.findElement(By.xpath("//span[@class='multiselect-selected-text'][contains(text(),'c ch')]"));
			assertTrue(sel4.getText().equalsIgnoreCase("4 địa điểm được chọn"));
		}

		// Chọn full ngành nghề

		@Test
		public void selectAll() {
			WebElement selAll = driver.findElement(By.xpath("//div[@class='btn-group open']//label[@class='checkbox'][contains(text(),'t c')]"));
			selAll.click();
			WebElement sel4 = driver
					.findElement(By.xpath("//span[contains(text(),'(29)')]"));
			assertTrue(sel4.getText().equalsIgnoreCase("Đã chọn tất cả (29)"));
		}

	}
}
