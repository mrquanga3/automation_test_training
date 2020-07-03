package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitments {
	WebDriver driver;

	@FindBy(xpath = "(//li[@class='nav-item job']//a[contains(text(),'Về CMC')])[2]")
	WebElement buttonAboutCMC;

	@FindBy(xpath = "(//a[@href='/moi-truong-lam-viec?lang='])[2]")
	WebElement buttonWorkEnviroment;

	@FindBy(xpath = "//div[@id='page-heading']")
	WebElement textConfirm;

	// constructor method
	public Recruitments(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
