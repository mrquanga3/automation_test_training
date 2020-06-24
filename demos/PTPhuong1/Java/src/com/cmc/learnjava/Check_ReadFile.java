package com.cmc.learnjava;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Check_ReadFile {
	File_user readfile = new File_user();
	List<String> input = readfile.Readfile();
	@Test
	public void Check_user() {
		Assert.assertEquals(input.get(0), "sauriengj6@gmail.com");
	}

	@Test
	public void Check_pass() {
		Assert.assertEquals(input.get(1), "123456aA@");
	}
}
