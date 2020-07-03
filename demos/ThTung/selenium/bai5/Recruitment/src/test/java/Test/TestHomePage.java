package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import objectRepository.HomePage;

public class TestHomePage {
	@Test
	public void testLogin() {
		BrowserSetting bs = new BrowserSetting();
		WebDriver driver = bs.BrowserSettings();
		HomePage tlg = new HomePage(driver);
		assertEquals(tlg.login(), "TUNGTHSE02891");

	}
}
