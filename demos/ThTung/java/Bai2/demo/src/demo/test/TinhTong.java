package demo.test;

public class TinhTong {
	float a;
	float b;
	int a1;
	int b2;

	public TinhTong() {
<<<<<<< HEAD

=======
>>>>>>> 76512316306f99c7a037722c99d8a032403be8b5
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
