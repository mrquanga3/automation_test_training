package com.cmc.learnjava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Bai2 {

	@Test
	public void checkSumInt(){
		TinhTong tinhTong2 = new TinhTong(5,4);
		int ketQua = tinhTong2.tinhTong2();		
		assertTrue(ketQua == 9);
	}
	
	@Test
	public void checkSumFloat(){
		TinhTong tinhTong1 = new TinhTong(2.5f, 8.5f);
		float ketQua = tinhTong1.tinhTong1();		
		assertTrue(ketQua == 11f);
	}
	
	@Test
	public void checkAverageInt(){
		TinhTong tinhTong2 = new TinhTong(6,4);
		float ketQua = tinhTong2.tinhTrungBinhCong2();		
		assertTrue(ketQua == 5);
	}
	
	@Test
	public void checkAverageFloat(){
		TinhTong tinhTong1 = new TinhTong(2.5f, 8.5f);
		float ketQua = tinhTong1.tinhTrungBinhCong1();		
		assertTrue(ketQua == 5.5f);
	}
	
}
