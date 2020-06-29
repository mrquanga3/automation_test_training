package cmc.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	By linkLoginPortal = By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']");
	By linkGoogle = By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']");
	By txtEmail = By.id("identifierId");
	By txtPass = By.name("password");
	By labelTitle = By.id("btn-user-name-desktop");
	By btnNext = By.id("identifierNext");
	By btnLogin = By.id("passwordNext");	
	By linkLogout = By.id("logout_portal");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Wait for Element visible
	 * @param seconds Wait for Element to visible for seconds seconds
	 * @param elementLocator The Element need to wait
	 */
	public void waitForElementVisible(int seconds, By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	
	//launch Site Tuyen Dung
	public void launchSite() {
		driver.findElement(linkLoginPortal).click();
		driver.findElement(linkGoogle).click();
	}	

	// Get the title of Login Page
	public String getLoginTitle() {
		waitForElementVisible(15, labelTitle);
		return driver.findElement(labelTitle).getText();
	}
	
	// Get status logout
	public Boolean getStatusLogin() {	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (!driver.findElements(labelTitle).isEmpty()) {
			System.out.println("Da login");
			return true;
		} else {
			System.out.println("Chua login");
			return false;
		}			
	}

	/**
	 * <b>Login to page Tuyen Dung </b>
	 * @param strEmail Login by Email
	 * @param strPasword Password to login	
	 **/
	public void loginToPage(String strEmail, String strPassword) {
		//Go to page Tuyen Dung
		launchSite();		
		//Set email
		waitForElementVisible(10, txtEmail);
		driver.findElement(txtEmail).sendKeys(strEmail);
		driver.findElement(btnNext).click();
		//Set pass
		waitForElementVisible(10, txtPass);
		driver.findElement(txtPass).sendKeys(strPassword);
		driver.findElement(btnLogin).click();
	}
	
	/**
	 * <b>Logout from page Tuyen Dung</b>
	 * @param 	
	 **/
	public void logOut() {
		// Logout
		Actions action = new Actions(driver);		
		waitForElementVisible(15, labelTitle);
		WebElement btnUsername = driver.findElement(labelTitle);
		action.moveToElement(btnUsername).build().perform();

		waitForElementVisible(15, linkLogout);
		driver.findElement(linkLogout).click();		
	}
}
