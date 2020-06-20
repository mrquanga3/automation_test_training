package career;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VerifyValue1 extends BeforeTestCase {

	@Test
	public void verifyValue() {

		Select select = new Select(driver.findElement(By.id("id_category_job")));
		select.selectByValue("84");
		Assert.assertEquals("Công nghệ cao", select.getFirstSelectedOption().getText().trim());
		WebElement ddlclick = driver.findElement(By.xpath("//select[@id='id_category_job']/following-sibling::div"));
		ddlclick.click();
		WebElement click = driver.findElement(By.xpath("//label//Input[@value='84']"));
		click.click();
	}
}
