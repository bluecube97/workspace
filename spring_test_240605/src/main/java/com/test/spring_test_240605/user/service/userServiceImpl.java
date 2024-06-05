package com.test.spring_test_240605.user.service;

import com.test.spring_test_240605.user.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDao userdao;

    @Override
    public boolean loginCheck(Map<String, String> userIdPw) {
        boolean result = false;
        if(userdao.loginCheck(userIdPw) != null) {
            result = true;
        }
        return result;
    }

    @Override
    public Map<String, Object> getUserInfo(String pid) {
        return userdao.getUserInfo(pid);
    }
}
