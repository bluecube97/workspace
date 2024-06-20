package com.test.board.unity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;

@RequestMapping("/api/conv")
@RestController
public class ConvController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/pythonPath")
    public String getPythonPath() {
        String path = servletContext.getRealPath("/resource/python/game/connectionManager.py");
        System.out.println(path);
        return path;
    }

    @GetMapping("/pythonWorkSpace")
    public String getPythonWorkSpace(){
        System.out.println(servletContext.getRealPath(""));
        return servletContext.getRealPath("");
    }
}
