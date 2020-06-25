package com.cmc;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuRu9HandlePopUp {
	static WebDriver browser;

	@Test
	public void HandleWindown() {
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		browser = new ChromeDriver();
		browser.manage().window().maximize();
		//open url
		browser.navigate().to(" http://demo.guru99.com/popup.php");
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		//get current windown
		String mainWindown = browser.getWindowHandle();
		
		//handle new opened windown
		Set<String> mainWindowns = browser.getWindowHandles();
		Iterator<String> iter = mainWindowns.iterator();		
		while(iter.hasNext())			
        {		
            String ChildWindow=iter.next();		
            		
            if(!mainWindown.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
            	browser.switchTo().window(ChildWindow);	                                                                                                           
            	browser.findElement(By.name("emailid"))
                    .sendKeys("gaurav.3n@gmail.com");                			
                    
            	browser.findElement(By.name("btnLogin")).click();			
                                 
			// Closing the Child Window.
            	browser.close();		
            }		
        }		
        // Switching to Parent window i.e Main Window.
		browser.switchTo().window(mainWindown);
	}

}
