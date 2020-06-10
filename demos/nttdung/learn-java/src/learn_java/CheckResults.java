package learn_java;

import org.junit.Assert;
import org.junit.Test;

public class CheckResults {

	@Test
	public void test1() {
		Sum results = new Sum ();
		Assert.assertTrue(results.tinhTong(6, 9) == 15);
	}

	@Test
	public void test2() {
		Sum results = new Sum ();
		Assert.assertEquals(15, results.tinhTong(6, 9), 0.1);
	}
}
