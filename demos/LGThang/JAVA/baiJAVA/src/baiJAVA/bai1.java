package baiJAVA;

public class bai1 {

	public float Sum(float a, float b) {
		return a + b;
	}

	public static void main(String[] args) {
	
		bai1 TestSum = new bai1();
		float result = TestSum.Sum(2.5f, 3.5f);
		if(result == 6f) {
			System.out.println("Test Pass!");
		}else
			System.out.println("Test Fail!");
	
	}

}
