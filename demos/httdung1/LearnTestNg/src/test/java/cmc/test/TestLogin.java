package cmc.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import cmc.login.LoginPage;
import cmc.login.WebBrowser;

public class TestLogin extends WebBrowser{
	
	public LoginPage objLogin;
	
	/**
	 * This case will login to https://tuyendung.cmc.com.vn</br>
	 * Verify login succeed	</br>
	 **/	
	@Test (priority = 0) 
	public void testLoginPage_TuyenDung() {
		System.out.println("Test case 1");
		// Create Login Page object
		objLogin = new LoginPage(driver);		
		//Login
		objLogin.loginToPage("sauriengj6@gmail.com", "123456aA@");		
		// Verify login succeed
		String loginTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginTitle.toUpperCase().contains("SAURIENGJ6"));		
	}
	
	/**
	 * This case will logout page Tuyen Dung</br>
	 * Verify logout succeed </br>	
	 **/
	@Test (priority = 1)
	public void testLogoutPage_TuyenDung() {
		
		if (objLogin==null) {
			// Create Login Page object
			objLogin = new LoginPage(driver);	
		}
		
		Boolean isLogin = objLogin.getStatusLogin();		
		if (!isLogin) {			
			//Login
			objLogin.loginToPage("sauriengj6@gmail.com", "123456aA@");	
		}	
		//Logout
		objLogin.logOut();				
		
		// Verify logout succeed
		isLogin = objLogin.getStatusLogin();		
		Assert.assertTrue(isLogin);
	}
}