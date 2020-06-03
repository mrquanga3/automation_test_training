package learn_fhome;

public class HocSinhGioi {
	int x = 0;
	String y;
	float c;
	double e;
	int tenHam (int d, int t) {
		System.out.println(t);
		System.out.println(d);
		return t+d-x;
	}
	
	public static void main(String[] args) {
		HocSinhGioi dung = new HocSinhGioi();
		
		int result = dung.tenHam(5, 6);
		System.out.println(result);
		result = dung.tenHam(8, 9);
		System.out.println(result);
		
		HocSinhGioi nem = new HocSinhGioi();
		nem.x = 2;
		
		result = dung.tenHam(5, 6);
		System.out.println(result);
		result = dung.tenHam(8, 9);
		System.out.println(result);
	}

}
