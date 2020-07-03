package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import objectRepository.Recruitments;

public class TestRecruiments {
	@Test
	public void testHoverRec() {
		BrowserSetting bs = new BrowserSetting();
		WebDriver driver = bs.BrowserSettings();
		Recruitments tRec = new Recruitments(driver);
		String text = tRec.Hover();
		assertEquals(text, "");

	}
	
	@Test
	public void testHoverAndClickRec() {
		BrowserSetting bs = new BrowserSetting();
		WebDriver driver = bs.BrowserSettings();
		Recruitments tHaC = new Recruitments(driver);
		String text = tHaC.hoverAndClick();
		assertEquals(text, "Môi trường làm việc");
		

	}
}
