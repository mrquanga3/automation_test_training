package learn_fhome;

import java.util.ArrayList;

public class HocSinhGioi {
	int x = 0;
	String y;
	float c;
	double e;
	float diem;
	String ten;

	int tenHam(int d, int t) {
		System.out.println(t);
		System.out.println(d);
		return t + d - x;
	}

	public static void main(String[] args) {
//		HocSinhGioi dung = new HocSinhGioi();

//		int result = dung.tenHam(5, 6);
//		System.out.println(result);
//		result = dung.tenHam(8, 9);
//		System.out.println(result);
//
//		HocSinhGioi nem = dung;
//		nem.x = 2;
//
//		result = dung.tenHam(5, 6);
//		System.out.println(result);
//		result = dung.tenHam(8, 9);
//		System.out.println(result);

//		if (result == 9) {
//			System.out.println(9);
//		} else if (result == 8) {
//			System.out.println(8);
//		} else {
//			System.out.println(0);
//		}
//		int i = 7;
//		for (;i < dung.tenHam(5, 6);) {
//			System.out.println(i);
//			i = i + 1;
//			if (i == 5) {
//				break;
//			}
//		}
		int[] mang = new int[3];
		mang[0] = 1;
		mang[1] = 2;
		mang[2] = 5;

		ArrayList<HocSinhGioi> danhsachhocsinhgioi = new ArrayList<HocSinhGioi>();
		HocSinhGioi dung = new HocSinhGioi();
		dung.ten = "Me thang Nem";
		dung.diem = 1;
		HocSinhGioi nem = new HocSinhGioi();
		nem.ten = "Anh Nem";
		nem.diem = 3;
		HocSinhGioi quang = new HocSinhGioi();
		quang.ten = "Bo Nem";
		quang.diem = 10;
		danhsachhocsinhgioi.add(dung);
		danhsachhocsinhgioi.add(nem);
		danhsachhocsinhgioi.add(quang);

		System.out.println(danhsachhocsinhgioi.get(1).ten);
		float tongdiem = 0;
//		for (int i = 0; i < danhsachhocsinhgioi.size(); i++) {
//			tongdiem = tongdiem + danhsachhocsinhgioi.get(i).diem;
//		}
		for (HocSinhGioi hsg: danhsachhocsinhgioi) {
			tongdiem = tongdiem + hsg.diem;
		}
		System.out.println(tongdiem/danhsachhocsinhgioi.size());
	}

}
