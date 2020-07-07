package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitments extends BasePage {

	@FindBy(xpath = "//div[@class='menu-pc']//a[@class='nav-link'][contains(text(),'CMC')]")
	@CacheLookup
	WebElement buttonAboutCMC;

	@FindBy(xpath = "//ul[@class='menu_job']//*[contains(@href,'/moi-truong-lam-viec')]")
	WebElement buttonWorkEnviroment;

	@FindBy(id = "page-heading")
	WebElement textConfirm;

	public Recruitments(WebDriver driver) {
		super(driver);
	}
	
	public String getHoverColor() {		
		Actions action = new Actions(driver);		
		action.moveToElement(buttonAboutCMC).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(buttonAboutCMC));
		String rgbFormat = buttonAboutCMC.getCssValue("background-color"); 
		
		System.out.println("rgbFormat="+ rgbFormat); //Output of RGB format will be print => rgba(28, 154, 214, 0.576)
		String hexcolor = Color.fromString(rgbFormat).asHex(); 
		System.out.println("hexcolor=" + hexcolor); // Output of Hex code will be  => #1c9ad6
		return hexcolor;
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
		isHover();
		buttonWorkEnviroment.click();
		return textConfirm.getText();
	}
}
