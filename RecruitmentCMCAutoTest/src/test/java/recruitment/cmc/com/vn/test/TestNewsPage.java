package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import recruitment.cmc.com.pages.NewsPage;

public class TestNewsPage extends TestTemplate {
<<<<<<< HEAD
	@Test 
	public void testLikeNotLogged() {
		NewsPage newsPage = new NewsPage(driver);
		assertEquals("Bạn chưa đăng nhập", newsPage.pressLikeButton());
	}

	@Test 
	public void testLikeLogged() {
		NewsPage newsPage = new NewsPage(driver);
		assertEquals("Đã thích", newsPage.pressLikeButtonLogged());
	}
	
	@Test 
	public void testUnLikeLogged() {
		NewsPage newsPage = new NewsPage(driver);
		assertEquals("Yêu thích", newsPage.pressUnLikeButtonLogged());
=======
	
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
>>>>>>> ccb0c075d59ddda2efdf19b86d661da2046a133e
	}
}
