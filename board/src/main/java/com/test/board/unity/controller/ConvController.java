package com.test.board.unity.controller;

import com.test.board.unity.service.ConvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Map;

@RequestMapping("/api/conv")
@RestController
public class ConvController {

    @Autowired
    private ConvService convService;

    @PostMapping("/get")
    public String getConv(@RequestBody String userConv) {
        return convService.getConv(userConv);
    }
}
