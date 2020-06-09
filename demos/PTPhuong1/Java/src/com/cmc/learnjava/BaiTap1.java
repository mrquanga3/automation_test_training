package com.cmc.learnjava;

import org.junit.Assert;
import org.junit.Test;

public class BaiTap1 {

	float sum (float a, float b) {
		return a +b;
	}

	@Test
	public void compare() {
		BaiTap1 sum1 = new BaiTap1 ();
		float result = sum1.sum(5, 6);
		Assert.assertTrue(result == 11);
	}
}
	

