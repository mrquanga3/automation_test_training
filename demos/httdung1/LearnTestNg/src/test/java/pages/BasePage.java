package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	@FindBy(xpath = "//li[@class='nav-item work']//a[@class='btn-log login-portal']")
	WebElement buttonLogin;

	@FindBy(xpath = "//*[@id='login_popup_id']//a[@href='/login-google']")
	WebElement buttonGoogle;

	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement accTextBox;

	@FindBy(xpath = "//*[contains(text(),'Tiếp theo')]")
	WebElement nextAcc;

	@FindBy(name = "password")
	WebElement passTextBox;

	@FindBy(xpath = "//*[contains(text(),'Tiếp theo')]")
	WebElement nextPass;

	@FindBy(xpath = "//*[@id='btn-user-name-desktop']")
	WebElement buttonConfirm;

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
}
