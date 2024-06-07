package com.test.board.mapper;

import java.util.List;
import java.util.Map;

public interface BoardMapper {
    List<Map<String, Object>> searchBoard(Map<String, Object> params);

    int countBoard(Map<String, Object> params);

    Map<String, Object> detailView(int param);

    void registContent(Map<String, Object> param);
}