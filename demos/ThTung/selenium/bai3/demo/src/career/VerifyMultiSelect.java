package career;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class VerifyMultiSelect extends BeforeTestCase {

	@Test
	public void verifyValue() {

		Select select = new Select(driver.findElement(By.id("id_category_job")));
		Assert.assertTrue(select.isMultiple());
	}
}
