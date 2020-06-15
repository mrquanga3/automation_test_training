package com.cmc.learnjava;

import static org.junit.Assert.*;

import org.junit.Test;

public class Bai1 {
	public float sum1(float a, float b) {
		return a + b;
	}

	public float sum2(float a, float b) {
		return a + b + 1;
	}

	@Test
	public void checkResultSum1() {
		float sumActual = sum1(7.5f, 2.55f);
		assertTrue(sumActual == 10.05f);
	}

	@Test
	public void checkResultSum2() {
		float sumActual = sum2(7.5f, 2.55f);
		assertTrue(sumActual == 10.05f);
	}
}

