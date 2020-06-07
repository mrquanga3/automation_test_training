package learn_fhome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCa {
	
	HocSinhGioi hsg1;
	@Before
	public void abc() {
		hsg1 = new HocSinhGioi();
		hsg1.x = 1;
	}

	@Test
	public void test1() {
		Assert.assertTrue(hsg1.tenHam(1, 2) == 2);
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(hsg1.tenHam(-1, 5) == 3);
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(hsg1.tenHam(3, -1) == 1);
	}
}
