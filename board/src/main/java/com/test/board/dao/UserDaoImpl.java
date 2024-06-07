package com.test.board.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Map<String, Object> loginCheck(Map<String, Object> userInfo) {
		return userMapper.loginCheck(userInfo);
	}
}
