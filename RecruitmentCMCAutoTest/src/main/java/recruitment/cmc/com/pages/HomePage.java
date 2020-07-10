package recruitment.cmc.com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import recruitment.cmc.com.settings.Constant;

public class HomePage extends BasePage {
	@FindBy(how = How.CSS, using =".carousel-item.active .mask-banner img")
	WebElement slideActive;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// Get src slide
	public List<WebElement> EnnoughSlide(){
		//lay list 3 anh hien thi tren slide
		List<WebElement> listElement = driver.findElements(By.cssSelector(".home-page-slider .carousel-item .mask-banner img"));
		int size = listElement.size();
		System.out.println(size);
		//in ten cai slide active
		System.out.println(slideActive.getAttribute("src"));
		//kiem tra image1 cos nam trong list image vua lay duoc khong
		for (int i = 0; i < listElement.size(); i++) {
			if(Constant.name_image1.equals(listElement.get(i).getAttribute("src"))) {
				System.out.println("Enough slide");
			}
		}
		return listElement;
	}

//	Next slide
	public void NextSlide() {
		WebElement slidePageActive1 = driver.findElement(By.xpath("*[@id=\"carousel-example-generic\"]/div/div[1]/div[2]/img"));
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[2]")).click();
		WebElement slidePageActive2 = driver.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div[3]/div[2]/img"));
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[2]")).click();
		WebElement slidePageActive3 = driver.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div[2]/div[2]/img"));
	}
	
	// Back slide
	public void BackSlide() {
		WebElement slidePageActive1 = driver.findElement(By.xpath("*[@id=\"carousel-example-generic\"]/div/div[1]/div[2]/img"));
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[1]/span[1]")).click();
		WebElement slidePageActive2 = driver.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div[2]/div[2]/img"));
		driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/a[1]/span[1]")).click();
		WebElement slidePageActive3 = driver.findElement(By.xpath("/html/body/div[4]/section/section/div/div/div[3]/div[2]/img"));
	}	
}
