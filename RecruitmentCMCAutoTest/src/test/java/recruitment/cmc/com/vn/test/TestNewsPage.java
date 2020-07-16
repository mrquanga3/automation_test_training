package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import recruitment.cmc.com.pages.NewsPage;

public class TestNewsPage extends TestTemplate {
	@Test (priority = 1)
	public void testLikeNotLogged() {
		NewsPage newsPage = new NewsPage(driver);
		assertEquals("Bạn chưa đăng nhập", newsPage.pressLikeButton());
	}

	@Test (priority = 2)
	public void testLikeLogged() {
		NewsPage newsPage = new NewsPage(driver);
		assertEquals("Đã thích", newsPage.pressLikeButtonLogged());
	}
	
	@Test (priority = 3)
	public void testUnLikeLogged() {
		NewsPage newsPage = new NewsPage(driver);
		assertEquals("Yêu thích", newsPage.pressUnLikeButtonLogged());
	}
}