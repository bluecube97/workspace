package com.test.board.dao;

import java.util.Map;

public interface UserDao {
    Map<String, Object> loginCheck(Map<String, Object> params);
}
