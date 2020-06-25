package SeleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	static WebDriver browse;

	@BeforeClass
	public void pre() {
		browse = new ChromeDriver();
		browse.get("https://tuyendung.cmc.com.vn/");
		browse.manage().window().maximize();
		WebElement login = browse.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		login.click();
		WebElement gg = browse.findElement(By.xpath("//div[@id='login_popup_id']//a[2]"));
		gg.click();
		WebElement account = browse.findElement(By.xpath("//input[@id='identifierId']"));
		account.sendKeys("sauriengj6");
		WebDriverWait wait = new WebDriverWait(browse, 1);
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//input[@name='password']")));
		 */ WebElement pass = browse.findElement(By.xpath("//input[@name='password']"));
		/* System.out.println(pass.getAttribute("value")); */
		pass.sendKeys("123456aA@");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'p theo')]")));
		WebElement nextpass = browse.findElement(By.xpath("//span[contains(text(),'p theo')]"));
		nextpass.click();
	}

	@Test
	public void testLogin() {
		WebDriverWait wait = new WebDriverWait(browse, 5);
		WebElement loged = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-user-name-desktop")));
		Assert.assertTrue(loged.getText().equalsIgnoreCase("123456aA@"));
	}



	@Test
	public void testBack() {
		browse.navigate().back();
		WebElement loged = browse.findElement(By.id("btn-user-name-desktop"));
		Assert.assertTrue(loged.getText().equalsIgnoreCase("CHINHLAANHNHE"));
	}

	@Test
	public void logOut() {
		Actions actions = new Actions(browse);
		WebElement lgo = browse.findElement(By.xpath("//a[@id='btn-user-name-desktop']"));
		actions.moveToElement(lgo).build().perform();
		browse.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lgu = browse.findElement(By.xpath("//a[@id='logout_portal']"));
		lgu.click();
		browse.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void relogin() {
		WebElement relogins = browse.findElement(By.xpath("//div[@class='menu-pc']//li[5]"));
		relogins.click();
		browse.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ggs = browse.findElement(By.xpath("//div[@id='login_popup_id']//a[2]")); //
		ggs.click();
	}

	@AfterClass
	public void close() {
		browse.close();
	}
}
