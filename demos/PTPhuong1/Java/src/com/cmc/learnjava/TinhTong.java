package com.cmc.learnjava;

//import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TinhTong {
    float a;
    float b;
    int a1;
    int b2;

    public TinhTong() {

    }

    TinhTong(float a, float b) {
	this.a = a;
	this.b = b;
    }

    TinhTong(int a1, int b2) {
	this.a1 = a1;
	this.b2 = b2;
    }

    float Tong1() {
	return a + b;
    }

    int Tong2() {
	return a1 + b2;
    }

    float TrungBinh1() {
	return (a + b) / 2;
    }

    float TrungBinh2() {
	return ((float) a1 + b2) / 2;
    }
}
