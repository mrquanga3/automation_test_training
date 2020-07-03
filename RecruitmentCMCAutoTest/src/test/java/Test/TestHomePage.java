package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestHomePage extends TestTemplate {
	@Test
	public void testLogin() {
		HomePage tlg = new HomePage(driver);
		assertEquals(tlg.login(), "TUNGTHSE02891");

	}
}
