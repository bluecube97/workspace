package com.test.board.mapper;

import java.util.Map;

public interface UserMapper {
	Map<String, Object> loginCheck(Map<String, Object> params);
}
