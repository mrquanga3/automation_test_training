package career;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifySelectAll extends BeforeTestCase {
	@Test
	public void verifyValue() {

		WebElement ddlclick = driver.findElement(By.xpath("//select[@id='id_category_job']/following-sibling::div"));
		ddlclick.click();
		WebElement click = driver.findElement(By.xpath("//label//Input[@value='multiselect-all']"));
		click.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement confirm = driver.findElement(By.xpath("(//span[@class=\"multiselect-selected-text\"])[1]"));
		Assert.assertEquals("Đã chọn tất cả (29)", confirm.getText().trim());

	}
}
