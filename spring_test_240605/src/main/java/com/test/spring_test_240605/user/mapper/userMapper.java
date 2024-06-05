package com.test.spring_test_240605.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface userMapper {
    Map<String, String> loginCheck(Map<String, String> userIdPw);

    Map<String, Object> getUserInfo(String pid);
}
