package com.user.dao;

import java.util.List;

import com.user.vo.UserVO;

public interface UserDao {
	UserVO getLoginCheck(UserVO uv);
	List<UserVO> getUserList(String skey, String addSql, int page);
	int getBoardCount(String skey, String addSql);
}
