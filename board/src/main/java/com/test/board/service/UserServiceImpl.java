package com.test.board.service;

import com.test.board.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean loginCheck(Map<String, String> userInfo) {
        boolean result = false;
        if (userDao.loginCheck(userInfo) != null) {
            return true;
        }
        return result;
    }
}
