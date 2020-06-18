package bai2;

public class DemoBai2 {
	float a;
	float b;
	int a1;
	int b1;

	DemoBai2(float a, float b) {
		this.a = a;
		this.b = b;
	}

	DemoBai2(int a1, int b1) {
		this.a1 = a1;
		this.b1 = b1;
	}

	float Tong() {
		return a + b;
	}

	int Tong1() {
		return a1 + b1;
	}

	float TrungBinh() {
		return (a + b) / 2;
	}

	float TrungBinh1() {
		return (float) (a1 + b1) / 2;
	}

}
