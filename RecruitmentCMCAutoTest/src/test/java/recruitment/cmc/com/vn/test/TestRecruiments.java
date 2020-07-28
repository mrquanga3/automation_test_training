package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import recruitment.cmc.com.pages.Recruitments;

public class TestRecruiments extends TestTemplate {
	@Test
	public void testHoverRec() {
		Recruitments tRec = new Recruitments(driver);
		assertEquals(tRec.isHover(), true);
	}

	@Test(dependsOnMethods = { "testHoverRec" })

	public void testHoverAndClickRec() {
		Recruitments tHaC = new Recruitments(driver);
		String text = tHaC.hoverAndClick();
		assertEquals(text.toUpperCase(), "Môi trường làm việc".toUpperCase());
	}
}
