package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.NewsPage;
import recruitment.cmc.com.settings.NewsInfo;

public class TestNewsPage extends TestTemplate {
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
	}	
	
	// Begin of dunghtt1	
	// Save case test data to object array for method verifyDisplayListOfNews()
	@DataProvider(name = "newslistdata")
	public NewsInfo[] newsListDataprovider() throws Exception {
		NewsPage newsP = new NewsPage(driver);				
		return newsP.getListNewsFromFile();
	}
	
	//Verify display list of the News use method newsListDataprovider()
	@Test(dataProvider = "newslistdata")
	public void verifyDisplayListOfNews(NewsInfo sNews) throws Exception{				
		  NewsPage newsP = new NewsPage(driver); 
		  String resultTest = newsP.getStatusOfNewsList(sNews.subTitle, sNews.urlBanner, sNews.subContent, sNews.detailContent, sNews.postDate); 
		  assertEquals(resultTest, "Display correct the news");		 
	}
	
	//Verify display list of the News use method getListNews()
	@Test(dataProvider = "newslistdataA")
	public void verifyDisplayListOfNewsA(String subTitle, String urlBanner, String subContent, String detailContent, String postDate) throws Exception {
		NewsPage newsP = new NewsPage(driver);
		String resultTest = newsP.getStatusOfNewsList(subTitle, urlBanner, subContent, detailContent, postDate);
		assertEquals(resultTest, "Display correct the news");
	}
	
	//Verify display the detail of the News
	@Test
	public void verifyDisplayDetailOfNews() throws Exception{				
		  NewsPage newsP = new NewsPage(driver);		 
		  String resultTest = newsP.getStatusDetailOfNews(); 
		  assertEquals(resultTest, "Display correct the news");		 
	}
	// End of dunghtt1
}
