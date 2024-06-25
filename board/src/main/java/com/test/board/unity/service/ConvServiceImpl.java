package com.test.board.unity.service;

import com.test.board.unity.dao.ConvDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Map;

@Service
public class ConvServiceImpl implements ConvService {

    @Autowired
    private ConvDao convDao;
    @Autowired
    private ServletContext servletContext;

    @Override
    public Map<String, String> getConv(String userConv) {
        String scriptPath = servletContext.getRealPath("/resource/python/game/connectionManager.py");
        String jsonPath = servletContext.getRealPath("/resource/json/game/conversation.json");
        return convDao.getConv(scriptPath, userConv, jsonPath);
    }
}