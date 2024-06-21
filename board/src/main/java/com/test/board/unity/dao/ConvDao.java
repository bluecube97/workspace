package com.test.board.unity.dao;

import java.util.Map;

public interface ConvDao {
    Map<String, String> getConv(String scriptPath, String userConv);
}
