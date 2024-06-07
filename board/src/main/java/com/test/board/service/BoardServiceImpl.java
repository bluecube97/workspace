package com.test.board.service;

import com.test.board.dao.BoardDao;
import com.test.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<Map<String, Object>> searchBoard(Map<String, Object> params) {
        return boardDao.searchBoard(params);
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        return boardDao.countBoard(params);
    }

    @Override
    public Map<String, Object> detailView(int param) {
        return boardDao.detailView(param);
    }

    @Override
    public void registContent(Map<String, Object> param) {
        boardDao.registContent(param);
    }
}
