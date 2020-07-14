package recruitment.cmc.com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	@FindBy(xpath = "//li[@class='nav-item work']//a[@class='btn-log login-portal']")
	WebElement buttonLogin;

	@FindBy(xpath = "//*[@id='login_popup_id']//a[@href='/login-google']")
	WebElement buttonGoogle;

	@FindBy(xpath = "//input[@autocomplete='username']")
	WebElement accTextBox;

	@FindBy(xpath = "//div[@id='identifierNext']")
	WebElement nextAcc;

	@FindBy(name = "password")
	WebElement passTextBox;

	@FindBy(xpath = "//div[@id='passwordNext']")
	WebElement nextPass;

	@FindBy(xpath = "//*[@id='btn-user-name-desktop']")
	WebElement buttonConfirm;

	@FindBy(xpath = "//a[@id='logout_portal']")
	WebElement buttonLogOut;

	@FindBy(xpath = "//a[@id='btn-user-name-desktop']")
	WebElement buttonProfile;
	
	@FindBy(css = ".navbar-brand.logo_cmc")
	WebElement logo;

	@FindAll(@FindBy(xpath = "//div[@class='col-lg-10']/ul/li/a"))
	List<WebElement> allMenus;
	
	@FindBy(how = How.CSS, using = ".carousel-item.active .mask-banner img")
	WebElement slideActive;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	public String login() {
		buttonLogin.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		buttonGoogle.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accTextBox.sendKeys("tungthse02891@gmail.com");
		nextAcc.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		passTextBox.sendKeys("DarkLord.123");
		nextPass.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return buttonConfirm.getText();
	}

	public String logOut() {
		Actions action = new Actions(driver);
		action.moveToElement(buttonProfile).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(buttonLogOut)).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return buttonLogin.getText();
	}
}
