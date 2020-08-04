package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.HomePage;

public class TestHomePage extends TestTemplate {

	// Save case test data to object array for method verifyLikeFunction()
	@DataProvider(name = "likedata")
	public Object[][] likeDataprovider() throws Exception {
		return new Object[][] { { "notLogin", "", 0 }, { "loggedIn", "notLike", 1 }, { "loggedIn", "liked", 2 } };
	}

	// Check like function on recruitment page use method likeDataprovider()
	@Test(dataProvider = "likedata")
	public void verifyLikeFunction(String sLogin, String sLike, int index, Method method) throws Exception {
		HomePage homePage = new HomePage(drivers.get(method.getName()));
		boolean resultTest = homePage.getStatusLikeFunction(sLogin, sLike, index);
		assertEquals(resultTest, true, "Function like is fail!");
	}
	// End of dunghtt1============================================================
}
