package com.test.board.mapper;

import java.util.Map;

public interface UserMapper {
	Map<String, String> loginCheck(Map<String, String> userInfo);
}
