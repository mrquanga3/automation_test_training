package recruitment.cmc.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitments extends BasePage {

	@FindBy(xpath = "(//li[@class='nav-item job']//a[contains(text(),'Về CMC')])[2]")
	WebElement buttonAboutCMC;

	@FindBy(xpath = "(//a[@href='/moi-truong-lam-viec?lang='])[2]")
	WebElement buttonWorkEnviroment;

	@FindBy(xpath = "//div[@id='page-heading']")
	WebElement textConfirm;

	public Recruitments(WebDriver driver) {
		super(driver);
	}

	public boolean isHover() {
		Actions action = new Actions(driver);
		String colorBeforeHover = buttonAboutCMC.getCssValue("background-color");
		action.moveToElement(buttonAboutCMC).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(buttonAboutCMC));
		String colorAfterHover = buttonAboutCMC.getCssValue("background-color");
		return colorBeforeHover != colorAfterHover;
	}

	public String hoverAndClick() {
		Actions action = new Actions(driver);
		action.moveToElement(buttonAboutCMC).build().perform();
		buttonWorkEnviroment.click();
		return textConfirm.getText();
	}
}
