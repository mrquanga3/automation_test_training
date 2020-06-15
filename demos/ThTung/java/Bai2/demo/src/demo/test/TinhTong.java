package demo.test;

import org.junit.Assert;
import org.junit.Test;

public class TinhTong {
	float a;
	float b;
	int a1;
	int b2;

	public TinhTong(float i, float n) {
		a = i;
		b = n;
	}

	private TinhTong(int i1, int n2) {
		a1 = i1;
		b2 = n2;
	}

	public float sum() {
		return a + b;

	}

	public double avg() {
		return (double) (a1 + b2) / 2;
	}

	@Test
	public void Test1() {
		TinhTong s1 = new TinhTong(2.3f, 5.5f);
		Assert.assertSame(s1.sum(), 7.8);

	}

	@Test
	public void Test2() {
		TinhTong s1 = new TinhTong(3.5f, 4.5f);
		Assert.assertSame(s1.sum(), 8);

	}

	@Test
	public void Test3() {
		TinhTong s1 = new TinhTong(2, 3);
		Assert.assertSame(s1.avg(), 2.5);

	}

	@Test
	public void Test4() {
		TinhTong s1 = new TinhTong(4, 8);
		Assert.assertSame(s1.avg(), 6);

	}

}
