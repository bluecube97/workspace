package com.test.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SqlSession session;

    private static final String ns = "com.test.board.mapper.userMapper"; // namespace

    @Override
    public Map<String, String> loginCheck(Map<String, String> userInfo) {
        return session.selectOne(ns + ".login", userInfo);
    }
}
