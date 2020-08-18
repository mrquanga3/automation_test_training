package dashboard.cmc.com.vn.test;
import static org.testng.Assert.assertEquals;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dashboard.cmc.com.pages.BasePage;
import dashboard.cmc.com.settings.ExcelUtils;

public class TestHomePage extends TestTemplate {
	@DataProvider(parallel = true)
	public Object[][] authentication() throws Exception {
		ExcelUtils.setExcelFile("src/test/testData/TestData.xlsx", "Sheet1");
		Object[][] testObjArray = ExcelUtils.getTableArray("src/test/testData/TestData.xlsx", "Sheet1");
		return (testObjArray);
	}

	@Test(dataProvider = "authentication")
	public void testLogin(String sUsername, String sPassword, String fullname, Method method) {
		BasePage tlg = new BasePage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(new Object[] { sUsername, sPassword, fullname, method })));
		assertEquals(tlg.login(sUsername, sPassword), fullname);
	}
}
