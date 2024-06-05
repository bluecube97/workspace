package com.test.spring_test_240605.user.dao;

import com.test.spring_test_240605.user.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class userDaoImpl implements userDao {

    @Autowired
    private userMapper usermapper;

    @Override
    public Map<String, String> loginCheck(Map<String, String> userIdPw) {
        return usermapper.loginCheck(userIdPw);
    }

    @Override
    public Map<String, Object> getUserInfo(String pid) {
        Map<String, Object> userInfo = usermapper.getUserInfo(pid);
        switch (String.valueOf(userInfo.get("deptno"))) {
            case "1":
                userInfo.put("deptno", "관리자");
                break;
            case "2":
                userInfo.put("deptno", "경영");
                break;
            case "3":
                userInfo.put("deptno", "인사");
                break;
            case "4":
                userInfo.put("deptno", "기획");
                break;
            case "5":
                userInfo.put("deptno", "법무");
                break;
            case "6":
                userInfo.put("deptno", "영업");
                break;
        }
        return userInfo;
    }
}
