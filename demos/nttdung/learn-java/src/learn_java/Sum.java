package learn_java;

import org.junit.Assert;
import org.junit.Test;

public class Sum {
	float tinhTong (float a, float b) {
		return a +b ;
	}
	
	public static void main(String[] args) {
		Sum cong = new Sum();
		float ketQua = cong.tinhTong(5, 6);
		System.out.print(ketQua);

	}


}

