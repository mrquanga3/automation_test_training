package demo.test;

public class TinhTong {
	float a;
	float b;
	int a1;
	int b2;

	public TinhTong() {

	}

	TinhTong(float i, float n) {
		a = i;
		b = n;
	}

	TinhTong(int i1, int n2) {
		a1 = i1;
		b2 = n2;
	}

	public float sum() {
		return a + b;

	}

	public double avg() {
		return (double) (a1 + b2) / 2;
	}

}
