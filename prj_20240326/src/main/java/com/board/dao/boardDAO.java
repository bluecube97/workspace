package com.board.dao;

import java.util.List;

import com.board.vo.boardVO;
import com.user.vo.userVO;

public interface boardDAO {
	List<boardVO> getBoardList(String skey, String addSql, int page);
	boardVO getBoardDetail(String brdNo);
	int getBoardCount(String skey, String addSql);

	int boardRegidit(int userNo, String brdTitle, String brdMemo);
	int getLastBoardNo(int userNo);
	int boardUpdate(userVO uv, String brdTitle, String brdMemo, int brdNo);
	void boardDelete(int brdNo);
}
