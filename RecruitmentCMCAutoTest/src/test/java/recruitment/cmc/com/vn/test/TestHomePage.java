package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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
	
	// Check displaying the menus on the Job page
	@Test(dataProvider = "menudata")
	public void verifyMenus(String menu, String url) throws Exception {
		HomePage homePage = new HomePage(driver);
		Object[][] arrMns = homePage.getDataFromFile();
		boolean resultTest = homePage.compareMenuInFile(menu, url, arrMns);
		assertEquals(resultTest, true);
	}

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
	public void testEnoughSlide() {
		HomePage homepage = new HomePage(driver);
		homepage.ennoughSlide();
		assertEquals(homepage.ennoughSlide().size(), 3);
	}
	
	@Test
	public void testNextSlide() {
		HomePage homepage = new HomePage(driver);
		homepage.nextSlide();
	}
	
	@Test
	public void testBackSlide() {
		HomePage homepage = new HomePage(driver);
		homepage.backSlide();
	}
}
