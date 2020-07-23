package recruitment.cmc.com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {
	WebDriver driver;
	@FindBy(xpath = "(//li[@class='nav-item']//a[@href='/tin-tuc?lang=vi'])[2]")
	WebElement buttonNews;

	// @FindBy(xpath = "//a[normalize-space()='4 Ưu tiên của CFO trong năm 2020 cho
	// nền tảng tài chính doanh nghiệp vững chắc']")
	@FindBy(xpath = "(//i[@class='fa fa-angle-double-right'])[1]")
	WebElement news;

	@FindBy(xpath = "//button[@id='btn-like-fb']")
	WebElement buttonLike;

	public NewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		if(buttonLike.getText().equalsIgnoreCase("Yêu thích")) {
			buttonLike.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonLike));
			return buttonLike.getText();
		}else {
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
	
	/*
	 * public String getAPI() { // Specify the base URL to the RESTful web service
	 * RestAssured.baseURI = "https://tuyendung.cmc.com.vn";
	 * 
	 * RequestSpecification httpRequest = RestAssured.given().params("idUser",
	 * "3237", "idNews", "68"); Response response = httpRequest.request(Method.POST,
	 * "/portal/interactnews/is_like"); return response.getBody().print(); }
	 */
}
