package com.test.spring_test_240605.board.dao;

import com.test.spring_test_240605.board.mapper.boardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class boardDaoImpl implements boardDao{

    @Autowired
    private boardMapper brdmapper;

    @Override
    public List<Map<String, String>> getBoardList() {
        return brdmapper.getBoardList();
    }

    @Override
    public Map<String, String> getBoardDetail(int brdNo) {
        return brdmapper.getBoardDetail(brdNo);
    }
}
