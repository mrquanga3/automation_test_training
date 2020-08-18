package dashboard.cmc.com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectionAdress extends BasePage {

	public SelectionAdress(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='search-list search-add']//span[@class='multiselect-selected-text'][contains(text(),'a ch')]")
	WebElement search;
	@FindBy(xpath = "//div[@class='btn-group open']//label[@class='checkbox'][contains(text(),'t c')]")
	WebElement clikall;
	public void allAdress() {
		search.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		clikall.click();
	}
}
