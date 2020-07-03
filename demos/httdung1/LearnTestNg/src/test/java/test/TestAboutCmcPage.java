package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AboutCmcPage;

public class TestAboutCmcPage extends TestTemplate {
	public AboutCmcPage objVeCmc;
	
	@Test (priority = 1)
	public void testGoto_MoiTruongLv() {
		
		if (objVeCmc==null) {
			// Create Login Page object
			objVeCmc = new AboutCmcPage(driver);	
		}		
	
		String txtTam = objVeCmc.moveToCmc();
		Assert.assertTrue(txtTam.toUpperCase().contains("VỀ CMC"));	
		
		txtTam = objVeCmc.moveToMoitruongLv();
		Assert.assertTrue(txtTam.toLowerCase().contains("môi trường làm việc"));	
		
	}
}
