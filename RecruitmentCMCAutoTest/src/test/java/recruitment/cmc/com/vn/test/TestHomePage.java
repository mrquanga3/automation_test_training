package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import recruitment.cmc.com.pages.HomePage;
public class TestHomePage extends TestTemplate {
	@Test
	public void testTitle() {
		HomePage homePage = new HomePage(driver);
		assertEquals("Tuyển dụng CMC Corporation", homePage.getTitle());
	}

	// Check the number of menus on the Job page
	@Test
	public void testNumberMenus() throws Exception {
		HomePage homePage = new HomePage(driver);
		assertEquals(homePage.getNumberMenuFromWeb(), homePage.getNumberMenuFromFile());
	}

	// Save menu list to object array
	@DataProvider(name = "menudata")
	public Object[][] dataFromDataprovider() throws Exception {
		HomePage homePage = new HomePage(driver);
		return homePage.getDataFromWeb();
	}

	@Test(priority = 2)
	public void testLogOut() {
		HomePage tlgOut = new HomePage(driver);
		// assertNotEquals(tlgOut.logOut(), "TUNGTHSE02891");
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
