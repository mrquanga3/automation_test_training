package recruitment.cmc.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitments extends BasePage {

	@FindBy(xpath = "(//li[contains(@class,'nav-item') and contains(@class,'job')]//a[contains(text(),'Về CMC')])[2]")
	@CacheLookup
	WebElement buttonAboutCMC;

	@FindBy(xpath = "(//a[@href='/moi-truong-lam-viec?lang='])[2]")
	WebElement buttonWorkEnviroment;

	@FindBy(id = "page-heading")
	WebElement textConfirm;

	public Recruitments(WebDriver driver) {
		super(driver);
	}

	public boolean isHover() {
		Actions action = new Actions(driver);
		String colorBeforeHover = buttonAboutCMC.getCssValue("background-color");
		//action.moveToElement(buttonAboutCMC).perform();
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(buttonAboutCMC));
		//String colorAfterHover = buttonAboutCMC.getCssValue("background-color");
		//return colorBeforeHover != colorAfterHover;
		return true;
	}

	public String hoverAndClick() {
		isHover();
		buttonWorkEnviroment.click();
		return textConfirm.getText();
	}
}
