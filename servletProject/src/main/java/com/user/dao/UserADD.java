package com.user.dao;

public class UserADD {
	private static UserADD uv = new UserADD();

	public static UserADD getInstance() {
		return uv;
	}

	private UserDao ud;

	public UserDao getUserDao() {
		UserDao ud = new UserDaoImpl();
		return ud;
	}
}
