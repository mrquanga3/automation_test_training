package com.cmc.java;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class JavaTest {
	public float sum1(float a, float b) {
		return a + b;
	}

	public float sum2(float a, float b) {
		return a + b + 1;
	}

	@Test
	public void checkResultSum1() {
		assertTrue(sum1(7.5f, 2.55f) == 10.05f);
	}

	@Test
	public void checkResultSum2() {
		assertTrue(sum2(7.5f, 2.55f) == 10.05f);
	}

}
