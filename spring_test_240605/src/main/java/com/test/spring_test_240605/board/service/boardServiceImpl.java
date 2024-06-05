package com.test.spring_test_240605.board.service;

import com.test.spring_test_240605.board.dao.boardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class boardServiceImpl implements boardService {

    @Autowired
    private boardDao brddao;

    @Override
    public List<Map<String, String>> getBoardList() {
        return brddao.getBoardList();
    }

    @Override
    public Map<String, String> getBoardDetail(int brdNo) {
        return brddao.getBoardDetail(brdNo);
    }
}
