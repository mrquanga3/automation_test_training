package com.cmc.learnjava;

import org.junit.Assert;
import org.junit.Test;

public class baitap1 {

	float Sum (float a, float b) {
		return a +b;
	}

	@Test
	public void so_sanh_kq() {
		baitap1 tinhTong = new baitap1 ();
		float ketQua = tinhTong.Sum(5, 6);
//		Assert.assertEquals(11, ketQua, 0.1);
		Assert.assertTrue(ketQua == 11);
		if (ketQua == 11) {
			System.out.print(ketQua);
		} else{};
	}
}


	

