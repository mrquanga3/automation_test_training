package recruitment.cmc.com.pages;

import java.util.concurrent.TimeUnit;

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
		BasePage basepage = new BasePage(driver);
		basepage.login();
		buttonNews.click();
		news.click();
		buttonLike.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buttonLike.getText();
	}
	
	public String pressUnLikeButtonLogged() {
		/*
		 * BasePage basepage = new BasePage(driver); basepage.login();
		 * buttonNews.click(); news.click(); buttonLike.click();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 */
		buttonLike.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return buttonLike.getText();
	}
	
}
