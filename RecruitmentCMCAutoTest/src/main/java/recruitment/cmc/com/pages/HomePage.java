package recruitment.cmc.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import recruitment.cmc.com.settings.Constant;
import recruitment.cmc.com.settings.ExcelUtils;
import recruitment.cmc.com.settings.URL;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	List<WebElement> allMenus;	
	@FindBy(xpath = "/html/body/div[4]/section/section/div/div/div[1]/div[2]/img")
	WebElement slidePageActive1;
	
	@FindBy(xpath = "/html/body/div[4]/section/section/div/div/div[3]/div[2]/img")
	WebElement slidePageActive2;
	
	@FindBy(xpath = "/html/body/div[4]/section/section/div/div/div[2]/div[2]/img")
	WebElement slidePageActive3;

	// Get status display logo
	public boolean isDisplayedLogo() {
		return logo.isDisplayed();
	}
	//Begin of dunghtt1============================================================
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

	// Create object array to store data from file excel
	public Object[][] getDataFromFile() throws Exception {
		ExcelUtils.setExcelFile(URL.File_MenuData, "Sheet1");
		int rowCount = ExcelUtils.getTotalRow();
		Object[][] object = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			object[i][0] = ExcelUtils.getCellData(i + 1, 1);
			object[i][1] = ExcelUtils.getCellData(i + 1, 2);
		}
		return object;
	}

	// Create object array to store data from web
	public Object[][] getDataFromWeb() throws Exception {
		int rowCount = allMenus.size();
		Object[][] object = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			object[i][0] = allMenus.get(i).getText();
			String strUrl = allMenus.get(i).getAttribute("href");
			if (strUrl == null)
				strUrl = "";
			object[i][1] = strUrl;
		}
		return object;
	}

	// Check if the menu in the web array exists in the file array
	public boolean compareMenuInFile(String menu, String url, Object[][] arrFile) {
		int arrlen = arrFile.length;
		for (int i = 0; i < arrlen; i++) {
			if ((arrFile[i][0].toString().equalsIgnoreCase(menu)) && (arrFile[i][1].toString().equalsIgnoreCase(url))) {
				//System.out.println("arrFile=" + arrFile + "url=" + url + "=" + arrFile[i][0].toString().equalsIgnoreCase(menu));
				return true;
			}
		}
		return false;
	}
	
	//Get status of function like/unlike
	public boolean getStatusLikeFunction(String sLogin, String sLike) {

		boolean likeStatus = false;
		boolean isLogin = getStatusLogin();

		// Check alert function - case not logged in yet
		if (sLogin.equalsIgnoreCase("notLogin")) {
			if (isLogin) {
				logOutThePage();
			}
			// Wait and click on 1st Hot News link
			waitForElementVisible(15, hotNew);
			hotNew.findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();
			// Wait and click button Like
			waitForElementVisible(15, btnLike);
			btnLike.click();
			// Wait alert and verify text
			waitForAlertVisible(15);
			String text = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if (text.equalsIgnoreCase("Bạn chưa đăng nhập")) {
				likeStatus = true;
			}
		} else { // case logged in
			if (!isLogin) {
				loginToPage("sauriengj6@gmail.com", "123456aA@");
			}

			// Click on 1st Hot News again
			waitForElementVisible(15, hotNew);
			hotNew.findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();

			// Wait button Like
			waitForElementVisible(15, btnLike);
			boolean isLike = btnLike.getText().equalsIgnoreCase("Đã thích");

			if (sLike.equalsIgnoreCase("notLike")) {
				if (isLike) {
					btnLike.click();
				}
				btnLike.click();
				if (btnLike.getText().equalsIgnoreCase("Đã thích")) {
					likeStatus = true;
				}
			} else { // case Liked
				// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				btnLike.isDisplayed();
				if (!isLike) {
					btnLike.click();
				}
				btnLike.click();
				if (btnLike.getText().equalsIgnoreCase("Yêu thích")) {
					likeStatus = true;
				}
			}
		}
		return likeStatus;
	}
	//End of dunghtt1============================================================

	// Get src slide
	public List<WebElement> EnnoughSlide() {
		// lay list 3 anh hien thi tren slide
		List<WebElement> listElement = driver
				.findElements(By.cssSelector(".home-page-slider .carousel-item .mask-banner img"));
		int size = listElement.size();
		System.out.println(size);
		// in ten cai slide active
		System.out.println(slideActive.getAttribute("src"));
		// kiem tra image1 cos nam trong list image vua lay duoc khong
		for (int i = 0; i < listElement.size(); i++) {
			if (Constant.name_image1.equals(listElement.get(i).getAttribute("src"))) {
				System.out.println("Enough slide");
			}
		}
		return listElement;
	}

//	Next slide
	public void NextSlide() {
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[2]")).click();
		if (slidePageActive1.getAttribute("src") != slidePageActive2.getAttribute("src")) {
			System.out.println("Next successfull");
		} else {
			System.out.println("Next fail");
		}
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[2]")).click();
	}

	// Back slide
	public void BackSlide() {
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[1]/span[1]")).click();
		if (slidePageActive1.getAttribute("src") != slidePageActive3.getAttribute("src")) {
			System.out.println("Back successfull");
		} else {
			System.out.println("Back fail");
		}
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[1]/span[1]")).click();
	}
}
