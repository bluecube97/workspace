package com.test.board.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public boolean loginCheck(Map<String, String> userInfo) {
		boolean result = false;
		if(userdao.loginCheck(userInfo) != null) {
			result = true;
		}
		return result;
	}
}
