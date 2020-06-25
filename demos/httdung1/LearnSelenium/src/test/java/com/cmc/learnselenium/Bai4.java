package com.cmc.learnselenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bai4 {
	static WebDriver driver;
	@Before
	public void startTest() {
		//System.setProperty("webdriver.chrome.driver", "D:\\0TestAutomation\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();		
	}
	@After
	public void EndTest() {
		driver.quit();
	}
	
	public void waitForElementVisible(int seconds, By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	
	/**
	 * TestCase No1: Confirm delete a customer
	 * 
	 * Step1: Enter any Customer ID 
	 * Step2: Click submit button  
	 * Step3: Click OK button to confirm delete
	 * Step4: Click OK button to finish
	 * 
	 * Expected: 
	 * After step2-Display popup with message "Do you really want to delete this Customer?"
	 * After step3-Display popup with message "Customer Successfully Delete!"
	 * After step4-Value of Customer ID textbox is empty
	 */	
	@Test
	public void testCaseNo001() {
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		
		//Step1: Enter any Customer ID
		waitForElementVisible(15,By.name("cusid"));
		WebElement txtCustomerID = driver.findElement(By.name("cusid"));
		txtCustomerID.sendKeys("12345");
		
		//Step2: Click submit button
		WebElement btnSumit= driver.findElement(By.name("submit"));
		btnSumit.click();
		
		//Check message is displayed on popup after step2
		Alert alert = driver.switchTo().alert();		
		String txtActual = alert.getText();
		System.out.println(txtActual);
		assertEquals("Do you really want to delete this Customer?", txtActual);
		
		//Step3: Click OK button to confirm delete
		alert.accept();
		
		
		//Check message is displayed on popup after step3
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		alert = driver.switchTo().alert();
		txtActual = alert.getText();
		System.out.println(txtActual);
		assertEquals("Customer Successfully Delete!", txtActual);
		
		//Step4: Click OK button to finish
		alert.accept();
		
		//Check value of Customer ID textbox is empty
		waitForElementVisible(10, By.name("cusid"));
		txtCustomerID = driver.findElement(By.name("cusid"));
		txtActual = txtCustomerID.getText();
		System.out.println(txtActual);
		assertEquals("", txtActual);
	}
	
	/**
	 * TestCase No2: Open new child window (new tab)
	 * 
	 * Step1: Launch the site 
	 * Step2: Click on link "Click Here"  
	 * Step3: Switch to the new child window
	 * Step3.1: Check display texbox Email ID
	 * Step3.2: Close the new child window
	 * Step4: Switch to the parent window
	 * Step5: Check switch to main widow
	 * 
	 * Expected: 
	 * After step3-Display textbox "Email ID" on site
	 * After step5-Display link "Click Here" on site	
	 */	
	@Test
	public void testCaseNo002() {
		
		//Step1: Launch the site
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		
		//Step2: Click on link "Click Here"
		WebElement linkClick = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		linkClick.click();
		
		//Step3: Switch to the new child window
		String mainWindow=driver.getWindowHandle();
		Set<String> windowList = driver.getWindowHandles();
		Iterator<String> iterator= windowList.iterator();
		
		while(iterator.hasNext())			
        {
			String childWindow=iterator.next(); 
			 if(!mainWindow.equalsIgnoreCase(childWindow))			
	            { 
					driver.switchTo().window(childWindow);					
					//Step 3.1: Check display texbox Email ID
					waitForElementVisible(30, By.name("emailid"));
					WebElement txtEmailId = driver.findElement(By.name("emailid"));
					assertTrue(txtEmailId.isDisplayed());
					
					//Step3.2: Closing the Child Window.
			        driver.close();
	            }
        }
		
		//Step4: Switch to the parent window
		driver.switchTo().window(mainWindow);
				
		//Step5: Check switch to main widow (display link 'Click Here')
		assertTrue(linkClick.isDisplayed());		
	}
}
