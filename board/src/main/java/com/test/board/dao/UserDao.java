package com.test.board.dao;

import java.util.Map;

public interface UserDao {
	public Map<String, String> loginCheck(Map<String, String> userInfo);
}
