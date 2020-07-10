package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.HomePage;

public class TestHomePage extends TestTemplate {
	@Test(priority = 1)
	public void testLogin() {
		HomePage tlg = new HomePage(driver);
		assertEquals(tlg.login(), "TUNGTHSE02891");
	}

	@Test(priority = 2)
	public void testLogOut() {
		HomePage tlgOut = new HomePage(driver);
		assertNotEquals(tlgOut.logOut(), "TUNGTHSE02891");
	}
	
	@Test
	public void TestEnoughSlide() {
		HomePage homepag = new HomePage(driver);
		homepag.EnnoughSlide();
		assertEquals(homepag.EnnoughSlide().size(), 3);
	}
	
	@Test
	public void TestNextSlide() {
		HomePage homepag = new HomePage(driver);
		homepag.NextSlide();
	}
	
	@Test
	public void TestBackSlide() {
		HomePage homepag = new HomePage(driver);
		homepag.BackSlide();
	}
}
