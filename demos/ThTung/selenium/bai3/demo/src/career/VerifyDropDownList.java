package career;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class VerifyDropDownList extends BeforeTestCase {
	@Test
	public void Verify() {
		Select select = new Select(driver.findElement(By.id("id_category_job")));
		// System.out.println(ddl.getOptions().size());
		Assert.assertEquals(29, select.getOptions().size());
	}
}
