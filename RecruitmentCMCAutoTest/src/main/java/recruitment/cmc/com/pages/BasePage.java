package recruitment.cmc.com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	
	@FindAll(@FindBy(xpath = "//div[@class='col-lg-10']/ul/li/a"))
	List<WebElement> allMenus;
	
	@FindBy(xpath = "//li[@class='nav-item work']//a[@class='btn-log login-portal']")
	WebElement buttonLogin;

	@FindBy(xpath = "//*[@id='login_popup_id']//a[@href='/login-google']")
	WebElement buttonGoogle;
	
	@FindBy(id="identifierId")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPass;
	
	@FindBy(id="btn-user-name-desktop")
	WebElement labelLogin;
	
	@FindAll(@FindBy(id="btn-user-name-desktop"))
	List<WebElement> labelLogins;
	
	@FindBy(id="identifierNext")
	WebElement btnNext;
	
	@FindBy(id="passwordNext")
	WebElement btnLogin;
	
	@FindBy(id="logout_portal")
	WebElement linkLogout;
	
	@FindBy(xpath = "//ul[@class='row list-job-more']")
	WebElement hotNew;
	
	@FindBy(id="btn-like-fb")
	WebElement btnLike;
	
	//End of Dunghtt1
	
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
	
	@FindBy(css = ".carousel-item.active .mask-banner img")
	WebElement slideActive;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	

	public String login() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		buttonLogin.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		buttonGoogle.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accTextBox.sendKeys("tungthse02891@gmail.com");
		nextAcc.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(passTextBox));
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
	
	/**
	 * Wait for Element visible
	 * @param seconds Wait for Element to visible for seconds seconds
	 * @param elementLocator The Element need to wait
	 **/
	
	public void waitForElementVisible(int seconds, WebElement elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(elementLocator));		
		wait.until(ExpectedConditions.elementToBeClickable(elementLocator));		
	}
	
	/**
	 * Wait for Alert visible
	 * @param seconds Wait for Alert to visible for seconds seconds	
	 **/
	public void waitForAlertVisible(int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.alertIsPresent());			
	}

	// Login to page Tuyen Dung
	public void loginToPage(String strEmail, String strPassword) {
		// Go to page Dang nhap
		buttonLogin.click();
		buttonGoogle.click();
		// Set email
		waitForElementVisible(10, txtEmail);
		txtEmail.sendKeys(strEmail);
		btnNext.click();
		// Set pass
		waitForElementVisible(10, txtPass);
		txtPass.sendKeys(strPassword);
		btnLogin.click();
	}
	
	// Logout from page Tuyen Dung		
	public void logOutThePage() { 
		// Move to link Logout Actions action = new
		Actions action = new Actions(driver);
		waitForElementVisible(15, labelLogin);
		action.moveToElement(labelLogin).build().perform(); 
		// Click to Logout
		waitForElementVisible(15, linkLogout);
		linkLogout.click();
	}		 
	
	// Get status login
	public Boolean getStatusLogin() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (!labelLogins.isEmpty()) {
			//System.out.println("Da login");
			return true;
		} else {
			//System.out.println("Chua login");
			return false;
		}
	}	
}
