package com.test.spring_test_240605.board.service;

import java.util.List;
import java.util.Map;

public interface boardService {
    List<Map<String, String>> getBoardList();

    Map<String, String> getBoardDetail(int brdNo);
}
