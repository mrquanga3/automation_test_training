package learn_java;

import org.junit.Assert;
import org.junit.Test;

public class TinhTongTest {
	TinhTong kqua1 = new TinhTong(9f, 6f);
	TinhTong kqua2 = new TinhTong(11, 34);
	
	@Test
	public void kTraTong() {
		Assert.assertTrue(kqua1.tongFloat() == 15f);
		System.out.println(kqua1.tongFloat());
	}
	
	@Test
	public void kTraTong1() {
		Assert.assertTrue(kqua2.tongInt() == 45);
		System.out.println(kqua2.tongInt());
	}

	@Test
	public void kTraTB() {
		Assert.assertTrue(kqua1.tbFloat() == 7.5);
		System.out.println(kqua1.tbFloat());

	}
	
	@Test
	public void kTraTB1() {
		Assert.assertTrue(kqua2.tbInt() == 22.5);
		System.out.println(kqua2.tbInt());
	}
}
