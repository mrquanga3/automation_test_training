package recruitment.cmc.com.vn.test;

import static org.testng.Assert.assertNotEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import recruitment.cmc.com.pages.SelectionAdress;

public class TestSelectionAddress extends TestTemplate {
	@DataProvider
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "Chọn tất cả" }, { "Hà Nội" }, { "Thành phố Hồ Chí Minh" }, { "An Giang" },
				{ "Bà Rịa - Vũng Tàu" }, { "Bắc Cạn" }, { "Bắc Giang" }, { "Bạc Liêu" }, { "Bắc Ninh" }, { "Bến Tre" },
				{ "Bình Định" }, { "Bình Dương" }, { "Bình Phước" }, { "Bình Thuận" }, { "Cà Mau" }, { "Cần Thơ" },
				{ "Cao Bằng" }, { "Đà Nẵng" }, { "Đắk Lắk" }, { "Đắk Nông" }, { "Điện Biên" }, { "Đồng Nai" },
				{ "Đồng Tháp" }, { "Gia Lai" }, { "Hà Giang" }, { "Hà Nam" }, { "Hà Tĩnh" }, { "Hải Dương" },
				{ "Hải Phòng" }, { "Hậu Giang" }, { "Hòa Bình" }, { "Hưng Yên" }, { "Khánh Hòa" }, { "Kiên Giang" },
				{ "Kon Tum" }, { "Lai Châu" }, { "Lầm Đồng" }, { "Lạng Sơn" }, { "Lào Cai" }, { "Long An" },
				{ "Nam Định" }, { "Nghệ An" }, { "Ninh Bình" }, { "Ninh Thuận" }, { "Phú Thọ" }, { "Phú yên" },
				{ "Quảng Bình" }, { "Quảng Nam" }, { "Quảng Ngãi" }, { "Quảng Ninh" }, { "Quảng Trị" }, { "Sóc Trăng" },
				{ "Sơn La" }, { "Tây Ninh" }, { "Thái Bình" }, { "Thái Nguyên" }, { "Thanh Hóa" },
				{ "Thừa Thiên - Huế" }, { "Tiền Giang" }, { "Trà Vinh" }, { "Tuyên Quang" }, { "Vĩnh Long" },
				{ "Vinh Phúc" }, { "Yên Bái" }, { "Nước ngoài" } };
	}

//	@Test(dataProvider = "dataProviderMethod")
//	public void testAdress(String address) {
//
//	}
	@Test
	public void clickAll() {
		SelectionAdress selectionAdress = new SelectionAdress(driver);
		selectionAdress.allAdress();
	}
	@Test
	public void Click1Nganhnghe() {
		SelectionAdress selectionAdress = new SelectionAdress(driver);
		selectionAdress.ClickOneNN();
	}
}
