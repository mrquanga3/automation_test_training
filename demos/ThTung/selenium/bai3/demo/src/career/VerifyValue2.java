package career;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VerifyValue2 extends BeforeTestCase {

	@Test
	public void verifyValue() {

		Select select = new Select(driver.findElement(By.id("id_category_job")));
		select.selectByValue("85");
		Assert.assertEquals("Công nghệ thông tin", select.getFirstSelectedOption().getText().trim());
		WebElement ddlclick = driver.findElement(By.xpath("//select[@id='id_category_job']/following-sibling::div"));
		ddlclick.click();
		WebElement click = driver.findElement(By.xpath("//label//Input[@value='85']"));
		click.click();
	}
}
