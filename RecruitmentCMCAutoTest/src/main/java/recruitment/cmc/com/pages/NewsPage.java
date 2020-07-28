package recruitment.cmc.com.pages;

import java.util.ArrayList;
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

	// NTTDUNG
	@FindAll(@FindBy(xpath = "//div[@class='recent-post']"))
	List<WebElement> recentNews;

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
		BasePage basepage = new BasePage(driver);
		basepage.login();
		buttonNews.click();
		news.click();
		buttonLike.isDisplayed();
		if (buttonLike.getText().equalsIgnoreCase("Yêu thích")) {
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		} else {
			return buttonLike.getText();
		}
	}

	public String pressUnLikeButtonLogged() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		BasePage basepage = new BasePage(driver);
		basepage.login();
		buttonNews.click();
		news.click();
		buttonLike.isDisplayed();
		if (buttonLike.getText().equalsIgnoreCase("Đã thích")) {
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		} else {
			buttonLike.click();
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		}
	}

	// Begin of dunghtt1
	// Get the number of menus on the job page - From file
	public int getNumberMenuFromFile() throws Exception {
		ExcelUtils.setExcelFile(URL.File_NewsData, "Sheet1");
		return ExcelUtils.getTotalRow();
	}

	// Get list of menu of the job page - From file
	public ArrayList<NewsInfo> getListMenuFromFile() throws Exception {
		ArrayList<NewsInfo> arrNews = new ArrayList<NewsInfo>();
		ExcelUtils.setExcelFile(URL.File_NewsData, "Sheet1");
		int rowCount = ExcelUtils.getTotalRow();
		for (int i = 1; i < rowCount + 1; i++) {
			String subTitle = ExcelUtils.getCellData(i, 1);
			String urlBanner = ExcelUtils.getCellData(i, 2);
			String subContent = ExcelUtils.getCellData(i, 3);
			String detailContent = ExcelUtils.getCellData(i, 4);
			String postDate = ExcelUtils.getCellData(i, 5);
			arrNews.add(new NewsInfo(subTitle, urlBanner, subContent, detailContent, postDate));
		}
		return arrNews;
	}

	// Check display list of the News
	public boolean getStatusOfNewsList() throws Exception {

		linkNews.click();
		ArrayList<NewsInfo> arrNewsFile = new ArrayList<NewsInfo>();
		arrNewsFile = getListMenuFromFile();
		boolean resultFind = false;
		for (int i = 0; i < allNews.size(); i++) {
			WebElement title = allNews.get(i).findElement(By.className("title-sp"));
			WebElement content = allNews.get(i).findElement(By.className("text"));
			WebElement img = allNews.get(i).findElement(By.tagName("img"));
			String subTitle = title.getText();
			String urlBanner = img.getAttribute("src").toString();
			String subContent = content.getText();

			for (int j = 0; j < arrNewsFile.size(); j++) {
				resultFind = arrNewsFile.get(j).subTitle.equalsIgnoreCase(subTitle);
				resultFind = resultFind && urlBanner.contains(arrNewsFile.get(j).urlBanner);
				resultFind = resultFind && subContent.contains(arrNewsFile.get(j).subContent);
				if (resultFind) {
					continue;
				}
			}
		}
		return resultFind;
	}

	// Check display detail of the News
	public boolean getStatusDetailOfNews() throws Exception {

		ArrayList<NewsInfo> arrNewsFile = new ArrayList<NewsInfo>();
		arrNewsFile = getListMenuFromFile();
		boolean resultFind = false;

		linkNews.click();

		WebElement btnDetail = allNews.get(0).findElement(By.className("read-more"));
		btnDetail.click();

		waitForElementVisible(5, eTitle);
		String subTitle = eTitle.getText();
		String urlBanner = eImg.getAttribute("src").toString();
		String subContent = eSubContent.getText();
		String postDate = eTime.getText();
		String detailContent = eDetail.get(1).getText();

		resultFind = arrNewsFile.get(0).subTitle.equalsIgnoreCase(subTitle);
		resultFind = resultFind && urlBanner.contains(arrNewsFile.get(0).urlBanner);
		resultFind = resultFind && subContent.contains(arrNewsFile.get(0).subContent);
		resultFind = resultFind && postDate.contains(arrNewsFile.get(0).postDate);
		resultFind = resultFind && detailContent.contains(arrNewsFile.get(0).detailContent);
		return resultFind;
	}
	// End of dunghtt1

	// NTTDUNG
	// Get list of recent news from file
	public ArrayList<NewsInfo> getFileListRecentNews() throws Exception {
		ArrayList<NewsInfo> arrFileRecentNews = new ArrayList<NewsInfo>();
		ExcelUtils.setExcelFile(URL.File_RecentNews, "Sheet1");
		int rowCount = ExcelUtils.getTotalRow();
		for (int i = 1; i < rowCount + 1; i++) {
			String img = ExcelUtils.getCellData(i, 2);
			String date = ExcelUtils.getCellData(i, 3);
			String title = ExcelUtils.getCellData(i, 4);
			arrFileRecentNews.add(new NewsInfo(img, date, title));
		}
		return arrFileRecentNews;
	}

	// Get list of recent news
	public boolean getRecentNews() throws Exception {
		linkNews.click();
		ArrayList<NewsInfo> arrRecentNews = new ArrayList<NewsInfo>();
		arrRecentNews = getFileListRecentNews();
		boolean resultFind = true;

		for (int i = 0; i < recentNews.size(); i++) {
			WebElement imgURL = recentNews.get(i).findElement(By.tagName("img"));
			WebElement dateText = recentNews.get(i).findElement(By.className("time-rec"));
			WebElement titleText = recentNews.get(i).findElement(By.className("title-rec ddd-truncated"));
			String img = imgURL.getAttribute("src");
			String date = dateText.getText();
			String title = titleText.getText();

			for (int j = 0; j < arrRecentNews.size(); j++) {
				resultFind = resultFind && img.contains(arrRecentNews.get(j).img);
				resultFind = arrRecentNews.get(j).title.equalsIgnoreCase(title);
				resultFind = resultFind && date.contains(arrRecentNews.get(j).date);
				if (resultFind) {
					continue;
				}
			}
		}
		return resultFind;
	}

}
