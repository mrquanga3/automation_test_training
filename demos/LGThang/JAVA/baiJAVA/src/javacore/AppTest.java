package javacore;

public class AppTest {
	float a;
	float b;
	int a1;
	int b1;
	public AppTest() {

	}

	public AppTest(float a, float b) {
		this.a = a;
		this.b = b;
	}

	public AppTest(int a1, int b1) {
		this.a1 = a1;
		this.b1 = b1;
	}

	public float sum1() {
		return a + b;
	}

	public int sum2() {
		return a1 + b1;
	}

	public float menium1() {
		return (a + b) / 2;
	}

	public int menium2() {
		return (a1 + b1) / 2;
	}
}
