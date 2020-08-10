package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.HomePage;

public class TestHomePage extends TestTemplate {
	// Begin of dunghtt1============================================================
	@Test
	public void testTitle(Method method) {
		HomePage homePage = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		assertEquals("Tuyển dụng CMC Corporation", homePage.getTitle());
	}

	// Check the number of menus on the Job page
	@Test
	public void testNumberMenus(Method method) throws Exception {
		HomePage homePage = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		assertEquals(homePage.getNumberMenuFromWeb(), homePage.getNumberMenuFromFile());
	}

	// Save menu list to object array
	@DataProvider(name = "menudata", parallel = true)
	public Object[][] menuDataprovider() throws Exception {
		WebDriver tempDriver = this.createTempDriver();
		HomePage homePage = new HomePage(tempDriver);
		Object[][] data = homePage.getDataFromFile();
		tempDriver.quit();
		return data;
	}

	// Check displaying the menus on the Job page

	@Test(dataProvider = "menudata")
	public void verifyMenus(String menu, String url, int idMenu, Method method) throws Exception {
		HomePage homePage = new HomePage(drivers
				.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { menu, url, idMenu, method })));
		Object[][] arrMns = homePage.getDataFromFile();
		boolean resultTest = homePage.compareMenuInFile(menu, url, idMenu);
		assertEquals(resultTest, true, "Display wrong menu!");
	}

	// Save case test data to object array for method verifyLikeFunction()
	@DataProvider(name = "likedata", parallel = true)
	public Object[][] likeDataprovider() throws Exception {
		return new Object[][] { { "notLogin", "" }, { "loggedIn", "notLike" }, { "loggedIn", "liked" } };
	}

	// Check like function on recruitment page use method likeDataprovider()
	@Test(dataProvider = "likedata")
	public void verifyLikeFunction(String sLogin, String sLike, Method method) throws Exception {
		HomePage homePage = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { sLogin, sLike, method })));
		System.out.println("============verifyLikeFunction: Key is generated======:"
				+ TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { sLogin, sLike, method }));
		boolean resultTest = homePage.getStatusLikeFunction(sLogin, sLike);
		assertEquals(resultTest, true, "Function like is fail!");
	}
	// End of dunghtt1============================================================

	@Test(priority = 1)
	public void testLogin(Method method) {
		HomePage tlg = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		assertEquals(tlg.login(), "TUNGTHSE02891");
	}

	@Test(priority = 2)
	public void testLogOut(Method method) {
		HomePage tlgOut = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		tlgOut.login();
		assertNotEquals(tlgOut.logOut(), "TUNGTHSE02891");
	}

	@Test
	public void testEnoughSlide(Method method) {
		HomePage homepage = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		homepage.ennoughSlide();
		assertEquals(homepage.ennoughSlide().size(), 3);
	}

	@Test
	public void testNextSlide(Method method) {
		HomePage homepage = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		homepage.nextSlide();
	}

	@Test
	public void testBackSlide(Method method) {
		HomePage homepage = new HomePage(
				drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { method })));
		homepage.backSlide();
	}
}
