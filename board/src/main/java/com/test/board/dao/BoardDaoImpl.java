package com.test.board.dao;

import com.test.board.dao.BoardDao;
import com.test.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Map<String, Object>> searchBoard(Map<String, Object> params) {
        return boardMapper.searchBoard(params);
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        return boardMapper.countBoard(params);
    }

    @Override
    public Map<String, Object> detailView(int param) {
        return boardMapper.detailView(param);
    }

    @Override
    public void registContent(Map<String, Object> param) {
        boardMapper.registContent(param);
    }
}
