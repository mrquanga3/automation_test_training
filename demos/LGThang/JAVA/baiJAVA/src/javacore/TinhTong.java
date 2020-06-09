package javacore;

public class TinhTong {

	public float sum(float a, float b) {
		return a + b;
	}

	public static void main(String[] args) {

		TinhTong testSum = new TinhTong();
		float result = testSum.sum(2.5f, 3.5f);
		if (result == 6f) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
	}

}
