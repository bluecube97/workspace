package com.mvc.user.dao;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public interface userDAO {

	void insertReadList(HttpSession session, String brdNo);

	HashMap<String, Object> getLoginCheck(String id, String password);

}
