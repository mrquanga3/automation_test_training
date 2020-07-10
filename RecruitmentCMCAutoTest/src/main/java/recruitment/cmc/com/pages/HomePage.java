package recruitment.cmc.com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import recruitment.cmc.com.settings.ExcelUtils;
import recruitment.cmc.com.settings.URL;

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
		ExcelUtils.setExcelFile(URL.File_MenuData, "Sheet1");
		return ExcelUtils.getTotalRow();
	}

	
	//Create object array to store data from file excel
	public Object[][] getDataFromFile() throws Exception {			
		ExcelUtils.setExcelFile(URL.File_MenuData, "Sheet1");
		int rowCount = ExcelUtils.getTotalRow();
		Object[][] object = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			object[i][0] = ExcelUtils.getCellData(i+1, 1);
			object[i][1] = ExcelUtils.getCellData(i+1, 2);
		}		
		return object;
	}
	
	//Create object array to store data from web
	public Object[][] getDataFromWeb() throws Exception {
		int rowCount = allMenus.size();
		Object[][] object = new Object[rowCount][2];		
		for (int i= 0; i < rowCount ; i++) {
			object[i][0] = allMenus.get(i).getText();
			String strUrl = allMenus.get(i).getAttribute("href");
			if (strUrl == null) strUrl = "";
			object[i][1] = strUrl;	
		}			
		return object;
	}
		
	// Check if the menu in the web array exists in the file array
	public boolean compareMenusProvider(String menu, String url, Object[][] arrFile) {		
		int arrlen = arrFile.length;
		for (int i = 0; i < arrlen; i++) {
			if ((arrFile[i][0].toString().equalsIgnoreCase(menu))
					&& (arrFile[i][1].toString().equalsIgnoreCase(url))) {
				System.out.println("arrFile=" + arrFile + "url=" + url + "=" + arrFile[i][0].toString().equalsIgnoreCase(menu));
				return true;
			}
		}
		return false;
	}
	 
}