package bai1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TinhTong {
	static float sum(float a, float b) {
		return  a+b;
		}
	@Test
	    public void kiemTraTong () {
		float result = TinhTong.sum(3.5f, 4.8f);
		assertTrue(result == 8.3f);
	}

}
