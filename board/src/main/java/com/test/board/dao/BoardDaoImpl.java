package com.test.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.mapper.BoardMapper;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<Map<String, String>> getBoardList() {
		return boardMapper.getBoardList();
	}

}
