package recruitment.cmc.com.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import recruitment.cmc.com.settings.ExcelUtils;
import recruitment.cmc.com.settings.NewsInfo;
import recruitment.cmc.com.settings.URL;


public class NewsPage extends BasePage {
	/*
	 * @FindBy(xpath="(//li[@class='nav-item']//a[@href='/tin-tuc?lang=vi'])[3]")
	 * WebElement news3;
	 * 
	 * @FindBy(xpath="(//li[@class='nav-item']//a[@href='/tin-tuc?lang=vi'])[2]")
	 * WebElement news2;
	 */
	
	@FindBy(xpath = "(//li[@class='nav-item']//a[@href='/tin-tuc?lang=vi'])[2]")
	WebElement buttonNews;

	// @FindBy(xpath = "//a[normalize-space()='4 Ưu tiên của CFO trong năm 2020 cho
	// nền tảng tài chính doanh nghiệp vững chắc']")
	@FindBy(xpath = "(//i[@class='fa fa-angle-double-right'])[1]")
	WebElement news;

	@FindBy(xpath = "//button[@id='btn-like-fb']")
	WebElement buttonLike;
	
	// Begin of dunghtt1
	@FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//a[@href='/tin-tuc?lang=vi']")
	WebElement linkNews;
	
	@FindBy(xpath = "//ul[@class='list-new']")
	WebElement ulNews;
	
	@FindAll(@FindBy(xpath = "//ul[@class='list-new']/li"))
	List<WebElement> allNews;
	
	@FindBy(xpath = "//div[@class='title-sp']")
	WebElement eTitle;
	
	@FindBy(xpath = "//div[@class='content-detail']//div[@class='text']")
	WebElement eSubContent;
	
	@FindBy(xpath = "//div[@class='img-sp']/img")
	WebElement eImg;
	
	@FindBy(xpath = "//div[@class='note-sp']/span[@class='time']")
	WebElement eTime;
	
	@FindAll(@FindBy(xpath = "//div[@class='bot']/div[@class='text']"))
	List<WebElement> eDetail;
	
	public NewsPage(WebDriver driver) {
		super(driver);
	}

	public String pressLikeButton() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		buttonNews.click();
		news.click();
		buttonLike.click();
		wait.until(ExpectedConditions.alertIsPresent());
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;
		
	}
	
	public String pressLikeButtonLogged() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login();
		buttonNews.click();
		news.click();
		//buttonLike.isDisplayed();
		if(buttonLike.getText().equalsIgnoreCase("Yêu thích")) {
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		}
			return buttonLike.getText();
	}
	
	public String pressUnLikeButtonLogged() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		login();
		buttonNews.click();
		news.click();
		buttonLike.isDisplayed();
		if(buttonLike.getText().equalsIgnoreCase("Đã thích")) {
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		}else {
			buttonLike.click();
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		}
	}
	
	// Begin of dunghtt1
	//Get the number of menus on the job page - From file
	public int getNumberNewsFromFile() throws Exception {
		ExcelUtils.setExcelFile(URL.File_NewsData, "Sheet1");
		return ExcelUtils.getTotalRow();
	}

	// Get list of menu of the job page - From file
	public NewsInfo[] getListNewsFromFile() throws Exception {		
		ExcelUtils.setExcelFile(URL.File_NewsData, "Sheet1");
		int rowCount = ExcelUtils.getTotalRow();
		
		NewsInfo arrNews[] = new NewsInfo[rowCount];
		for (int i = 1; i < rowCount + 1; i++) {
			String subTitle = ExcelUtils.getCellData(i, 1);
			String urlBanner = ExcelUtils.getCellData(i, 2);
			String subContent = ExcelUtils.getCellData(i, 3);
			String detailContent = ExcelUtils.getCellData(i, 4);
			String postDate = ExcelUtils.getCellData(i, 5);
			arrNews[i-1]= new NewsInfo(subTitle, urlBanner, subContent, detailContent, postDate);
		}
		return arrNews;
	}
	
	//Check display list of the News
	public String getStatusOfNewsList(String subTitle, String urlBanner, String subContent, String detailContent, String postDate) throws Exception {
		
		linkNews.click();		
		boolean resultFind = false;
		boolean aResult = false;
		String errorMsg = "";
		for (int i = 0; i < allNews.size(); i++) {
			aResult = allNews.get(i).findElement(By.className("title-sp")).getText().equalsIgnoreCase(subTitle);
			if (!aResult) errorMsg = "Tittle";
			resultFind = aResult;
			aResult = allNews.get(i).findElement(By.className("text")).getText().contains(subContent);
			if (!aResult) errorMsg = "Sub Content";
			resultFind = resultFind && aResult;
			aResult = allNews.get(i).findElement(By.tagName("img")).getAttribute("src").toString().contains(urlBanner);
			if (!aResult) errorMsg = "Banner";
			resultFind = resultFind && aResult;
			if (resultFind) return "Display correct the news";
		}
		return "Do not display or display incorrect " + errorMsg + " of the news: " + subTitle;
	}
	
	//Check display detail of the 1st News
	public String getStatusDetailOfNews() throws Exception {
		
		NewsInfo arrNewsFile[] = getListNewsFromFile();	
		boolean resultFind = false;
		boolean aResult = false;
		String errorMsg = "";
		
		linkNews.click();		
		WebElement btnDetail = allNews.get(0).findElement(By.className("read-more"));
		btnDetail.click();
		
		waitForElementVisible(5,eTitle);			
		aResult = arrNewsFile[0].subTitle.equalsIgnoreCase( eTitle.getText());	
		if (!aResult) errorMsg = "Tittle";
		resultFind = aResult;
		aResult = eImg.getAttribute("src").toString().contains(arrNewsFile[0].urlBanner);	
		if (!aResult) errorMsg = "Banner";
		resultFind = resultFind && aResult;
		aResult = eSubContent.getText().contains(arrNewsFile[0].subContent);	
		if (!aResult) errorMsg = "Sub Content";
		resultFind = resultFind && aResult;
		aResult = eTime.getText().contains(arrNewsFile[0].postDate);	
		if (!aResult) errorMsg = "Post Date";
		resultFind = resultFind && aResult;
		aResult = eDetail.get(1).getText().contains(arrNewsFile[0].detailContent);	
		if (!aResult) errorMsg = "Detail Content";
		resultFind = resultFind && aResult;
		if (resultFind) {
			return "Display correct the news";
		}else {
			return "Do not display or display incorrect " + errorMsg + " of the news: " + arrNewsFile[0].subTitle;
		}
	}	
	// End of dunghtt1
}
