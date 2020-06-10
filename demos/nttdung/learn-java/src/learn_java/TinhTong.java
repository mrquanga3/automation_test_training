package learn_java;

public class TinhTong {
	float a;
	float b;
	int c;
	int d;

	TinhTong(float a, float b) {
		this.a = a;
		this.b = b;
	}

	TinhTong(int c, int d) {
		this.c = c;
		this.d = d;
	}

	float tongFloat() {
		return a + b;
	}

	int tongInt() {
		return c + d;
	}

	float tbFloat() {
		return (a + b) / 2;
	}

	float tbInt() {
		return (((float) c) + d) / 2;
	}

	public static void main(String[] args) {
		TinhTong kqua1 = new TinhTong(9f, 6f);
		TinhTong kqua2 = new TinhTong(11, 34);
		//in kqua tt
		System.out.println(kqua1.tongFloat());
		System.out.println(kqua2.tongInt());
		//in kqua ttb
		System.out.println(kqua1.tbFloat());
		System.out.println(kqua2.tbInt());

	}

}
