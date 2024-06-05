package com.test.spring_test_240605.user.service;

import java.util.Map;

public interface userService {
    boolean loginCheck(Map<String, String> userIdPw);

    Map<String, Object> getUserInfo(String pid);
}
