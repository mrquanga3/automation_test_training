package com.cmc.learnjava;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class Bai1 {
	public float sum1(float a, float b) {
		return a + b;
	}

	public float sum2(float a, float b) {
		return a + b + 1;
	}
	
	public void UniqueRandomNum(int min, int max, int count) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int randomNum = 0;
		Boolean existNum = false;
		for (int i = 1; i <= count; i++) {
			while (true) {
				randomNum = min + (int) (Math.random() * (max - min));
				existNum = false;
				for (Integer j : list) {
					if (j == randomNum) {
						existNum = true;
					}
				}
				if (!existNum) {
					list.add(randomNum);	
					break;
				}
			}
		}
		//Collections.shuffle(list);
		for (Integer i : list) {
			System.out.println("Random Number= " + i);		
		}
	}

	@Test
	public void checkResultSum3() {
		UniqueRandomNum(10, 20, 5);
	}

	//@Test
	public void checkResultSum1() {
		float sumActual = sum1(7.5f, 2.55f);
		assertTrue(sumActual == 10.05f);
	}

	//@Test
	public void checkResultSum2() {
		float sumActual = sum2(7.5f, 2.55f);
		assertTrue(sumActual == 10.05f);
	}

}
