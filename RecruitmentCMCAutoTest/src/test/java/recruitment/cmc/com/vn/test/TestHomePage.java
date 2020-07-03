package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.HomePage;

public class TestHomePage extends TestTemplate {
	@Test
	public void testLogin() {
		HomePage tlg = new HomePage(driver);
		assertEquals(tlg.login(), "TUNGTHSE02891");

	}
}
