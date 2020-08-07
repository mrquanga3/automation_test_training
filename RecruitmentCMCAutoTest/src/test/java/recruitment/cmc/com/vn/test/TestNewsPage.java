package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import recruitment.cmc.com.pages.NewsPage;
import recruitment.cmc.com.settings.NewsInfo;

public class TestNewsPage extends TestTemplate {
	static NewsPage newsPage;

	@Test
	public void testLikeNotLogged(Method method) {
		newsPage = new NewsPage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, new Object[] {})));
		assertEquals(newsPage.pressLikeButton(), "Bạn chưa đăng nhập");
	}

	@Test
	public void testLikeLogged(Method method) {
		newsPage = new NewsPage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, new Object[] {})));
		assertEquals(newsPage.pressLikeButtonLogged(), "Đã thích");
	}

	@Test
	public void testUnLikeLogged(Method method) {
		newsPage = new NewsPage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, new Object[] {})));
		assertEquals(newsPage.pressUnLikeButtonLogged(), "Yêu thích");
	}

	// Begin of dunghtt1 // Save case test data to object array

	@DataProvider(name = "newslistdata")
	public NewsInfo[] newsListDataprovider(Method method) throws Exception {
		newsPage = new NewsPage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, new Object[] {})));
		return newsPage.getListNewsFromFile();
	}

	// Verify display list of the News

	@Test(dataProvider = "newslistdata")
	public void verifyDisplayListOfNews(NewsInfo sNews, Method method) throws Exception {
		newsPage = new NewsPage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, new Object[] {})));
		String resultTest = newsPage.getStatusOfNewsList(sNews.subTitle, sNews.urlBanner, sNews.subContent,
				sNews.detailContent, sNews.postDate);
		assertEquals(resultTest, "Display correct the news");
	}

	// Verify display the detail of the News

	@Test
	public void verifyDisplayDetailOfNews(Method method) throws Exception {
		newsPage = new NewsPage(drivers.get(TestTemplate.buildKeyForMappingDriverToTestMethod(method, new Object[] {})));
		String resultTest = newsPage.getStatusDetailOfNews();
		assertEquals(resultTest, "Display correct the news");
	}

	// End of dunghtt1
}
