package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.HomePage;
public class TestHomePage extends TestTemplate {
	//Begin of dunghtt1============================================================
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
	
	//Check like function on recruitment page 
	@Test
	public void verifyLikeFunction() throws Exception {
		HomePage homePage = new HomePage(driver);		
		boolean resultTest = homePage.getStatusLikeFunction();
		assertEquals(resultTest, true);
	}	
	//End of dunghtt1============================================================

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
