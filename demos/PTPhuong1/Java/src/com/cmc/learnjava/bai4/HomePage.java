package com.cmc.learnjava.bai4;

import org.junit.Test;

public class HomePage extends Login{
	@Test
	public void chekc1_login() {
		this.login();
		this.close();
		System.out.println("login thanh cong");
	}
	@Test
	public void check2_logout() {
		this.logout();
		this.close();
		System.out.println("logout thanh cong");
	}
}
