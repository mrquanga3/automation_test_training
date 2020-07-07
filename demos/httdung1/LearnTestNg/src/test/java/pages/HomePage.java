package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.ExcelUtils;
import common.Settings;
import model.MenuInfo;

public class HomePage {
	WebDriver driver;

	@FindBy(css = ".navbar-brand.logo_cmc")
	WebElement logo;

	@FindAll(@FindBy(xpath = "//div[@class='col-lg-10']/ul/li/a"))
	List<WebElement> allMenus;

	// Init driver and elements
	public HomePage(WebDriver driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}

	// Get status display logo
	public boolean isDisplayedLogo() {
		return logo.isDisplayed();
	}

	// Get title of page
	public String getTitle() {
		return driver.getTitle();
	}

	// Get the number of menus on the job page - From web
	public int getNumberMenuFromWeb() throws Exception {
		int nummenu = allMenus.size();
		return nummenu;
	}

	// Get the number of menus on the job page - From file
	public int getNumberMenuFromFile() throws Exception {
		ExcelUtils.setExcelFile(Settings.File_MenuData, "Sheet1");
		return ExcelUtils.getTotalRow();
	}

	//Get list of menu of the job page - From web
	public ArrayList<MenuInfo> getListMenuFromWeb() throws Exception {
		ArrayList<MenuInfo> listmenus = new ArrayList<MenuInfo>();		
		for (int i= 0; i < allMenus.size() ; i++) {
			String strName = allMenus.get(i).getText();
			String strUrl = allMenus.get(i).getAttribute("href");
			if (strUrl == null) strUrl = "";
			listmenus.add(new MenuInfo(strName, strUrl));			
		}
		return listmenus;
	}
	
	//Get list of menu of the job page - From file
	public ArrayList<MenuInfo> getListMenuFromFile() throws Exception {
		ArrayList<MenuInfo> arrMenus = new ArrayList<MenuInfo>();
		ExcelUtils.setExcelFile(Settings.File_MenuData, "Sheet1");
		int rowCount = ExcelUtils.getTotalRow();
		for (int i = 1; i < rowCount + 1; i++) {
			String strName = ExcelUtils.getCellData(i, 1);
			String strUrl = ExcelUtils.getCellData(i, 2);
			arrMenus.add(new MenuInfo(strName, strUrl));			
		}
		return arrMenus;
	}
	
	//Check if the menu in the web array exists in the file array 
	public boolean compareMenus(ArrayList<MenuInfo> arrWeb, ArrayList<MenuInfo> arrFile) {
		for (int i = 0; i < arrWeb.size(); i++) {
			if(!arrFile.contains(arrWeb.get(i))) {
		    	return false;
		    }
		}		
		return true;
	}

}
