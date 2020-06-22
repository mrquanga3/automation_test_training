package bai2;

import org.junit.Assert;
import org.junit.Test;

public class CheckSum {
	TinhTong resultF = new TinhTong(3.5F, 6.5F);
	TinhTong resultI = new TinhTong(5, 4);

	@Test
	public void checkSumF() {
		Assert.assertTrue(resultF.sumF() == 10F);
	}

	@Test
	public void checkSumI() {
		Assert.assertTrue(resultI.sumI() == 9);
	}

	@Test
	public void checkAverageF() {
		Assert.assertTrue(resultF.averageF() == 5F);
	}

	@Test
	public void checkAverageI() {
		Assert.assertTrue(resultI.averageI() == 4.5);
	}
}
