package test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.Recruitments;

public class TestRecruiments extends TestTemplate {	
	Recruitments tRec;
	@Test
	public void testColorHoverRec() {		
		tRec = new Recruitments(driver);		
		assertEquals(tRec.getHoverColor(), "#1c9ad6");
	}
	@Test
	public void testHoverRec() {
		tRec = new Recruitments(driver);
		assertEquals(tRec.isHover(), true);
	}

	@Test (dependsOnMethods={"testHoverRec"})	
	public void testHoverAndClickRec() {
		tRec = new Recruitments(driver);
		String text = tRec.hoverAndClick();
		assertEquals(text.toUpperCase(), "Môi trường làm việc".toUpperCase());

	}
}
