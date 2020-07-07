package test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import model.MenuInfo;
import pages.HomePage;

public class TestHomePage extends TestTemplate {

	// Check the title of the Job page 
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
	
	// Check displaying the menus on the Job page
	@Test
	public void testDisplayMenus() throws Exception {
		HomePage homePage = new HomePage(driver);
		ArrayList<MenuInfo> listMns = homePage.getListMenuFromWeb();
		//System.out.println(listMns);
		ArrayList<MenuInfo> arrMns = homePage.getListMenuFromFile();
		//System.out.println(arrMns);
		boolean resultTest = homePage.compareMenus(listMns,arrMns);		
		assertEquals(resultTest, true);		
	}
}