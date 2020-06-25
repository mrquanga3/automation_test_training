package JavaBasic;

import org.junit.Test;
import org.testng.Assert;

public class CheckSum {
	@Test
	public void Sum_float() {
		AppTest Tong = new AppTest(4.5f, 6.5f);
		float s = Tong.sum1();
		Assert.assertTrue(s == 11);
		System.out.println("Tổng là: " + s);
	}

	@Test
	public void Sum_int() {
		AppTest Tong = new AppTest(3, 4);
		float s1 = Tong.sum2();
		Assert.assertTrue(s1 == 7);
		System.out.println("Tổng là: " + s1);
	}

	@Test
	public void Mediem_float() {
		AppTest medium = new AppTest(4.5f, 6.5f);
		float s2 = medium.menium1();
		Assert.assertTrue(s2 == 5.5f);
		System.out.println("Trung bình là: " + s2);
	}

	@Test
	public void Medium_int() {
		AppTest medium = new AppTest(4, 6);
		float s3 = medium.menium2();
		Assert.assertTrue(s3 == 5);
		System.out.println("trung bình là: " + s3);
	}
}
