package bai2;

public class TinhTong {
	float a;
	float b;
	int a1;
	int b1;

	// constructor với 2 đối số là 2 float
	TinhTong(float a, float b) {
		this.a = a;
		this.b = b;
	}

	// constructor với 2 đối số là 2 int
	TinhTong(int a1, int b1) {
		this.a1 = a1;
		this.b1 = b1;
	}

	// hàm tính tổng với 2 số int, 2 số float
	public float sumF() {
		return a + b;
	}

	public int sumI() {
		return a1 + b1;
	}

	// hàm tính giá trị trung bình với 2 số int, 2 số float
	public float averageF() {
		return (a + b) / 2;
	}

	public float averageI() {
		return (a1 + b1) / 2;
	}

	public static void main(String[] avgs) {
		TinhTong resultF = new TinhTong(3.5F, 6.5F);
		TinhTong resultI = new TinhTong(5, 3);
		System.out.println("Sum = " + resultF.sumF());
		System.out.println("Sum = " + resultI.sumI());
		System.out.println("Average = " + resultF.averageF());
		System.out.println("Average = " + resultI.averageI());
	}
}
