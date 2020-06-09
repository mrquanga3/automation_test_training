package baitapjava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Bai2 {
	public float sum(float a, float b) {
		return a + b;
	}
	@Test
	public void testSum() {
		Bai2 testSum = new Bai2();
		float result = testSum.sum(2.3f, 3.5f);
		assertTrue(result == 5.8f);
	}
}