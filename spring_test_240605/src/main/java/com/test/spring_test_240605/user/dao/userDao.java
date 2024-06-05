package com.test.spring_test_240605.user.dao;

import java.util.Map;

public interface userDao {
    Map<String, String> loginCheck(Map<String, String> userIdPw);

    Map<String, Object> getUserInfo(String pid);
}
