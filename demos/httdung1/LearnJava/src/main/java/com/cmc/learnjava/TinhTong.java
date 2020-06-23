package com.cmc.learnjava;

public class TinhTong {
	float a;
	float b;
	int a1;
	int b1;

	
	public TinhTong(float a, float b) {		
		this.a = a;
		this.b = b;
	}

	public TinhTong(int a1, int b1) {		
		this.a1 = a1;
		this.b1 = b1;
	}

	public float tinhTong1() {
		return a + b;
	}

	public int tinhTong2() {
		return a1 + b1;
	}

	public float tinhTrungBinhCong1() {
		return (a + b) / 2;
	}

	public float tinhTrungBinhCong2() {
		return ((float)a1 + b1) / 2;
	}
}
