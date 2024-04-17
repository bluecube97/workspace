package com.mvc.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.mvc.board.vo.boardRegeditVO;
import com.mvc.board.vo.boardSearchVO;

public interface boardDAO {
	
	int getBoardListCnt(boardSearchVO bv);

	List<HashMap<String, Object>> getBoardList(boardSearchVO bv);

	List<HashMap<String, Object>> getTodaysList(int userNo);

	void increaseHit(int parseInt);

	HashMap<String, Object> getBoardDetail(String brdNo);

	void regeditContents(boardRegeditVO bv);

	int getMyContentNo(boardRegeditVO bv, HttpServletResponse resp);

	void updateContents(String brdTitle, String brdMemo, String brdNo);
	
	
}
