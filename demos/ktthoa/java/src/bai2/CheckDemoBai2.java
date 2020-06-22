package bai2;

import org.junit.Assert;
import org.junit.Test;

public class CheckDemoBai2 {
	@Test
	public void kiemTraTongFloat() {
		DemoBai2 d1 = new DemoBai2(3.5f,4.7f);
		float ketqua = d1.Tong();
		Assert.assertTrue(ketqua == 8.2f);
	}
	@Test
	public void kiemTratongInt() {
		DemoBai2 d1 = new DemoBai2(3,4);
		float ketqua = d1.Tong1();
		Assert.assertTrue(ketqua == 7);
	}
	@Test
	public void kiemTraTrungBinhFloat() {
		DemoBai2 d1 = new DemoBai2(3.5f,4.7f);
		float ketqua = d1.TrungBinh();
		Assert.assertTrue(ketqua == 4.1f);
	}@Test
	public void kiemTraTrungBinhInt() {
		DemoBai2 d1 = new DemoBai2(3,4);
		float ketqua = d1.TrungBinh1();
		Assert.assertTrue(ketqua == 3.5f);
	}

}
