package com.test.spring_test_240605.board.dao;

import java.util.List;
import java.util.Map;

public interface boardDao {
    List<Map<String, String>> getBoardList();

    Map<String, String> getBoardDetail(int brdNo);
}
