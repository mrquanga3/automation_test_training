package demo.test;

import org.junit.Assert;
import org.junit.Test;

public class TestTinhTong {

	@Test
	public void Test1() {
		TinhTong s1 = new TinhTong(3.3f, 5.5f);
		Float s2 = s1.sum();
		String s = s2.toString();
		Assert.assertEquals(s, "8.8");

	}

	@Test
	public void Test2() {
		TinhTong s1 = new TinhTong(2.5f, 3.5f);
		Float s2 = s1.sum();
		String s = s2.toString();
		Assert.assertEquals(s, "6.0");

	}

	@Test
	public void Test3() {
		TinhTong s1 = new TinhTong(6, 9);
		Double s2 = s1.avg();
		String s = s2.toString();
		Assert.assertEquals(s, "7.5");

	}

	@Test
	public void Test4() {
		TinhTong s1 = new TinhTong(2, 3);
		Double s2 = s1.avg();
		String s = s2.toString();
		Assert.assertEquals(s, "2.5");

	}
}
