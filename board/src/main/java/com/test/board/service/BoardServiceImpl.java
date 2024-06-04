package com.test.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Map<String, String>> getBoardList() {
		List<Map<String, String>> blist = boardDao.getBoardList();
		System.out.println(blist);
		return blist;
	}

	@Override
	public Map<String, Object> getBoardDetail(int boardNo) {
		Map<String, Object> detail = boardDao.getBoardDetail(boardNo);
		return detail;
	}

}
