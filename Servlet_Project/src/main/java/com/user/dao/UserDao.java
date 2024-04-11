package com.user.dao;

import java.util.List;

import com.user.vo.UserVO;

public interface UserDao {
	UserVO getLoginCheck(UserVO uv);
	List<UserVO> getUserList(String nmkey, int page);
	int getUserCount(String nmkey);
}
