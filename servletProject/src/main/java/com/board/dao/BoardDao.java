package com.board.dao;

import java.util.List;

import com.board.vo.BoardVO;

public interface BoardDao {
	List<BoardVO> getBoardList(String skey, String addSql, int page);
	BoardVO getBoardDetail(String brdNo);
	int getBoardCount(String skey, String addSql);
}
