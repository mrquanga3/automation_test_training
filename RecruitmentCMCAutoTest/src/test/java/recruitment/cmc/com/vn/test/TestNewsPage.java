package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.NewsPage;
import recruitment.cmc.com.settings.NewsInfo;

public class TestNewsPage extends TestTemplate {
	static NewsPage newsPage;

	/*
	 * @Test public void testLikeNotLogged() { newsPage = new NewsPage(driver);
	 * assertEquals("Bạn chưa đăng nhập", newsPage.pressLikeButton()); }
	 * 
	 * @Test public void testLikeLogged() { newsPage = new NewsPage(driver);
	 * assertEquals("Đã thích", newsPage.pressLikeButtonLogged()); }
	 * 
	 * @Test public void testUnLikeLogged() { newsPage = new NewsPage(driver);
	 * assertEquals("Yêu thích", newsPage.pressUnLikeButtonLogged()); }
	 */
	// Begin of dunghtt1
	// Save case test data to object array
	@DataProvider(name = "newslistdata")
	public NewsInfo[] newsListDataprovider() throws Exception {
		newsPage = new NewsPage(driver);
		return newsPage.getListNewsFromFile();
	}

	// Verify display list of the News
	@Test(dataProvider = "newslistdata")
	public void verifyDisplayListOfNews(NewsInfo sNews) throws Exception {
		newsPage = new NewsPage(driver);
		String resultTest = newsPage.getStatusOfNewsList(sNews.subTitle, sNews.urlBanner, sNews.subContent,
				sNews.detailContent, sNews.postDate);
		assertEquals(resultTest, "Display correct the news");
	}

	// Verify display the detail of the News
	@Test
	public void verifyDisplayDetailOfNews() throws Exception {
		newsPage = new NewsPage(driver);
		String resultTest = newsPage.getStatusDetailOfNews();
		assertEquals(resultTest, "Display correct the news");
	}
	// End of dunghtt1
}
