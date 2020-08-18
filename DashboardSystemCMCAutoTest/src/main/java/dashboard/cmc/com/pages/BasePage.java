package dashboard.cmc.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//span[@class='hidden-xs user-info']")
	WebElement inforButton;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String login(String sUsername, String sPassword) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		username.sendKeys(sUsername);
		password.sendKeys(sPassword);
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(inforButton));
		return inforButton.getText().trim();
	}
}
