package com.user.dao;

import java.util.HashMap;
import java.util.List;

import com.user.vo.userVO;

public interface userDAO {
	userVO getLoginCheck(userVO uv);
	List<userVO> getUserList(String skey, String addSql, int page);
	int getBoardCount(String skey, String addSql);
	int IdCheck(String id);
	List<HashMap<String, Object>> getJobList();

}
