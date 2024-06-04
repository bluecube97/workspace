package com.test.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String, String>> getBoardList();
	Map<String, Object> getBoardDetail(int boardNo);
}
