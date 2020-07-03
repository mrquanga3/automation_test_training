package recruitment.cmc.com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitments extends BasePage {

	@FindBy(xpath = "(//li[@class='nav-item job']//a[contains(text(),'Vá»? CMC')])[2]")
	WebElement buttonAboutCMC;

	@FindBy(xpath = "(//a[@href='/moi-truong-lam-viec?lang='])[2]")
	WebElement buttonWorkEnviroment;

	@FindBy(xpath = "//div[@id='page-heading']")
	WebElement textConfirm;

	public Recruitments(WebDriver driver) {
		super(driver);
	}

	public String Hover() {
		Actions action = new Actions(driver);
		action.moveToElement(buttonAboutCMC).perform();
		return buttonWorkEnviroment.getText();
	}

	public String hoverAndClick() {
		Actions action = new Actions(driver);
		action.moveToElement(buttonAboutCMC).build().perform();
		buttonWorkEnviroment.click();
		return textConfirm.getText();
	}
}
