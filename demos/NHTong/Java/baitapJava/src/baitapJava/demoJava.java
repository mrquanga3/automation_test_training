package baitapJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class demoJava {
	public static String encrypt(String username, String password) {
		return username + password;
	}

	@Test
	public void test1() {
		assertTrue("ab".equals(demoJava.encrypt("a", "b")));
	}

	@Test
	public void test2() {
		assertTrue("ac".equals(demoJava.encrypt("a", "c")));
	}
}