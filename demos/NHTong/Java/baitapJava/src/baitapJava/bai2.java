package baitapJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class bai2 {
	public float sum(float a, float b) {
		return a + b;
	}
	@Test
	public void testSum() {
		bai2 testSum = new bai2();
		float result = testSum.sum(2.5f, 3.5f);
		assertTrue(result == 6f);
	}
}