package com.cmc.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	float sum(float a, float b) {
		return a + b;
	}
	
//	public static void main(String[] args) {
//		Main ketQua = new Main();
//		float f = ketQua.sum(5, 7);
//		System.out.print(f);
//	}
	
	@Test
	public void test2() {
		Main m = new Main();
		Assert.assertTrue(m.sum(5, 7) == 12);
	}
}
