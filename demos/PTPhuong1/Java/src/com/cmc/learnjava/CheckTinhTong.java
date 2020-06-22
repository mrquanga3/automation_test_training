package com.cmc.learnjava;

import org.junit.Assert;
import org.junit.Test;

public class CheckTinhTong {
    @Test
    public void KT_Tong_Float() {
	TinhTong s1 = new TinhTong(5.5f, 4.5f);
	float w = s1.Tong1();
	Assert.assertTrue(w == 10);
	System.out.println("Tong 2 so float = " + w);
    }

    @Test
    public void KT_Tong_Int() {
	TinhTong s2 = new TinhTong(4, 5);
	int q = s2.Tong2();
	Assert.assertTrue(q == 9);
	System.out.println("Tong 2 so int = " + q);
    }

    @Test
    public void KT_TB_Float() {
	TinhTong s1 = new TinhTong(5.5f, 4.5f);
	float tbF = s1.TrungBinh1();
	Assert.assertTrue(tbF == 5);
	System.out.println("Trung binh cong cua 2 so float = " + tbF);
    }

    @Test
    public void KT_TB_Int() {
	TinhTong s2 = new TinhTong(4, 5);
	float tbI = s2.TrungBinh2();
	Assert.assertTrue(tbI == 4.5);
	System.out.println("Trung binh cong cua 2 so int = " + tbI);
    }
}
