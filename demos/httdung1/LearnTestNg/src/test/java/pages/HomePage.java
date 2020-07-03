package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.ExcelUtils;
import common.Settings;

public class HomePage {
	WebDriver driver;

	@FindBy(how = How.CSS, using = ".navbar-brand.logo_cmc")
	WebElement logo;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='col-lg-10']/ul/li"))
	List<WebElement> allMenus;
	
	//Init driver and elements
	public HomePage(WebDriver driver_) {
		driver = driver_;
		PageFactory.initElements(driver, this);
	}

	//Get status display logo
	public boolean isDisplayedLogo() {
		return logo.isDisplayed();
	}

	//Get title of page
	public String getTitle() {
		return driver.getTitle();
	}	
	
	// Get the number of menus on the job page - From web
	public int getNumberMenuFromWeb() throws Exception {
		int nummenu = allMenus.size();
		return nummenu;
	}
		
	//Get the number of menus on the job page - From file 
	public int getNumberMenuFromFile() throws Exception {		
		ExcelUtils.setExcelFile(Settings.File_MenuData,"Sheet1");		
		return ExcelUtils.getTotalRow();
	}
		
	public ArrayList<String> getListMenuFromWeb() throws Exception {
		ArrayList<String> listmenus = new ArrayList<String>();		
		for (WebElement e : allMenus) {
			listmenus.add(e.getText());						
		}
		return listmenus;
	}
	
	public ArrayList<String> getListMenuFromFile() throws Exception {
		ArrayList<String> arrMenus = new ArrayList<String>();
		arrMenus.add("TRANG CHỦ");
		arrMenus.add("CÔNG VIệC");
		arrMenus.add("TIN TỨC");
		arrMenus.add("VỀ CMC");
		arrMenus.add("ĐĂNG NHẬP");
		arrMenus.add("ĐĂNG KÝ");
		return arrMenus;
	}
	
}
