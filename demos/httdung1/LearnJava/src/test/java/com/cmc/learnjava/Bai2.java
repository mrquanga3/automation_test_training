package com.cmc.learnjava;

import static org.junit.Assert.*;

import org.junit.Test;

public class Bai2 {

	@Test
	public void checkTongInt(){
		TinhTong tinhTong2 = new TinhTong(5,4);
		int ketQua = tinhTong2.tinhTong2();		
		assertTrue(ketQua == 9);
	}
	
	@Test
	public void checkTongFloat(){
		TinhTong tinhTong1 = new TinhTong(2.5f, 8.5f);
		float ketQua = tinhTong1.tinhTong1();		
		assertTrue(ketQua == 11f);
	}
	
	@Test
	public void checkTrungBinhInt(){
		TinhTong tinhTong2 = new TinhTong(6,4);
		float ketQua = tinhTong2.tinhTb2();		
		assertTrue(ketQua == 5);
	}
	
	@Test
	public void checkTrungBinhFloat(){
		TinhTong tinhTong1 = new TinhTong(2.5f, 8.5f);
		float ketQua = tinhTong1.tinhTb1();		
		assertTrue(ketQua == 5.5f);
	}
	
}
