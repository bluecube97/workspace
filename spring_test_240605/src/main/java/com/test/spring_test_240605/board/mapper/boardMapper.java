package com.test.spring_test_240605.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface boardMapper {
    List<Map<String, String>> getBoardList();

    Map<String, String> getBoardDetail(int brdNo);
}
