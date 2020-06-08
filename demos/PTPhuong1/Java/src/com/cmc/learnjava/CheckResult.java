package com.cmc.learnjava;

import org.junit.Assert;
import org.junit.Test;

public class CheckResult {
	@Test
	public void Test1() {
		baitap1 ketQua = new baitap1();
		Assert.assertTrue(ketQua.Sum(6, 7) == 12);
	}
	@Test
	public void Test2() {
	   
		baitap1 ketQua = new baitap1();
		Assert.assertTrue(ketQua.Sum(6, 7) == 13);
	}

}
