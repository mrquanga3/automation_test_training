package test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestHomePage extends TestTemplate {

	// Check the title of the Job page 
	@Test
	public void testTitle() {
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals("Tuyển dụng CMC Corporation", homePage.getTitle());
	}

	// Check the number of menus on the Job page 
	@Test
	public void testNumberMenus() throws Exception {
		HomePage homePage = new HomePage(driver);
		System.out.println("aaaa=" + homePage.getNumberMenuFromWeb());
		System.out.println("bbbb=" + homePage.getNumberMenuFromFile());
		Assert.assertEquals(homePage.getNumberMenuFromWeb(), homePage.getNumberMenuFromFile());
	}
	
	// Check displaying the menus on the Job page
	@Test
	public void testDisplayMenus() throws Exception {
		HomePage homePage = new HomePage(driver);	
		ArrayList<String> listMn = homePage.getListMenuFromWeb();
		ArrayList<String> arrMns = homePage.getListMenuFromFile();
		System.out.println("So sanh" + listMn.contains("TRANG CHỦ"));
		System.out.println(arrMns);
			
	}
}