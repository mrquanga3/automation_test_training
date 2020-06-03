package learn_fhome;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnFromHome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\work\\chromedriver_win32\\chromedriver.exe");
		WebDriver anhNem = new ChromeDriver();
		anhNem.manage().window().maximize();
		anhNem.get("https://www.cmc.com.vn/");
		//findElement
		WebElement emNem = anhNem.findElement(By.cssSelector("#header > div > div > div > div.col-lg-9.col-4.position-static > nav > div.menu__pc.-ascendant.d-inline-flex > div.menu__pc__item.menu__pc__item--ascendant.ml-0 > span"));
		Actions action = new Actions(anhNem);
		action.moveToElement(emNem).perform();
		WebElement x = anhNem.findElement(By.xpath("/html/body/header/div/div/div/div[2]/nav/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/a"));
		if(x!=null) {
			x.click();
		} else {
			return;
		}

		//scroll
		JavascriptExecutor js = ((JavascriptExecutor) anhNem);
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		anhNem.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(3000);
		anhNem.close();
	}

}
 
 