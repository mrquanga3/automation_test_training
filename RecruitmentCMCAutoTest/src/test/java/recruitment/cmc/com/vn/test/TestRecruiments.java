package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import recruitment.cmc.com.pages.Recruitments;

public class TestRecruiments extends TestTemplate {
	@Test
	public void testHoverRec(Method method) {
		Recruitments tRec = new Recruitments(drivers.get(method.getName()));
		assertEquals(tRec.isHover(), true);
	}

	@Test(dependsOnMethods = { "testHoverRec" })

	public void testHoverAndClickRec(Method method) {
		Recruitments tHaC = new Recruitments(drivers.get(method.getName()));
		String text = tHaC.hoverAndClick();
		assertEquals(text.toUpperCase(), "Môi trường làm việc".toUpperCase());
	}
}
