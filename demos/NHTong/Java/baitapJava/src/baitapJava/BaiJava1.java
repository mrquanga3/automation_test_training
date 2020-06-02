package baitapJava;


public class BaiJava1 {
	
public float sum(float a, float b) {
	return a+b;
}	
public static void main(String[] args) {
	
	BaiJava1 TestSum = new BaiJava1();
	float result = TestSum.sum(2.5f, 3.5f);
	if(result == 6f) {
		System.out.println("Test Pass!");
	}else
		System.out.println("Test Fail!");

}

}
