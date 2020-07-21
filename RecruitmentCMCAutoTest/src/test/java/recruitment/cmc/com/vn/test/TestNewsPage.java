package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import recruitment.cmc.com.pages.NewsPage;

public class TestNewsPage extends TestTemplate {
	
	@Test
	public void verifyDisplayListOfNews() throws Exception{				
		  NewsPage newsP = new NewsPage(driver);		 
		  boolean resultTest = newsP.getStatusOfNewsList(); 
		  assertEquals(resultTest, true);		 
	}
	
	@Test
	public void verifyDisplayDetailOfNews() throws Exception{				
		  NewsPage newsP = new NewsPage(driver);		 
		  boolean resultTest = newsP.getStatusDetailOfNews(); 
		  assertEquals(resultTest, true);		 
	}
}
