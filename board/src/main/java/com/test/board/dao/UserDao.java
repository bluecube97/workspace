package com.test.board.dao;

import java.util.Map;

public interface UserDao {
    Map<String, String> loginCheck(Map<String, String> userInfo);
}
