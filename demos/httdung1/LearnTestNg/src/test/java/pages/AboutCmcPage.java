package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutCmcPage {

	WebDriver driver;
	By linkLoginPortal = By.xpath("//li[@class='nav-item work']//a[@class='btn-log login-portal']");
	By linkGoogle = By.xpath("//*[@id=\"login_popup_id\"]//a[@href='/login-google']");
	By txtEmail = By.id("identifierId");
	By txtPass = By.name("password");
	By labelTitle = By.id("btn-user-name-desktop");
	By btnNext = By.id("identifierNext");
	By btnLogin = By.id("passwordNext");	
	By linkLogout = By.id("logout_portal");

	public AboutCmcPage(WebDriver driver) {
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
	
	/**
	 * <b>Move to menu Ve CMC</b>
	 * @return label on the menu move to	
	 **/
	public String moveToCmc() {
		
		Actions action = new Actions(driver);	
		By linkCMC =  By.xpath("//div[@class='menu-pc']//a[@class='nav-link'][contains(text(),'CMC')]");
		waitForElementVisible(15, linkCMC);
		WebElement elCMC = driver.findElement(linkCMC);
		String bgColor = elCMC.getCssValue("background-color");
		System.out.println("bgColor1="+ bgColor);
		action.moveToElement(elCMC).build().perform();	
		bgColor = elCMC.getCssValue("background-color");
		System.out.println("bgColor2="+ bgColor);
		return elCMC.getText();
	}
	
	/**
	 * <b>Move to sub-menu moi truong lam viec</b>
	 * @return label on the menu move to	
	 **/
	public String moveToMoitruongLv() {
		
		Actions action = new Actions(driver);		
		By linkMoitruong =  By.xpath("//ul[@class='menu_job']//*[contains(@href,'/moi-truong-lam-viec')]");	
		waitForElementVisible(15, linkMoitruong);
		WebElement elMoitruong = driver.findElement(linkMoitruong);
		action.moveToElement(elMoitruong).build().perform();	
		return elMoitruong.getText();
		
	}
}
